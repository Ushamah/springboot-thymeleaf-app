package com.ushwamala.thymeleaf.springboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="first_name")
    @NonNull
    private  String firstName;

    @Column(name ="last_name")
    @NonNull
    private  String lastName;

    @Column(name ="email")
    @NonNull
    private  String email;
}
