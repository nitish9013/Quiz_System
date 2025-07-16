package com.Nitish.Quizapp.questionsApplication.service;

import com.Nitish.Quizapp.questionsApplication.model.Question;
import com.Nitish.Quizapp.questionsApplication.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ResponseEntity<List<Question>> getAllQuestions() {
    try {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    } catch(Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Optional<Question>> getQuestionById(Integer id) {

        try {
            return new ResponseEntity<>(questionDao.findById(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity< List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity< String> addQuestion(Question question) {

      questionDao.save(question);
      return  new ResponseEntity<>( "success",HttpStatus.CREATED);
    }
}