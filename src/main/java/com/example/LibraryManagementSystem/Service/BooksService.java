package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public List<Book> getBooks() {
        return booksRepository.findAll();
    }

    public Book findBookById(@RequestParam int id) {
        return booksRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id:" + id + " not found"));
    }

    public Book saveBook(Book book) {
        return booksRepository.save(book);
    }

    public void updateBookTitle(int id, String newTitle) {
        Book book = findBookById(id);
        book.setName(newTitle);
        booksRepository.save(book);
    }

    public Book findByAuthor(String authorName) {
        return booksRepository.findByAuthor(authorName).orElseThrow(() -> new RuntimeException("Book author with name: " + authorName + " not found"));
    }

    public Book findByName(String name) {
        return booksRepository.findByName(name).orElseThrow(() -> new RuntimeException("Book: " + name + " not found"));
    }


}
