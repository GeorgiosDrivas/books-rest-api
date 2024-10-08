package com.georgiosDrivas.books.controllers;

import com.georgiosDrivas.books.model.BookModel;
import com.georgiosDrivas.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService){
        this.bookService = bookService;
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

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookModel> createUpdateBook(@PathVariable final String isbn, @RequestBody final BookModel book){
        book.setIsbn(isbn);
        final boolean isBookExists = bookService.isBookExists(book);
        final BookModel savedBook = bookService.save(book);

        if(isBookExists){
            return new ResponseEntity<BookModel>(savedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<BookModel>(savedBook, HttpStatus.CREATED);
        }

    }

    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable final String isbn){
        bookService.deleteBookById(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
