package com.advisory.dao.business;

import java.util.List;

import com.advisory.model.business.Question;
import com.advisory.model.business.QuestionSet;


/**
 * This class is used to perform CRUD operations on Question related tables
 * @author Chirag Raval
 */
public interface QuestionDao {
	
	/**
	 * This method is used to fetch list of all questionSets
	 * @return List of all questionSets
	 */
	public List<QuestionSet> getQuestionSets();
	
	
	/**
	 * This method is used to fetch list of all questions
	 * @return List of all questions
	 */
	public List<Question> getQuestions();
	
}
