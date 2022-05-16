package com.mbsystems.quickpolldemo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "username", nullable = false, unique = true, length = 30)
    private String username;

    @NotEmpty
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @NotEmpty
    @Column(name = "firstname", nullable = false, length = 40)
    private String firstname;

    @NotEmpty
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "admin", nullable = false, length = 70)
    private Admin admin;

}