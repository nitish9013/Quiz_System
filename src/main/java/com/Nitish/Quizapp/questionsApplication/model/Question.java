package com.Nitish.Quizapp.questionsApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;



@Data
@Entity
@Table(name = "question")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private String category;

    @JsonProperty("question")

    private String question;
    @JsonProperty("option_a")
    private String option_a;
    @JsonProperty("option_b")
    private String option_b;
    @JsonProperty("option_c")
    private String option_c;
    @JsonProperty("option_d")
    private String option_d;

    @JsonProperty("correct_answer")
    private String correct_answer;
}