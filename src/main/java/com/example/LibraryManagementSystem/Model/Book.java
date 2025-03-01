package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books_table")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String name;
}
