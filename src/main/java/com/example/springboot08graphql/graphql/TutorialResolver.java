package com.example.springboot08graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.springboot08graphql.entity.Author;
import com.example.springboot08graphql.entity.Tutorial;
import com.example.springboot08graphql.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
    @Autowired
    private AuthorRepository authorRepository;
    public TutorialResolver(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    public Author getAuthor(Tutorial tutorial){
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }

}
