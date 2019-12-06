package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thoughtsonjava.annotations.dao.AuthorRepository;
import org.thoughtsonjava.annotations.dao.PublisherRepository;

@SpringBootTest
class PublisherTests {

	@Autowired
	PublisherRepository publisherRepository;

	@Test
	void testSave() {
		Publisher publisher = new Publisher();
		publisher.setName("testAuthor");
		Long savedId = publisherRepository.save(publisher).getId();

		assert(publisherRepository.existsById(savedId));
		Publisher p = publisherRepository.findById(savedId).orElse(null);

		assert (p != null);
		assert (p.getName().equals("testAuthor"));
	}

}
