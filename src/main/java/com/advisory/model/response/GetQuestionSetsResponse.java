package com.advisory.model.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.advisory.model.business.QuestionSet;

@XmlAccessorType(XmlAccessType.FIELD)
public class GetQuestionSetsResponse {

	@XmlElement(name="questionSets")
	private List<QuestionSet> questionSets;

	/**
	 * @return the questionSets
	 */
	public List<QuestionSet> getQuestionSets() {
		return questionSets;
	}

	/**
	 * @param questionSets the questionSets to set
	 */
	public void setQuestionSets(List<QuestionSet> questionSets) {
		this.questionSets = questionSets;
	}	
}
