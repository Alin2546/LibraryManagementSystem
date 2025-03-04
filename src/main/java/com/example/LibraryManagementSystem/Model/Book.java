package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String name;
}
