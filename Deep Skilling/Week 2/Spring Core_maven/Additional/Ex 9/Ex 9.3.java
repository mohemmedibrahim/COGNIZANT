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

    private BookRepository bookRepository;




    @GetMapping

    public List<Book> getBooks(){


        return bookRepository.findAll();


    }




    @PostMapping

    public Book addBook(@RequestBody Book book){


        return bookRepository.save(book);


    }




    @DeleteMapping("/{id}")

    public String deleteBook(@PathVariable int id){


        bookRepository.deleteById(id);


        return "Book deleted";


    }


}