package lti.quiz.repo;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lti.quiz.entity.Quiz;

@Repository
public class QuizRepoImpl implements QuizRepo {

	@Autowired
	private SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<Quiz> loadQuiz() {
		Session session = factory.getCurrentSession();
		List<Quiz> quizes = session.createQuery("from Quiz order by id").list();// in create Query, we write Entity names
		return quizes;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public String getResult(String code) {
		Session session = factory.getCurrentSession();
		SQLQuery sql = session.createSQLQuery("select hero from result where code= '" + code + "'");
		return (String) sql.uniqueResult();
	}
	
}
