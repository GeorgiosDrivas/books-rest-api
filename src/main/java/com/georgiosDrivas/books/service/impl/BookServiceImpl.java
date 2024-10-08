package com.georgiosDrivas.books.service.impl;

import com.georgiosDrivas.books.model.BookModel;
import com.georgiosDrivas.books.repositories.BookRepository;
import com.georgiosDrivas.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookModel save(final BookModel book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<BookModel> findById(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<BookModel> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean isBookExists(BookModel book) {
        return bookRepository.existsById(book.getIsbn());
    }

    @Override
    public void deleteBookById(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
