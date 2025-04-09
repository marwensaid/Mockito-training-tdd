package io.github.librarymanager;


import io.github.librarymanager.model.Book;
import io.github.librarymanager.repository.BookRepository;
import io.github.librarymanager.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddBook() {
		Book book = new Book("123", "Mockito In Action", "John Doe");
		bookService.addBook(book);
		verify(bookRepository, times(1)).addBook(book);
	}

	@Test
	void testFindBookByIsbn() {
	}

	@Test
	void testRemoveBookByIsbn() {
	}

	@Test
	void testGetAllBooks() {
	}
}