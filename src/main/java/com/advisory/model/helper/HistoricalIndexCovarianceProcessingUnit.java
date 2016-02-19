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
public class HistoricalIndexCovarianceProcessingUnit implements Serializable {

	/**
	 * Default serialVersionUID for Serializable interface
	 */
	private static final long serialVersionUID = 1L;
	
	private String index1Name;
	private String index2Name;
	private Date date;
	private Double index1MonthlyReturn;
	private Double index2MonthlyReturn;
	
	/**
	 * Default Constructor
	 */
	public HistoricalIndexCovarianceProcessingUnit(){		
	}
	
	
	/**
	 * @param index1Name
	 * @param index2Name
	 * @param index1MonthlyReturn
	 * @param index2MonthlyReturn
	 * @param date
	 */
	public HistoricalIndexCovarianceProcessingUnit(String index1Name, String index2Name, Date date,
									Double index1MonthlyReturn, Double index2MonthlyReturn){
		this.index1Name = index1Name;
		this.index2Name = index2Name;
		this.date = date;
		this.index1MonthlyReturn = index1MonthlyReturn;
		this.index2MonthlyReturn = index2MonthlyReturn;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "HistoricalIndexCovarianceProcessingUnit[" + index1Name + "," + index2Name + "," + index1MonthlyReturn 
				+ index2MonthlyReturn + "," + date + "]";
	}

	
	/**
	 * @return the index1Name
	 */
	public String getIndex1Name() {
		return index1Name;
	}

	/**
	 * @param index1Name the index1Name to set
	 */
	public void setIndex1Name(String index1Name) {
		this.index1Name = index1Name;
	}

	/**
	 * @return the index2Name
	 */
	public String getIndex2Name() {
		return index2Name;
	}

	/**
	 * @param index2Name the index2Name to set
	 */
	public void setIndex2Name(String index2Name) {
		this.index2Name = index2Name;
	}

	/**
	 * @return the index1MonthlyReturn
	 */
	public Double getIndex1MonthlyReturn() {
		return index1MonthlyReturn;
	}

	/**
	 * @param index1MonthlyReturn the index1MonthlyReturn to set
	 */
	public void setIndex1MonthlyReturn(Double index1MonthlyReturn) {
		this.index1MonthlyReturn = index1MonthlyReturn;
	}

	/**
	 * @return the index2MonthlyReturn
	 */
	public Double getIndex2MonthlyReturn() {
		return index2MonthlyReturn;
	}

	/**
	 * @param index2MonthlyReturn the index2MonthlyReturn to set
	 */
	public void setIndex2MonthlyReturn(Double index2MonthlyReturn) {
		this.index2MonthlyReturn = index2MonthlyReturn;
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
		
}
