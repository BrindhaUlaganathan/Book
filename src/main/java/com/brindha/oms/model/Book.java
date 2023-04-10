package com.brindha.oms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "year_of_publication")
    private Integer yearOfPublication;
    @Column(name = "book_type")
    private String bookType;

    public Book(String name, String description, Integer yearOfPublication, String bookType) {
        this.name = name;
        this.description = description;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
    }
}

