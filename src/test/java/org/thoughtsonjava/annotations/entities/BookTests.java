package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thoughtsonjava.annotations.dao.AuthorRepository;
import org.thoughtsonjava.annotations.dao.BookRepository;
import org.thoughtsonjava.annotations.dao.PublisherRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootTest
class BookTests {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void testSave() {
		Author author = new Author();
		author.setName("testAuthor");
		author = authorRepository.save(author);

		Publisher publisher =  new Publisher();
		publisher.setName("p");
		publisher = publisherRepository.save(publisher);

		Book book = new Book();
		book.setTitle("testBook");
		book.setPublishingDate(LocalDate.now());
		book.setPublisher(publisher);
		book.setAuthors(new HashSet<>());
		book.getAuthors().add(author);

		Long savedBookId = bookRepository.save(book).getId();

		assert(bookRepository.existsById(savedBookId));
		Book b = bookRepository.findById(savedBookId).orElse(null);

		assert (b != null);
		assert (b.getTitle().equals("testBook"));
		assert (b.getPublisher().getName().equals(publisher.getName()));
	}

}
