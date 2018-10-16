package lti.quiz.repo;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.entity.User;

public interface UserRepo {
	User authenticate(LoginBean login);

	boolean register(User register);

	boolean validate(ForgetBean forget);

	boolean update(LoginBean change);
}
