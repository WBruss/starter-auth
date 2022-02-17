package com.example.starterauth.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBDEVELOPER_COMMUNITY_USER_ROLES")
public class AppUserRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Long id;
    @Column(name = "ROLE_NAME")
    private String name;
}
