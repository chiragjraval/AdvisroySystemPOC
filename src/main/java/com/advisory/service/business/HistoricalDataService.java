package com.advisory.service.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.log4j.Logger;

import com.advisory.dao.business.HistoricalDataDao;
import com.advisory.data.historical.load.helper.BseDataLoadHelper;
import com.advisory.data.historical.load.helper.NseDataLoadHelper;
import com.advisory.model.business.HistoricalIndexCoefficientData;
import com.advisory.model.business.HistoricalIndexCovarianceData;
import com.advisory.model.business.HistoricalIndexData;
import com.advisory.model.business.HistoricalIndexRawData;
import com.advisory.model.helper.HistoricalIndexCoefficientProcessingUnit;
import com.advisory.model.helper.HistoricalIndexCovarianceProcessingUnit;


public class HistoricalDataService {

	private static final Logger logger = Logger.getLogger(HistoricalDataService.class);

	private static final Variance variance = new Variance();
	private static final StandardDeviation standardDeviation = new StandardDeviation();

	private HistoricalDataDao historicalDataDao;
	NseDataLoadHelper nseDataLoadHelper;
	BseDataLoadHelper bseDataLoadHelper;

	/**
	 * @param historicalDataDao the historicalDataDao to set
	 */
	public void setHistoricalDataDao(HistoricalDataDao historicalDataDao) {
		this.historicalDataDao = historicalDataDao;
	}
	
	/**
	 * @param nseDataLoadHelper the nseDataLoadHelper to set
	 */
	public void setNseDataLoadHelper(NseDataLoadHelper nseDataLoadHelper) {
		this.nseDataLoadHelper = nseDataLoadHelper;
	}

	/**
	 * @param bseDataLoadHelper the bseDataLoadHelper to set
	 */
	public void setBseDataLoadHelper(BseDataLoadHelper bseDataLoadHelper) {
		this.bseDataLoadHelper = bseDataLoadHelper;
	}
	
	
	
	
	
	public boolean loadNseCsvDataIntoTable(String rootFolder)
	{
		logger.info("Create object for folder");
		File folder = new File(rootFolder);
		
		for (File csvFile : folder.listFiles())
		{
			logger.info("Extract all object with the help of Helper class");
			List<HistoricalIndexRawData> historicalIndexRawDataList = nseDataLoadHelper.parseHistoricalIndexRawDataCsvFile(csvFile);
			
			logger.info("Save all objects for an index in a database");
			historicalDataDao.insertHistoricalIndexRawDatas(historicalIndexRawDataList);
		}
			
		return true;
	}
	
	public boolean loadBseCsvDataIntoTable(String rootFolder)
	{
		logger.info("Create object for folder");
		File folder = new File(rootFolder);
		
		for (File csvFile : folder.listFiles())
		{
			logger.info("Extract all object with the help of Helper class");
			List<HistoricalIndexRawData> historicalIndexRawDataList = bseDataLoadHelper.parseHistoricalIndexRawDataCsvFile(csvFile);
			
			logger.info("Save all objects for an index in a database");
			historicalDataDao.insertHistoricalIndexRawDatas(historicalIndexRawDataList);
		}
			
		return true;
	}
	
	public boolean loadHistoricalIndexMonthEndData() {
		return historicalDataDao.loadHistoricalMonthEndData();
	}
	
	public boolean loadHistoricalIndexExcessReturnData() {
		return historicalDataDao.loadHistoricalIndexExcessReturnData();
	}
	
	public Double getAttributeForIndex(String attribute, String indexName, String propertyName)
	{	
		logger.info("Entering HistoricalIndexDataDao.getAttributeForIndex() method");
		
		logger.info("Exracting list of matching Historical Index Data points");
		List<HistoricalIndexData> historicalIndexDatas = historicalDataDao.getHistoricalDataForIndex(indexName);
		
		logger.info("Extracting array of required column");
		double[] dataPoints = extractArrayOfPropertyValues(historicalIndexDatas, propertyName);
		
		logger.info("Calculating values for required Attribute");
		double result = evaluatePropertyForDataPoints(attribute, dataPoints);
		
		logger.info("Exiting HistoricalIndexDataDao.getAttributeForIndex() method");
		return result;
	}
	

	public Double getAttributeForIndexAndYear(String attribute, String indexName, String propertyName, Integer year)
	{
		logger.info("Entering HistoricalIndexDataDao.getAttributeForIndexAndYear() method");
		
		logger.info("Exracting list of matching Historical Index Data points");
		List<HistoricalIndexData> historicalIndexDatas = historicalDataDao.getHistoricalDataForIndexAndYear(indexName, year);
		
		logger.info("Extracting array of required column");
		double[] dataPoints = extractArrayOfPropertyValues(historicalIndexDatas, propertyName);
		
		logger.info("Calculating values for required Attribute");
		double result = evaluatePropertyForDataPoints(attribute, dataPoints);
		
		
		return result;
	}
	

