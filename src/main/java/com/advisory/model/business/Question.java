package com.advisory.model.business;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * The class represents model object for QUESTION table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {

	private String questionId;
	private String questionSetId;
	private String questionDescription;
	private String questionTemplate;
	private Integer questionSequence;
	
	@XmlElement(name="questionOptions")
	private List<QuestionOption> questionOptions;
	
	@XmlElement(name="questionCharts")
	private List<QuestionChart> questionCharts;
	
	
	/**
	 * Default Constructor
	 */
	public Question(){		
	}
	
	
	/**
	 * @param questionId
	 * @param questionSetId
	 * @param questionDescription
	 * @param questionTemplate
	 * @param questionSequence
	 * @param questionOptions
	 * @param questionCharts
	 */
	public Question(String questionId, String questionSetId, String questionDescription, String questionTemplate, Integer questionSequence, List<QuestionOption> questionOptions, List<QuestionChart> questionCharts){
		this.questionId = questionId;
		this.questionSetId = questionSetId;
		this.questionDescription = questionDescription;
		this.questionTemplate = questionTemplate;
		this.questionSequence = questionSequence;
		this.questionOptions = questionOptions;
		this.questionCharts = questionCharts;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Question[" + questionId + "," + questionSetId + "," + questionDescription + "," + questionSequence + "," + questionOptions + "," + questionCharts + "]";
	}

	/**
	 * @return questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId value to be set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
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
	 * @return questionDescription
	 */
	public String getQuestionDescription() {
		return questionDescription;
	}

	/**
	 * @param questionDescription the questionDescription value to be set
	 */
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	/**
	 * @return questionTemplate
	 */
	public String getQuestionTemplate() {
		return questionTemplate;
	}

	/**
	 * @param questionTemplate the questionTemplate value to be set
	 */
	public void setQuestionTemplate(String questionTemplate) {
		this.questionTemplate = questionTemplate;
	}

	/**
	 * @return questionSequence
	 */
	public Integer getQuestionSequence() {
		return questionSequence;
	}

	/**
	 * @param questionSequence the questionSequence value to be set
	 */
	public void setQuestionSequence(Integer questionSequence) {
		this.questionSequence = questionSequence;
	}

	/**
	 * @return questionOptions
	 */
	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	/**
	 * @param questionOptions the questionOptions value to be set
	 */
	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}

	/**
	 * @return questionCharts
	 */
	public List<QuestionChart> getQuestionCharts() {
		return questionCharts;
	}

	/**
	 * @param questionCharts the questionCharts value to be set
	 */
	public void setQuestionCharts(List<QuestionChart> questionCharts) {
		this.questionCharts = questionCharts;
	}
	
	
}
