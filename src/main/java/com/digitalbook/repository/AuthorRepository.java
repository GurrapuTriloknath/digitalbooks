package com.digitalbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digitalbook.entity.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Book, Integer> {
}
