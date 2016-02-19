package com.advisory.service.business;

import com.advisory.dao.business.QuestionDao;
import com.advisory.model.response.GetQuestionSetsResponse;
import com.advisory.model.response.GetQuestionsResponse;

public class QuestionService {

	private QuestionDao questionDao;

	/**
	 * @param questionDao the questionDao to set
	 */
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public GetQuestionSetsResponse getQuestionSets()
	{
		GetQuestionSetsResponse response = new GetQuestionSetsResponse();
		response.setQuestionSets(questionDao.getQuestionSets());
		return response;
	}
	
	public GetQuestionsResponse getQuestions()
	{
		GetQuestionsResponse response = new GetQuestionsResponse();
		response.setQuestions(questionDao.getQuestions());
		return response;
	}
}
