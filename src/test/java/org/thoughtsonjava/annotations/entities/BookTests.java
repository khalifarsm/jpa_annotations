package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;

class BookTests {

	@Test
	void testSave() {
		EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
				.createEntityManagerFactory("annotations");
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et;
		try {
			et = em.getTransaction();
			et.begin();

			Author author = new Author();
			author.setName("a");
			em.persist(author);

			Publisher publisher =  new Publisher();
			publisher.setName("p");
			em.persist(publisher);

			Book book = new Book();
			book.setTitle("testBook");
			book.setPublishingDate(LocalDate.now());
			book.setPublisher(publisher);
			book.setAuthors(new HashSet<>());
			book.getAuthors().add(author);

			em.persist(book);
			et.commit();
		}catch (Exception ex){
			ex.printStackTrace();
			assert false;
		}
	}

}
