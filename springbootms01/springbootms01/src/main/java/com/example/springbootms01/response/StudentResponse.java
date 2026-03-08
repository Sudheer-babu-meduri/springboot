package com.example.springbootms01.response;

import java.util.List;

import lombok.Data;

@Data
public class StudentResponse {

    Integer sid;
    String fname;
    String lname;
    int age;
    String email;

    List<Address> addresses;
}
