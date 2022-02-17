package com.example.starterauth.service;

import com.example.starterauth.data.entity.AppUser;
import com.example.starterauth.data.entity.AppUserRole;

import java.util.List;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser);
    AppUserRole saveAppUserRole(AppUserRole appUserRole);
    void addRoleToAppUser(String userName, String roleName);
    AppUser getAppUser(String userName);
    List<AppUser> getAppUsers();

}
