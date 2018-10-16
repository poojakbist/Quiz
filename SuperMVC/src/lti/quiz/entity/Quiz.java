package lti.quiz.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quiz {
	@Id
	@Column(name="qid")
	private int id;
	private String question;
	
	@OneToMany(mappedBy="quiz", cascade= {CascadeType.ALL}, fetch= FetchType.EAGER)	
    private Set<Answer> options;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Answer> getOptions() {
		return options;
	}

	public void setOptions(Set<Answer> options) {
		this.options = options;
	}

	
}
