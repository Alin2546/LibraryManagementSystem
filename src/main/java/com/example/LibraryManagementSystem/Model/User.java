package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
}
