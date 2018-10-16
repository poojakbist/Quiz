package lti.quiz.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.entity.User;
import lti.quiz.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service; // cause controller talks to service

	@RequestMapping(value = "login.quiz", method = RequestMethod.POST)
	public String authenticate(LoginBean login, Map model, HttpSession session) {
		User user = service.authenticate(login);
		if (user != null) {
			// Login successful
			session.setAttribute("USER", user);
			return "dashboard";
		} else {
			// login failed
			model.put("Info", "Invalid Email ID/Password");
			return "index";
		}
	}

	@RequestMapping(value = "register.quiz", method = RequestMethod.POST)
	public String register(User user, Map model) {
		if (service.register(user)) {
			// Registration successful
			model.put("Info", "Thanks for registering, login to proceed");
			return "index";
		} else {
			// Registration failed
			model.put("Info", "Sorry! User already exist with same email");
			return "register";
		}
	}
	
	@RequestMapping(value="forget.quiz", method=RequestMethod.POST)
	public String validate(ForgetBean forget, Map model,  HttpSession session) {
		if(service.validate(forget)) {
			//Validation Successful
			session.setAttribute("EMAIL", forget.getEmail());
			
			return "change";
		}else {
			//Validation failed
			model.put("Info", "Sorry! email and security answer doesn't match");
			return "forget";
		}
	}
	
	@RequestMapping(value= "change.quiz", method=RequestMethod.POST)
	public String update(LoginBean change, Map model, HttpSession session) {
		change.setEmail((String) session.getAttribute("EMAIL")); 
		if(service.update(change)) {
			// Password update successful
			model.put("Info", "Password changed successfully, Login now");
			session.removeAttribute("EMAIL");
			return "index";
		}else {
			//Password update failed
			model.put("Info", "Password update failed, try again!");
			return "change";
		}
	}
	
	@RequestMapping(value="logout.quiz")
	public String logout(Map model, HttpSession session) {
		model.put("Info","Logout successful, Login again!");
		session.removeAttribute("USER");
		session.invalidate();
		return "index";
	}
}
