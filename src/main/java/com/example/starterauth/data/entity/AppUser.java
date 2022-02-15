package com.example.starterauth.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBDEVELOPER_COMMUNITY_USER")
public class AppUser extends UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    Long id;
    @Column(name = "FIRST_NAME")
    String firstName;
//    @Column(name = "MIDDLE_NAME")
//    String middleName;
    @Column(name = "LAST_NAME")
    String lastName;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "ACTIVE")
    String active;
    @Column(name = "CRAETED_AT")
    LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;
    @Column(name = "DELETED_AT")
    LocalDateTime deletedAt;
}
