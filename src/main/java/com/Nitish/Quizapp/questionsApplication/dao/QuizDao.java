package com.Nitish.Quizapp.questionsApplication.dao;

import com.Nitish.Quizapp.questionsApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
