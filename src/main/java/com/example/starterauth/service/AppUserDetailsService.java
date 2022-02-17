package com.example.starterauth.service;

import com.example.starterauth.data.entity.AppUser;
import com.example.starterauth.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
