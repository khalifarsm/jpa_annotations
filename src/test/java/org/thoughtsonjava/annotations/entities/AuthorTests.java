package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thoughtsonjava.annotations.dao.AuthorRepository;
import org.thoughtsonjava.annotations.dao.BookRepository;

@SpringBootTest
class AuthorTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void testSave() {
		Author author = new Author();
		author.setName("testAuthor");
		Long savedAuthorId = authorRepository.save(author).getId();

		assert(authorRepository.existsById(savedAuthorId));
		Author a = authorRepository.findById(savedAuthorId).orElse(null);

		assert (a != null);
		assert (a.getName().equals("testAuthor"));
	}

}
