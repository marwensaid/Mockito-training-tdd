package io.github.librarymanager;


import io.github.librarymanager.model.Book;
import io.github.librarymanager.repository.BookRepository;
import io.github.librarymanager.service.BookService;
import io.github.librarymanager.service.BookServiceImpl;

public class LibraryManagerApplication {
	public static void main(String[] args) {
		BookRepository bookRepository = new BookRepository();
		BookService bookService = new BookServiceImpl(bookRepository);

		Book book1 = new Book("123", "Mockito In Action", "John Doe");
		Book book2 = new Book("456", "JUnit In Action", "Jane Doe");

		bookService.addBook(book1);
		bookService.addBook(book2);

		System.out.println("All Books: " + bookService.getAllBooks());
	}
}
