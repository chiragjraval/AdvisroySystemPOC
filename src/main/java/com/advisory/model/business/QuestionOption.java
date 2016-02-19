package com.advisory.model.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for QUESTION_OPTION table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionOption {

	private String optionId;
	private String questionId;
	private String optionText;
	private String optionDescription;
	private Integer optionSequence;
	
	/**
	 * Default Constructor
	 */
	public QuestionOption(){		
	}
	
	/**
	 * @param optionId
	 * @param questionId
	 * @param optionText
	 * @param optionDescription
	 * @param optionSequence
	 */
	public QuestionOption(String optionId, String questionId, String optionText, String optionDescription, Integer optionSequence){
		this.optionId = optionId;
		this.questionId = questionId;
		this.optionText = optionText;
		this.optionDescription = optionDescription;
		this.optionSequence = optionSequence;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "QuestionOption[" + optionId + "," + questionId + "," + optionText + "," + optionDescription + "," + optionSequence + "]";
	}

	/**
	 * @return optionId
	 */
	public String getOptionId() {
		return optionId;
	}

	/**
	 * @param optionId the optionId value to be set
	 */
	public void setOptionId(String optionId) {
		this.optionId = optionId;
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
	 * @return optionText
	 */
	public String getOptionText() {
		return optionText;
	}

	/**
	 * @param optionText the optionText value to be set
	 */
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	/**
	 * @return optionDescription
	 */
	public String getOptionDescription() {
		return optionDescription;
	}

	/**
	 * @param optionDescription the optionDescription value to be set
	 */
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	/**
	 * @return optionSequence
	 */
	public Integer getOptionSequence() {
		return optionSequence;
	}

	/**
	 * @param optionSequence the optionSequence value to be set
	 */
	public void setOptionSequence(Integer optionSequence) {
		this.optionSequence = optionSequence;
	}


	
}
