package com.advisory.regression.test;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class OLSLinerarRegressionTest {

	public static void main(String[] args) {
		
		double[] ySampleData = {1,2,3};
		double[][] xSampleDate = {{1,2},{4,5},{7,8}};
		
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		regression.newSampleData(ySampleData, xSampleDate);

		double[] coefficients = regression.estimateRegressionParameters();
		for (double coefficient : coefficients) {
			System.out.println(coefficient);
		}
	}

}
