package io.github.librarymanager.service;


import io.github.librarymanager.model.Book;
import io.github.librarymanager.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn).orElse(null);
    }

    @Override
    public void removeBookByIsbn(String isbn) {
        bookRepository.removeBookByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}