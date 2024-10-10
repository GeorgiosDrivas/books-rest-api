package com.georgiosDrivas.books.service;

import com.georgiosDrivas.books.model.BookModel;
import com.georgiosDrivas.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookModel save(final BookModel book) {
        return bookRepository.save(book);
    }

    public Optional<BookModel> findById(String isbn) {
        return bookRepository.findById(isbn);
    }

    public List<BookModel> listAllBooks() {
        return bookRepository.findAll();
    }

    public boolean isBookExists(BookModel book) {
        return bookRepository.existsById(book.getIsbn());
    }

    public void deleteBookById(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
