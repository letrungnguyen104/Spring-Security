package com.security.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @Column(name = "fullname")
    String fullname;

//    @Column(name = "email")
    String email;

//    @Column(name = "username")
    String username;

//    @Column(name = "password")
    String password;

    Set<String> roles;
}
