package com.Nitish.Quizapp.questionsApplication.controller;



import com.Nitish.Quizapp.questionsApplication.model.Question;
import com.Nitish.Quizapp.questionsApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions") // Add a leading "/" here
    public ResponseEntity< List<Question>> getAllQuestion() {
        return questionService.getAllQuestions();

    }
    @GetMapping("category")
    public ResponseEntity< List<Question>> getQuestionByCategory(@RequestParam String category){
        System.out.println("Received category "+category);
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity< String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}