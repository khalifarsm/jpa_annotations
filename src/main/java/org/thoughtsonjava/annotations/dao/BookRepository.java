package org.thoughtsonjava.annotations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thoughtsonjava.annotations.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
