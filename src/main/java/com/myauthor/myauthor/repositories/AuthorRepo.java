package com.myauthor.myauthor.repositories;

import com.myauthor.myauthor.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
    Author getAuthorById(Long id);
}
