package com.example.BookTracker.repository;

import com.example.BookTracker.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
