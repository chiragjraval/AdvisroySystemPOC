package com.advisory.model.business;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * The class represents model object for QUESTION_SET table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionSet {

	private String questionSetId;
	private String questionSetDescription;
	
	@XmlElement(name="questions")
	private List<Question> questions;
	
	
	/**
	 * Default Constructor
	 */
	public QuestionSet(){		
	}
	
	/**
	 * @param questionSetId
	 * @param questionSetDescription
	 * @param questions
	 */
	public QuestionSet(String questionSetId, String questionSetDescription, List<Question> questions){
		this.questionSetId = questionSetId;
		this.questionSetDescription = questionSetDescription;
		this.questions = questions;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "QuestionSet[" + questionSetId + "," + questionSetDescription + "," + questions + "]";
	}

	/**
	 * @return questionSetId
	 */
	public String getQuestionSetId() {
		return questionSetId;
	}

	/**
	 * @param questionSetId the questionSetId value to be set
	 */
	public void setQuestionSetId(String questionSetId) {
		this.questionSetId = questionSetId;
	}

	/**
	 * @return questionSetDescription
	 */
	public String getQuestionSetDescription() {
		return questionSetDescription;
	}

	/**
	 * @param questionSetDescription the questionSetDescription value to be set
	 */
	public void setQuestionSetDescription(String questionSetDescription) {
		this.questionSetDescription = questionSetDescription;
	}

	/**
	 * @return questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions value to be set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
