# Books CRUD Rest API

## Tech stack
- Java
- Spring Boot
- Maven

A Create-Read-Update-Delete Rest API about books.
The user can store, edit and delete books by providing:
- The book's unique ID (string)
- The book's author (string)
- The book's title (string)

## Endpoints
- "/books/{id}" => creates a book ( with body).
  If the ID is in the database, it updates the book.
- "/all-books" => provides all stored books
- "/books/book-{id}" => retrieves a specific book.
- "/books/delete/{id}" => deletes the specified id's book

Tested with Postman. 
Work in progress.