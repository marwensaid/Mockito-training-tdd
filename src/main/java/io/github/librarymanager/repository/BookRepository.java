package io.github.librarymanager.repository;

import io.github.librarymanager.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    public void removeBookByIsbn(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}