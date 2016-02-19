package com.advisory.model.business;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for HISTORICAL_INDEX_RAW_DATA table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoricalIndexRawData implements Serializable {

	/**
	 * Default serialVersionUID for Serializable interface
	 */
	private static final long serialVersionUID = 1L;
	
	private String indexName;
	private Date date;
	private Double openPrice;
	private Double highPrice;
	private Double lowPrice;
	private Double closePrice;
	private Double adjClosePrice;
	private Double sharesTraded;
	private Double turnover;
	
	
	/**
	 * Default Constructor
	 */
	public HistoricalIndexRawData(){		
	}
	
	
	/**
	 * @param indexName
	 * @param date
	 * @param openPrice
	 * @param highPrice
	 * @param lowPrice
	 * @param closePrice
	 * @param adjClosePrice
	 * @param sharesTraded
	 * @param turnover
	 */
	public HistoricalIndexRawData(String indexName, Date date, Double openPrice, Double highPrice, Double lowPrice,
									Double closePrice, Double adjClosePrice, Double sharesTraded, Double turnover){
		this.indexName = indexName;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.adjClosePrice = adjClosePrice;
		this.sharesTraded = sharesTraded;
		this.turnover = turnover;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "HistoricalIndexRawData[" + indexName + "," + date + "," + openPrice
				+ highPrice + "," + lowPrice + "," + closePrice +
				"," + sharesTraded + "," + turnover + "]";
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
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date value to be set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return openPrice
	 */
	public Double getOpenPrice() {
		return openPrice;
	}

	/**
	 * @param openPrice the openPrice value to be set
	 */
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	/**
	 * @return highPrice
	 */
	public Double getHighPrice() {
		return highPrice;
	}

	/**
	 * @param highPrice the highPrice value to be set
	 */
	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	/**
	 * @return lowPrice
	 */
	public Double getLowPrice() {
		return lowPrice;
	}

	/**
	 * @param lowPrice the lowPrice value to be set
	 */
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	/**
	 * @return closePrice
	 */
	public Double getClosePrice() {
		return closePrice;
	}

	/**
	 * @param closePrice the closePrice value to be set
	 */
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	/**
	 * @return adjClosePrice
	 */
	public Double getAdjClosePrice() {
		return adjClosePrice;
	}

	/**
	 * @param adjClosePrice the adjClosePrice value to be set
	 */
	public void setAdjClosePrice(Double adjClosePrice) {
		this.adjClosePrice = adjClosePrice;
	}

	/**
	 * @return sharesTraded
	 */
	public Double getSharesTraded() {
		return sharesTraded;
	}

	/**
	 * @param sharesTraded the sharesTraded value to be set
	 */
	public void setSharesTraded(Double sharesTraded) {
		this.sharesTraded = sharesTraded;
	}

	/**
	 * @return turnover
	 */
	public Double getTurnover() {
		return turnover;
	}

	/**
	 * @param turnover the turnover value to be set
	 */
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

}
