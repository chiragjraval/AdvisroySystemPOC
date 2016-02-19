package com.advisory.model.business;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for HISTORICAL_INDEX_COEFFICIENT_DATA table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoricalIndexCovarianceData implements Serializable {

	/**
	 * Default serialVersionUID for Serializable interface
	 */
	private static final long serialVersionUID = 1L;
	
	private String indexName1;
	private String indexName2;
	private Double covariance;
	
	/**
	 * Default Constructor
	 */
	public HistoricalIndexCovarianceData(){		
	}
	
	
	/**
	 * @param indexName1
	 * @param indexName2
	 * @param covariance
	 */
	public HistoricalIndexCovarianceData(String indexName1, String indexName2, Double covariance){
		this.indexName1 = indexName1;
		this.indexName2 = indexName2;
		this.covariance = covariance;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "HistoricalIndexCovarianceData[" + indexName1 + "," + indexName2 + "," + covariance+ "]";
	}


	/**
	 * @return the indexName1
	 */
	public String getIndexName1() {
		return indexName1;
	}


	/**
	 * @param indexName1 the indexName1 to set
	 */
	public void setIndexName1(String indexName1) {
		this.indexName1 = indexName1;
	}


	/**
	 * @return the indexName2
	 */
	public String getIndexName2() {
		return indexName2;
	}


	/**
	 * @param indexName2 the indexName2 to set
	 */
	public void setIndexName2(String indexName2) {
		this.indexName2 = indexName2;
	}


	/**
	 * @return the covariance
	 */
	public Double getCovariance() {
		return covariance;
	}


	/**
	 * @param covariance the covariance to set
	 */
	public void setCovariance(Double covariance) {
		this.covariance = covariance;
	}

}
