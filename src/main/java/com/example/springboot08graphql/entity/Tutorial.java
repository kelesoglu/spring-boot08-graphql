package com.example.springboot08graphql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false,updatable = false)
    private Author author;

    public Tutorial(){}
    public Tutorial(String title,String description,Author author){
        this.author=author;
        this.title=title;
        this.description=description;
    }
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + "]";
    }
}
