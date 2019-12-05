package org.thoughtsonjava.annotations.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PUBLISHERS")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books;
}
