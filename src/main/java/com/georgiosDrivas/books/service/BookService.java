package com.georgiosDrivas.books.service;

import com.georgiosDrivas.books.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookModel save(BookModel book);

    Optional<BookModel> findById(String isbn);

    List<BookModel> listAllBooks();

    boolean isBookExists(BookModel book);
}
