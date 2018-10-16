package lti.quiz.ctrl;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lti.quiz.entity.Quiz;
import lti.quiz.service.QuizService;

@Controller
public class QuizController {

	@Autowired
	private QuizService service;

	@RequestMapping(value = "quiz.quiz" , method = RequestMethod.GET)
	public String play(@RequestParam("choice") String choice, Map model, HttpSession session) {
		List<Quiz> questions = (List<Quiz>) session.getAttribute("QUIZ");
		List<String> scores = (List<String>) session.getAttribute("SCORE");

		if (questions == null) {
			questions = service.loadQuiz();
			session.setAttribute("QUIZ", questions);
		}
		
		if (scores == null)
			scores = new ArrayList<>();

		if (choice != null && choice.length() == 7) {
			scores.add(choice);
			session.setAttribute("SCORE", scores);
		}

		if (scores.size() < 12) {
			Quiz question = questions.get(scores.size());
			model.put("Question", question);
			return "quiz";
		} else {
			String hero = service.getResult(scores);
			model.put("Hero", hero);
			return "result";
		}

	}
}
