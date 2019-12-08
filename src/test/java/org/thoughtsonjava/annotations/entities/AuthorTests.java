package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class AuthorTests {

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
			author.setName("testAuthor");

			em.persist(author);
			et.commit();
		}catch (Exception ex){
			assert false;
		}
	}

}
