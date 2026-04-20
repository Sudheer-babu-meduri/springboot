package com.example.yspringsecurityyoutube01.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userentity")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String role;  // Always USER for signup
}