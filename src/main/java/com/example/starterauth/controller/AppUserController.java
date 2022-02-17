package com.example.starterauth.controller;

import com.example.starterauth.data.entity.AppUser;
import com.example.starterauth.data.entity.AppUserRole;
import com.example.starterauth.data.model.AddRoleToUser;
import com.example.starterauth.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok()
                .body(userService.getAppUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser){
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                .path("/api/user/save")
                .toUriString()
        );
        return ResponseEntity.created(uri)
                .body(userService.saveAppUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppUserRole> saveAppRole(@RequestBody AppUserRole appUserRole){
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/role/save")
                        .toUriString()
        );
        return ResponseEntity.created(uri)
                .body(userService.saveAppUserRole(appUserRole));
    }

    @PostMapping("/user/addrole")
    public ResponseEntity<AppUserRole> addRoleToUser(@RequestBody AddRoleToUser addRoleToUser){
        userService.addRoleToAppUser(addRoleToUser.getEmail(), addRoleToUser.getRole());
        return ResponseEntity.ok().build();
    }


}
