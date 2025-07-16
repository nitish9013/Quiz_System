package com.Nitish.Quizapp.questionsApplication.controller;

import com.Nitish.Quizapp.questionsApplication.model.Question;
import com.Nitish.Quizapp.questionsApplication.model.QuestionWrapper;
import com.Nitish.Quizapp.questionsApplication.model.Response;
import com.Nitish.Quizapp.questionsApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
return quizService.CreateQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
  return  quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){

            System.out.println("full request body: " + responses);
        for (Response response : responses) {
            System.out.println("User Answer: " + response.getResponse());
        }


        return quizService.calculateResult(id,responses);
    }
//@PostMapping("submit/{id}")
//public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody String rawRequest) {
//    System.out.println("Raw JSON Received: " + rawRequest);
//    return ResponseEntity.ok(0); // Just for debugging
//}
}
