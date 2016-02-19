package com.advisory.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.advisory.model.business.HistoricalIndexCoefficientData;
import com.advisory.model.business.HistoricalIndexCovarianceData;
import com.advisory.model.business.HistoricalIndexData;
import com.advisory.model.business.HistoricalIndexRawData;
import com.advisory.model.helper.HistoricalIndexCoefficientProcessingUnit;
import com.advisory.model.helper.HistoricalIndexCovarianceProcessingUnit;


/**
 * This class is used to perform CRUD operations on Historical Data related tables
 * @author Chirag Raval
 */
public interface HistoricalDataDao {
	
	/**
	 * This method is used insert Historical Index Raw data records
	 * @return 
	 */
	public void insertHistoricalIndexRawDatas(List<HistoricalIndexRawData> historicalIndexRawDatas);
	
	/**
	 * This method is used insert Historical Index data records
	 * @return 
	 */
	public void insertHistoricalIndexDatas(List<HistoricalIndexData> historicalIndexDatas);
	
	/**
	 * This method is used insert Historical Index Coefficient data records
	 * @return 
	 */
	public void insertHistoricalIndexCoefficientDatas(List<HistoricalIndexCoefficientData> historicalIndexCoefficientDatas);
	
	/**
	 * This method is used insert Historical Index Covariance data records
	 * @return 
	 */
	public void insertHistoricalIndexCovarianceDatas(List<HistoricalIndexCovarianceData> historicalIndexCovarianceDatas);
	
	
	
	/**
	 * This method is used to fetch list of all index names
	 * @return List of all index names
	 */
	public List<String> getAllIndexNames();
	
	
	/**
	 * This method is used to fetch list of all Historical Index Raw data records
	 * @return List of all Historical Index Raw data records
	 */
	public List<HistoricalIndexRawData> getHistorivalIndexRawDatas();
	
	
	/**
	 * This method is used to fetch list of historical data records for an index
	 * @return List of historical data records for an index
	 */
	public List<HistoricalIndexData> getHistoricalDataForIndex(String indexName);
	
	
	/**
	 * This method is used to fetch list of historical data records for an index and for a year
	 * @return List of historical data records for an index and for a year
	 */
	public List<HistoricalIndexData> getHistoricalDataForIndexAndYear(@Param("indexName") String indexName,
			@Param("year") Integer year);
	
	
	/**
	 * This method is used to fetch list of month end record for all index
	 * @return List of all month end record for all index
	 */
	public List<HistoricalIndexData> getHistoricalIndexMonthEndData();
	
	
	
	/**
	 * This method is used to call LoadHistoricalMonthEndData stored procedure
	 * @return boolean indicating success/failure
	 */
	public boolean loadHistoricalMonthEndData();
	
	
	/**
	 * This method is used to call LoadHistoricalIndexExcessReturnData stored procedure
	 * @return boolean indicating success/failure
	 */
	public boolean loadHistoricalIndexExcessReturnData();
	
	/**
	 * This method is used to fetch list of HistoricalIndexCovarianceProcessingUnit for an index
	 * @return List of HistoricalIndexCovarianceProcessingUnit for an index
	 */
	public List<HistoricalIndexCovarianceProcessingUnit>
		getHistoricalIndexCovarianceProceesingUnits(@Param("indexName1") String indexName1,
				@Param("indexName2") String indexName2);
	
	
	/**
	 * This method is used to fetch list of HistoricalIndexCoefficientProcessingUnit for an index
	 * @return List of HistoricalIndexCoefficientProcessingUnit for an index
	 */
	public List<HistoricalIndexCoefficientProcessingUnit>
		getHistoricalIndexCoefficientProceesingUnits(String indexName);
}
