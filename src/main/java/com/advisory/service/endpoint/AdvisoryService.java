package com.advisory.service.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advisory.model.response.GetQuestionSetsResponse;
import com.advisory.model.response.GetQuestionsResponse;
import com.advisory.service.business.HistoricalDataService;
import com.advisory.service.business.QuestionService;


@Path("/service")
public class AdvisoryService {

	private QuestionService questionService;
	private HistoricalDataService historicalDataService;
	
	/**
	 * @param questionService the questionService to set
	 */
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	/**
	 * @param historicalDataService the historicalDataService to set
	 */
	public void setHistoricalDataService(HistoricalDataService historicalDataService) {
		this.historicalDataService = historicalDataService;
	}


	@GET
	@Path("/questionsets")
	@Produces(MediaType.APPLICATION_JSON)
	public GetQuestionSetsResponse getQuestionSets()
	{
		return questionService.getQuestionSets();
	}
	
	@GET
	@Path("/questions")
	@Produces(MediaType.APPLICATION_JSON)
	public GetQuestionsResponse getQuestions()
	{
		return questionService.getQuestions();
	}
	
	
	@GET
	@Path("/loadNseHistoricalIndexRawData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadNseHistoricalIndexRawData()
	{
		return historicalDataService.loadNseCsvDataIntoTable("G:\\Workspace\\Advisory\\NSEHistoricalData\\HistoricalData");
	}
	
	@GET
	@Path("/loadBseHistoricalIndexRawData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadBseHistoricalIndexRawData()
	{
		return historicalDataService.loadBseCsvDataIntoTable("G:\\Workspace\\Advisory\\BSEHistoricalData");
	}
	
	@GET
	@Path("/loadHistoricalIndexMonthEndData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadHistoricalIndexMonthEndData()
	{
		return historicalDataService.loadHistoricalIndexMonthEndData();
	}
	
	@GET
	@Path("/loadHistoricalIndexExcessReturnData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadHistoricalIndexExcessReturnData()
	{
		return historicalDataService.loadHistoricalIndexExcessReturnData();
	}
	
	@GET
	@Path("/historicalData/{attribute}/{indexName}/{propertyName}")
	@Produces(MediaType.APPLICATION_JSON)
	public double getAttributeValueForIndex(@PathParam("attribute") String attribute, @PathParam("indexName") String indexName,
			@PathParam("propertyName") String propertyName)
	{
		return historicalDataService.getAttributeForIndex(attribute, indexName, propertyName);
	}
	
	@GET
	@Path("/historicalData/{attribute}/{indexName}/{propertyName}/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public double getAttributeValueForIndexAndYear(@PathParam("attribute") String attribute, @PathParam("indexName") String indexName,
			@PathParam("propertyName") String propertyName, @PathParam("year") Integer year)
	{
		return historicalDataService.getAttributeForIndexAndYear(attribute, indexName, propertyName, year);
	}
	
	@GET
	@Path("/loadHistoricalIndexCoefficientData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadHistoricalIndexCoefficientData()
	{
		return historicalDataService.loadHistoricalIndexCoefficientData();
	}
	
	@GET
	@Path("/loadHistoricalIndexCovarianceData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean loadHistoricalIndexCovarianceData()
	{
		return historicalDataService.loadHistoricalIndexCovarianceData();
	}
}