	public boolean loadHistoricalIndexCoefficientData()
	{
		List<String> indexNames = historicalDataDao.getAllIndexNames();
		
		for (String indexName : indexNames)
		{
			logger.info("Loading coefficient data for Index : " + indexName);
			List<HistoricalIndexCoefficientProcessingUnit> processingUnits = historicalDataDao.getHistoricalIndexCoefficientProceesingUnits(indexName);
			logger.info("No. Processing Units loaded : " + processingUnits.size());
			if(processingUnits.size() < 5) continue;
			
			double[] ySampleDate = new double[processingUnits.size()];
			double[][] xSampleData = new double[processingUnits.size()][4];
			
			for (int i = 0; i < processingUnits.size(); i++)
			{
				HistoricalIndexCoefficientProcessingUnit processingUnit = processingUnits.get(i); 
				if(processingUnit.getIndexExcessReturn() == null) continue;
				
				ySampleDate[i] = processingUnit.getIndexExcessReturn();
				xSampleData[i][0] = processingUnit.getSmbPercent();
				xSampleData[i][1] = processingUnit.getHmlPercent();
				xSampleData[i][2] = processingUnit.getWmlPercent();
				xSampleData[i][3] = processingUnit.getExcessReturnPercent();
			}
			
			OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
			regression.newSampleData(ySampleDate, xSampleData);
			double[] coefficients = regression.estimateRegressionParameters();
			
			HistoricalIndexCoefficientData historicalIndexCoefficientData = new HistoricalIndexCoefficientData();
			historicalIndexCoefficientData.setIndexName(indexName);
			historicalIndexCoefficientData.setSmbCo(coefficients[0]);
			historicalIndexCoefficientData.setHmlCo(coefficients[1]);
			historicalIndexCoefficientData.setWmlCo(coefficients[2]);
			historicalIndexCoefficientData.setExcessReturnCo(coefficients[3]);
			historicalIndexCoefficientData.setAlpha(coefficients[4]);
			
			List<HistoricalIndexCoefficientData> historicalIndexCoefficientDatas = new ArrayList<>();
			historicalIndexCoefficientDatas.add(historicalIndexCoefficientData);
			
			historicalDataDao.insertHistoricalIndexCoefficientDatas(historicalIndexCoefficientDatas);
		}
		
		return true;
	}
	
	
	
	public boolean loadHistoricalIndexCovarianceData()
	{
		List<String> indexNames = historicalDataDao.getAllIndexNames();
		
		for (int i=indexNames.size()-1; i>=0; i--)
		{
			String indexName1 = indexNames.get(i);
		
			for(int j=i; j>=0; j--)
			{
				String indexName2 = indexNames.get(j);
				
				logger.info("Extracting Covariance processing units for Index1 :: " + indexName1 + ", Index2 :: " + indexName2);
				List<HistoricalIndexCovarianceProcessingUnit> historicalIndexCovarianceProcessingUnits 
						= historicalDataDao.getHistoricalIndexCovarianceProceesingUnits(indexName1, indexName2);
				logger.info("No. of processing units extracted :: " + historicalIndexCovarianceProcessingUnits.size());
				
				if(historicalIndexCovarianceProcessingUnits.size() < 2) continue;
				
				double[] index1Returns = new double[historicalIndexCovarianceProcessingUnits.size()];
				double[] index2Returns = new double[historicalIndexCovarianceProcessingUnits.size()];
				
				for (int k=0; k<historicalIndexCovarianceProcessingUnits.size(); k++) {
					index1Returns[k] = historicalIndexCovarianceProcessingUnits.get(k).getIndex1MonthlyReturn();
					index2Returns[k] = historicalIndexCovarianceProcessingUnits.get(k).getIndex2MonthlyReturn();
				}
				
				Covariance covarianceCalculator = new Covariance();
				double covarianceVal = covarianceCalculator.covariance(index1Returns, index2Returns);
				
				HistoricalIndexCovarianceData historicalIndexCovarianceData = new HistoricalIndexCovarianceData();
				historicalIndexCovarianceData.setIndexName1(indexName1);
				historicalIndexCovarianceData.setIndexName2(indexName2);
				historicalIndexCovarianceData.setCovariance(covarianceVal);
				
				List<HistoricalIndexCovarianceData> historicalIndexCovarianceDatas = new ArrayList<>();
				historicalIndexCovarianceDatas.add(historicalIndexCovarianceData);
				
				historicalDataDao.insertHistoricalIndexCovarianceDatas(historicalIndexCovarianceDatas);
			}
			
			indexNames.remove(indexName1);
		}
		
		return true;
	}
	
	
	public List<HistoricalIndexCoefficientProcessingUnit> getHistoricalIndexCoefficientProceesingUnits(String indexName)
	{
		logger.info("Entering HistoricalIndexDataDao.getHistoricalIndexCoefficientProceesingUnits() method");
		
		List<HistoricalIndexCoefficientProcessingUnit> units
			= historicalDataDao.getHistoricalIndexCoefficientProceesingUnits(indexName);
		
		logger.info("Exiting HistoricalIndexDataDao.getHistoricalIndexCoefficientProceesingUnits() method");
		return units;
	}
	
	
	private double[] extractArrayOfPropertyValues(List<HistoricalIndexData> historicalIndexDatas, String propertyName) {
		
		double[] values = new double[historicalIndexDatas.size()];
		
		for(int i=0; i<historicalIndexDatas.size(); i++) {
			if("openPrice".equals(propertyName))
				values[i] = historicalIndexDatas.get(i).getOpenPrice();
			else if("highPrice".equals(propertyName))
				values[i] = historicalIndexDatas.get(i).getHighPrice();
			else if("lowPrice".equals(propertyName))
				values[i] = historicalIndexDatas.get(i).getLowPrice();
			else if("closePrice".equals(propertyName))
				values[i] = historicalIndexDatas.get(i).getClosePrice();
			else if("monthlyReturn".equals(propertyName))
				values[i] = historicalIndexDatas.get(i).getMonthlyReturn() == null ? 0 : historicalIndexDatas.get(i).getMonthlyReturn();
		}
		
		return values;
	}
	
	private double evaluatePropertyForDataPoints(String attribute, double[] values) {
		
		if("variance".equals(attribute))
			return variance.evaluate(values);
		else if("standardDeviation".equals(attribute))
			return standardDeviation.evaluate(values);
		else
			return 0;
	}

	
}
