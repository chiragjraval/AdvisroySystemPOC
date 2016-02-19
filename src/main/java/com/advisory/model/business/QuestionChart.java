package com.advisory.model.business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for QUESTION_CHART table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionChart {

	private String chartId;
	private String questionId;
	private String chartElementId;
	private String chartConfig;
	private String chartDescription;
	private Integer chartSequence;
	
	/**
	 * Default Constructor
	 */
	public QuestionChart(){		
	}
	
	/**
	 * @param chartId
	 * @param questionId
	 * @param chartElementId
	 * @param chartConfig
	 * @param chartDescription
	 * @param chartSequence
	 */
	public QuestionChart(String chartId, String questionId, String chartElementId, String chartConfig, String chartDescription, Integer chartSequence){
		this.chartId = chartId;
		this.questionId = questionId;
		this.chartElementId = chartElementId;
		this.chartConfig = chartConfig;
		this.chartDescription = chartDescription;
		this.chartSequence = chartSequence;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "QuestionChart[" + chartId + "," + questionId + "," + chartElementId + "," + chartConfig + "," + chartDescription + "," + chartSequence + "]";
	}

	/**
	 * @return chartId
	 */
	public String getChartId() {
		return chartId;
	}

	/**
	 * @param chartId the chartId value to be set
	 */
	public void setChartId(String chartId) {
		this.chartId = chartId;
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
	 * @return chartElementId
	 */
	public String getChartElementId() {
		return chartElementId;
	}

	/**
	 * @param chartElementId the chartElementId value to be set
	 */
	public void setChartElementId(String chartElementId) {
		this.chartElementId = chartElementId;
	}

	/**
	 * @return chartConfig
	 */
	public String getChartConfig() {
		return chartConfig;
	}

	/**
	 * @param chartConfig the chartConfig value to be set
	 */
	public void setChartConfig(String chartConfig) {
		this.chartConfig = chartConfig;
	}

	/**
	 * @return chartDescription
	 */
	public String getChartDescription() {
		return chartDescription;
	}

	/**
	 * @param chartDescription the chartDescription value to be set
	 */
	public void setChartDescription(String chartDescription) {
		this.chartDescription = chartDescription;
	}

	/**
	 * @return chartSequence
	 */
	public Integer getChartSequence() {
		return chartSequence;
	}

	/**
	 * @param chartSequence the chartSequence value to be set
	 */
	public void setChartSequence(Integer chartSequence) {
		this.chartSequence = chartSequence;
	}

}
