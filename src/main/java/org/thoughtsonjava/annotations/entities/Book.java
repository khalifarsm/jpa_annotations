package org.thoughtsonjava.annotations.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    private String title;

    private LocalDate publishingDate;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> authors;

    @ManyToOne
    private Publisher publisher;
}
