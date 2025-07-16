package com.Nitish.Quizapp.questionsApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionWrapper {
    @JsonProperty("id")
    private Integer id;
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
//    @JsonProperty("correct_answer")
//    private String correct_answer;

    public QuestionWrapper(Integer id, String question, String option_a, String option_b, String option_c, String option_d) {
        this.id = id;
        this.question = question;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
//        this.correct_answer=correct_answer;
    }
}
