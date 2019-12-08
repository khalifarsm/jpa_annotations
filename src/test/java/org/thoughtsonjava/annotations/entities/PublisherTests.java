package org.thoughtsonjava.annotations.entities;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class PublisherTests {

	@Test
	void testSave() {
		EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
				.createEntityManagerFactory("annotations");
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et;
		try {
			et = em.getTransaction();
			et.begin();
			Publisher publisher = new Publisher();
			publisher.setName("testPublisher");

			em.persist(publisher);
			et.commit();
		}catch (Exception ex){
			assert false;
		}
	}

}
