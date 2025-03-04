package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping("/findAll")
    public List<Book> getBooks() {
        return booksService.getBooks();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable int id) {
        return booksService.findBookById(id);
    }

    @GetMapping("/findByName")
    public Book findByName(@RequestParam String name) {
        return booksService.findByName(name);
    }

    @GetMapping("/findByAuthor")
    public Book findByAuthor(@RequestParam String author) {
        return booksService.findByAuthor(author);
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return booksService.saveBook(book);
    }

    @PutMapping("/updateBookTitle/{id}")
    public void updateBookTitle(@PathVariable int id, @RequestParam String newTitle) {
        booksService.updateBookTitle(id, newTitle);
    }
}
