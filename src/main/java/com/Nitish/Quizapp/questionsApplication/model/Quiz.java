package com.Nitish.Quizapp.questionsApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


 @Entity
 @Data
public class Quiz {
public void setTitle(String title) {
    this.title = title;
}

public void setQuestions(List<Question> questions) {
    this.questions = questions;
}
     @Id
     @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions ;
}
