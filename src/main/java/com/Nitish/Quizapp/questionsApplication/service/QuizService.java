package com.Nitish.Quizapp.questionsApplication.service;

import com.Nitish.Quizapp.questionsApplication.model.Question;
import com.Nitish.Quizapp.questionsApplication.dao.QuestionDao;
import com.Nitish.Quizapp.questionsApplication.dao.QuizDao;
import com.Nitish.Quizapp.questionsApplication.model.QuestionWrapper;
import com.Nitish.Quizapp.questionsApplication.model.Quiz;
import com.Nitish.Quizapp.questionsApplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {
        // Print the parameters received
        System.out.println("Category: " + category);
        System.out.println("Number of Questions: " + numQ);
        System.out.println("Title: " + title);

        // Check if QuestionDao is injected properly
        System.out.println("QuestionDao: " + questionDao);

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        // Print fetched questions
        System.out.println("Questions fetched: " + questions);

        // If null or empty, return an error response
        if (questions == null || questions.isEmpty()) {
            return new ResponseEntity<>("Error: No questions found for category " + category, HttpStatus.BAD_REQUEST);
        }
        questions = questions.subList(0, Math.min(numQ, questions.size()));


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        // Print before saving the quiz
        System.out.println("Quiz object before saving: " + quiz);

        try {
            quizDao.save(quiz);
            System.out.println("Quiz saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error saving quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz=  quizDao.findById(id);
        List<Question> questionsFromDB =quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser =new ArrayList<>();
        for(Question q:questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption_a(),q.getOption_b(),q.getOption_c(),q.getOption_d());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {


       Quiz quiz=quizDao.findById(id).get();
       List<Question> questions=quiz.getQuestions();
       int right=0;
       int i=0;
       for(Response response :responses){

           System.out.println("Response value: " + response.getResponse());
           if(response.getResponse()!=null &&response.getResponse().equals(questions.get(i).getCorrect_answer()))
               right ++;
           i++;
       }
       return  new ResponseEntity<>(right,HttpStatus.OK);
    }
}
