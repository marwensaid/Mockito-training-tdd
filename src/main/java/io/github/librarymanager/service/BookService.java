package io.github.librarymanager.service;


import io.github.librarymanager.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book findBookByIsbn(String isbn);
    void removeBookByIsbn(String isbn);
    List<Book> getAllBooks();
}