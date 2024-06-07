package com.example.accenture.servidor.repositories;

import com.example.accenture.servidor.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}