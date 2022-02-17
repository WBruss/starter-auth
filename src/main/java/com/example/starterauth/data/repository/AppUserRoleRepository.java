package com.example.starterauth.data.repository;

import com.example.starterauth.data.entity.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRoleRepository  extends JpaRepository<AppUserRole, Long> {
    AppUserRole findAppUserRoleByName(String roleName);
}
