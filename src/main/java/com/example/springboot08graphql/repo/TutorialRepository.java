package com.example.springboot08graphql.repo;

import com.example.springboot08graphql.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
