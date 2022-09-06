package com.example.springboot08graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springboot08graphql.entity.Author;
import com.example.springboot08graphql.entity.Tutorial;
import com.example.springboot08graphql.repo.AuthorRepository;
import com.example.springboot08graphql.repo.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private TutorialRepository tutorialRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository,TutorialRepository tutorialRepository){
        this.authorRepository=authorRepository;
        this.tutorialRepository=tutorialRepository;
    }
    public Author createAuthor(String name,String age){
        Author author=new Author();
        author.setName(name);
        author.setAge(age);
        authorRepository.save(author);
        return author;
    }
    public Tutorial createTutorial(String title, String description,Long authorId){
        Tutorial tutorial =new Tutorial();
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        tutorial.setAuthor(new Author(authorId));
        tutorialRepository.save(tutorial);
        return tutorial;
    }
    public Boolean deleteTutorial(Long id){
        tutorialRepository.deleteById(id);
        return true;
    }
    public Tutorial updateTutorial(Long id, String title, String description)throws ChangeSetPersister.NotFoundException {
        Optional<Tutorial> optionalTutorial = tutorialRepository.findById(id);
        if (optionalTutorial.isPresent()) {
            Tutorial tutorial = new Tutorial();
            if (title != null) {
                tutorial.setTitle(title);
            }
            if (description != null)
                tutorial.setDescription(description);
            tutorialRepository.save(tutorial);
            return tutorial;
        }
        throw new ChangeSetPersister.NotFoundException();
    }
}
