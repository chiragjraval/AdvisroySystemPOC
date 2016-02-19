package com.advisory.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.advisory.model.business.Question;

@XmlAccessorType(XmlAccessType.FIELD)
public class GetQuestionsResponse {

	@XmlElement(name="questions")
	private List<Question> questions;

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}	
}
