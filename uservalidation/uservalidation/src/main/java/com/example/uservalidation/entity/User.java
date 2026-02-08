package com.example.uservalidation.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users"
//       uniqueConstraints = {
//           @UniqueConstraint(columnNames = "email"),
//           @UniqueConstraint(columnNames = "phone_number"),
//           @UniqueConstraint(columnNames = "user_name")
       )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

//    @Column(nullable = false, unique = true)
    private String email;

//    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    // Getters and Setters
    public Long getId() { return id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
