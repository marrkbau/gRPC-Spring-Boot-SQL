package com.example.accenture.servidor.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String genre;
}
