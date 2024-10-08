package com.georgiosDrivas.books.repositories;

import com.georgiosDrivas.books.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, String> { // The model and the type of the ID

}
