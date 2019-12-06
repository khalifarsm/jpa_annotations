package org.thoughtsonjava.annotations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thoughtsonjava.annotations.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
