package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // Create
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // Read
    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    // Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return repository.save(book);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Book Deleted Successfully";
    }
}