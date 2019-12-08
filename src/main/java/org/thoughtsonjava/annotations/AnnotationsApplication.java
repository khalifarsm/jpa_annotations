package org.thoughtsonjava.annotations;

import org.thoughtsonjava.annotations.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AnnotationsApplication {

	public static void main(String[] args) {
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
