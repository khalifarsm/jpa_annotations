package org.thoughtsonjava.annotations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thoughtsonjava.annotations.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
