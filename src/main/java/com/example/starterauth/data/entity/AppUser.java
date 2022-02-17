package com.example.starterauth.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBDEVELOPER_COMMUNITY_USER")
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
//    @Column(name = "MIDDLE_NAME")
//    String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "CRAETED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppUserRole> roles = new ArrayList<>();
}
