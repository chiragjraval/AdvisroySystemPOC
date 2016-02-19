package com.advisory.model.helper;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for OLS Linear Regression Processing Unit
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoricalIndexCoefficientProcessingUnit implements Serializable {

	/**
	 * Default serialVersionUID for Serializable interface
	 */
	private static final long serialVersionUID = 1L;
	
	private String indexName;
	private Date date;
	private Double smbPercent;
	private Double hmlPercent;
	private Double wmlPercent;
	private Double excessReturnPercent;
	private Double indexExcessReturn;
	
	/**
	 * Default Constructor
	 */
	public HistoricalIndexCoefficientProcessingUnit(){		
	}
	
	
	/**
	 * @param indexName
	 * @param date
	 * @param smbPercent
	 * @param hmlPercent
	 * @param wmlPercent
	 * @param excessReturnPercent
	 * @param indexExcessReturn
	 */
	public HistoricalIndexCoefficientProcessingUnit(String indexName, Date date, Double smbPercent, Double hmlPercent, Double wmlPercent,
									Double excessReturnPercent, Double indexExcessReturn){
		this.indexName = indexName;
		this.date = date;
		this.smbPercent = smbPercent;
		this.hmlPercent = hmlPercent;
		this.wmlPercent = wmlPercent;
		this.excessReturnPercent = excessReturnPercent;
		this.indexExcessReturn = indexExcessReturn;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "HistoricalIndexCoefficientProcessingUnit[" + indexName + "," + date + "," + smbPercent + "," + hmlPercent
				+ wmlPercent + "," + excessReturnPercent + "," + indexExcessReturn + "]";
	}


	/**
	 * @return indexName
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * @param indexName the indexName value to be set
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the smbPercent
	 */
	public Double getSmbPercent() {
		return smbPercent;
	}


	/**
	 * @param smbPercent the smbPercent to set
	 */
	public void setSmbPercent(Double smbPercent) {
		this.smbPercent = smbPercent;
	}


	/**
	 * @return the hmlPercent
	 */
	public Double getHmlPercent() {
		return hmlPercent;
	}


	/**
	 * @param hmlPercent the hmlPercent to set
	 */
	public void setHmlPercent(Double hmlPercent) {
		this.hmlPercent = hmlPercent;
	}


	/**
	 * @return the wmlPercent
	 */
	public Double getWmlPercent() {
		return wmlPercent;
	}


	/**
	 * @param wmlPercent the wmlPercent to set
	 */
	public void setWmlPercent(Double wmlPercent) {
		this.wmlPercent = wmlPercent;
	}


	/**
	 * @return the excessReturnPercent
	 */
	public Double getExcessReturnPercent() {
		return excessReturnPercent;
	}


	/**
	 * @param excessReturnPercent the excessReturnPercent to set
	 */
	public void setExcessReturnPercent(Double excessReturnPercent) {
		this.excessReturnPercent = excessReturnPercent;
	}


	/**
	 * @return the indexExcessReturn
	 */
	public Double getIndexExcessReturn() {
		return indexExcessReturn;
	}


	/**
	 * @param indexExcessReturn the indexExcessReturn to set
	 */
	public void setIndexExcessReturn(Double indexExcessReturn) {
		this.indexExcessReturn = indexExcessReturn;
	}


	
	
}
