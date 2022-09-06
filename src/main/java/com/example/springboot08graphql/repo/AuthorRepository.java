package com.example.springboot08graphql.repo;

import com.example.springboot08graphql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
