package com.advisory.model.business;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * The class represents model object for HISTORICAL_INDEX_COEFFICIENT_DATA table
 * @author Chirag Raval
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoricalIndexCoefficientData implements Serializable {

	/**
	 * Default serialVersionUID for Serializable interface
	 */
	private static final long serialVersionUID = 1L;
	
	private String indexName;
	private Double smbCo;
	private Double hmlCo;
	private Double wmlCo;
	private Double excessReturnCo;
	private Double alpha;
	
	/**
	 * Default Constructor
	 */
	public HistoricalIndexCoefficientData(){		
	}
	
	
	/**
	 * @param indexName
	 * @param date
	 * @param smbCo
	 * @param hmlCo
	 * @param wmlCo
	 * @param excessReturnCo
	 * @param alpha
	 */
	public HistoricalIndexCoefficientData(String indexName, Double smbCo, Double hmlCo, Double wmlCo,
									Double excessReturnCo, Double alpha){
		this.indexName = indexName;
		this.smbCo = smbCo;
		this.hmlCo = hmlCo;
		this.wmlCo = wmlCo;
		this.excessReturnCo = excessReturnCo;
		this.alpha = alpha;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "HistoricalIndexCoefficientData[" + indexName + "," + smbCo + "," + hmlCo
				+ wmlCo + "," + excessReturnCo + "," + alpha + "]";
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
	 * @return the smbCo
	 */
	public Double getSmbCo() {
		return smbCo;
	}


	/**
	 * @param smbCo the smbCo to set
	 */
	public void setSmbCo(Double smbCo) {
		this.smbCo = smbCo;
	}


	/**
	 * @return the hmlCo
	 */
	public Double getHmlCo() {
		return hmlCo;
	}


	/**
	 * @param hmlCo the hmlCo to set
	 */
	public void setHmlCo(Double hmlCo) {
		this.hmlCo = hmlCo;
	}


	/**
	 * @return the wmlCo
	 */
	public Double getWmlCo() {
		return wmlCo;
	}


	/**
	 * @param wmlCo the wmlCo to set
	 */
	public void setWmlCo(Double wmlCo) {
		this.wmlCo = wmlCo;
	}


	/**
	 * @return the excessReturnCo
	 */
	public Double getExcessReturnCo() {
		return excessReturnCo;
	}


	/**
	 * @param excessReturnCo the excessReturnCo to set
	 */
	public void setExcessReturnCo(Double excessReturnCo) {
		this.excessReturnCo = excessReturnCo;
	}


	/**
	 * @return the alpha
	 */
	public Double getAlpha() {
		return alpha;
	}


	/**
	 * @param alpha the alpha to set
	 */
	public void setAlpha(Double alpha) {
		this.alpha = alpha;
	}

	
}
