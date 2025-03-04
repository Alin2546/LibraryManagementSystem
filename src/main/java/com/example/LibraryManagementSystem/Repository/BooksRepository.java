package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByAuthor(String author);

    Optional<Book> findByName(String name);

}
