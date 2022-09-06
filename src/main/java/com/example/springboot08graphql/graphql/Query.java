package com.example.springboot08graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springboot08graphql.entity.Author;
import com.example.springboot08graphql.entity.Tutorial;
import com.example.springboot08graphql.repo.AuthorRepository;
import com.example.springboot08graphql.repo.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;

    @Autowired
    public Query(AuthorRepository authorRepository,TutorialRepository tutorialRepository){
        this.authorRepository=authorRepository;
        this.tutorialRepository=tutorialRepository;
    }
    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
    public Iterable<Tutorial> findAllTutorials(){
        return tutorialRepository.findAll();
    }

    public long countAuthors(){
        return authorRepository.count();
    }
    public long countTutorials(){
        return tutorialRepository.count();
    }
}
