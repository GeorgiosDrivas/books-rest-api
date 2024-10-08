package com.georgiosDrivas.books.controllers;

import com.georgiosDrivas.books.model.BookModel;
import com.georgiosDrivas.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService){
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookModel> createBook(@PathVariable final String isbn, @RequestBody final BookModel book){
        book.setIsbn(isbn);
        final BookModel savedBook = bookService.create(book);
        return new ResponseEntity<BookModel>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookModel> retrieveBook(@PathVariable final String isbn){
        final Optional<BookModel> foundBook = bookService.findById(isbn);
        return foundBook.map(book -> new ResponseEntity<BookModel>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND));
    };

    @GetMapping(path = "/books")
    public ResponseEntity<List<BookModel>> listBooks(){
        return new ResponseEntity<List<BookModel>>(bookService.listAllBooks(), HttpStatus.OK);
    }
}
