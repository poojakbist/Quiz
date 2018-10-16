package lti.quiz.repo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.entity.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private SessionFactory factory;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public User authenticate(LoginBean login) {
		Session session = factory.getCurrentSession();
		Query hql = session.createQuery("from User where email=:eml and password=:pwd");
		hql.setParameter("eml", login.getEmail());
		hql.setParameter("pwd", login.getPassword());
		return (User) hql.uniqueResult();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean register(User register) {
		Session session = factory.getCurrentSession();
		session.save(register);
		return true;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean validate(ForgetBean forget) {
		Session session = factory.getCurrentSession();
		User user = (User) session.get(User.class, forget.getEmail());
		if (user.getAnswer().equals(forget.getAnswer()))
			return true;
		else
			return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean update(LoginBean change) {
		Session session = factory.getCurrentSession();
		User user = (User) session.get(User.class, change.getEmail());
		user.setPassword(change.getPassword());
		return true;
	}

}
