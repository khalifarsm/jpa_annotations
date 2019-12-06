package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thoughtsonjava.annotations.dao.BookRepository;

@SpringBootTest
class BookTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testSave() {
		Book book = new Book();
		book.setTitle("testBook");
		Long savedBookId = bookRepository.save(book).getId();

		assert(bookRepository.existsById(savedBookId));
		Book b = bookRepository.findById(savedBookId).orElse(null);

		assert (b != null);
		assert (b.getTitle().equals("testBook"));
	}

}
