package lti.quiz.repo;

import java.util.List;


import lti.quiz.entity.Quiz;

public interface QuizRepo {
	List<Quiz> loadQuiz();
	
	String getResult(String code);
}
