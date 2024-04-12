package com.library.bookservice;


import com.library.bookservice.model.Book;
import com.library.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository repository;

	public BookServiceApplication(BookRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book(1L,"Dünyanın Gözü", "Robert Jordan",2000,  "İthaki Yayınevi", "123456");
		Book book2 = new Book(2L,"Yüzüklerin Efendisi", "J.R.R Tolkien", 1960, "Metis Yayıncılık", "456789");
		Book book3 = new Book(3L,"Harry Potter ve Felsefe Taşı","J. K. Rowling", 1997,  "YKB Yayınları", "987654");

		List<Book> bookList = repository.saveAll(Arrays.asList(book1, book2, book3));

		System.out.println(bookList);
	}

}
