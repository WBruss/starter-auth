package com.example.starterauth.service;

import com.example.starterauth.data.entity.AppUser;
import com.example.starterauth.data.entity.AppUserRole;
import com.example.starterauth.data.repository.AppUserRepository;
import com.example.starterauth.data.repository.AppUserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final AppUserRoleRepository appUserRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(
                appUserRole -> authorities.add(new SimpleGrantedAuthority(appUserRole.getName()))
        );

        return new org.springframework.security.core.userdetails.User(
                appUser.getEmail(),
                appUser.getPassword(),
                authorities
                );
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving user {}", appUser.getEmail());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setActive("1");
        appUser.setCreatedAt(LocalDateTime.now());
        appUser.setUpdatedAt(LocalDateTime.now());
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUserRole saveAppUserRole(AppUserRole appUserRole) {
        return appUserRoleRepository.save(appUserRole);
    }

    @Override
    public void addRoleToAppUser(String userName, String roleName) {

        // TODO: Handle validations
        AppUser appUser = appUserRepository.findAppUserByEmail(userName).get();
        AppUserRole appUserRole = appUserRoleRepository.findAppUserRoleByName(roleName);
        appUser.getRoles().add(appUserRole);
    }

    @Override
    public AppUser getAppUser(String userName) {
        return appUserRepository.findAppUserByEmail(userName).get();
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

}
