package com.advisory.data.historical.load.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import com.advisory.model.business.HistoricalIndexRawData;

public class BseDataLoadHelper {

	private static final Logger logger = Logger.getLogger(BseDataLoadHelper.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("MMM-yy");
	
    private static final String HEADER_MONTH = "Month";
    private static final String HEADER_OPEN = "Open";
    private static final String HEADER_HIGH = "High";
    private static final String HEADER_LOW = "Low";
    private static final String HEADER_CLOSE = "Close";
    
	private static final String [] BSE_FILE_HEADER_MAPPING 
			= {HEADER_MONTH,HEADER_OPEN,HEADER_HIGH,HEADER_LOW,HEADER_CLOSE};
	
	
	public List<HistoricalIndexRawData> parseHistoricalIndexRawDataCsvFile(File csvFile)
	{
		logger.info("Create CSV parser object for file parsing");
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(BSE_FILE_HEADER_MAPPING);
		
		FileReader fileReader = null;
		CSVParser csvParser = null;
		List<HistoricalIndexRawData> historicalIndexRawDataList = new ArrayList<HistoricalIndexRawData>();
		
		try
		{
			fileReader = new FileReader(csvFile);
			csvParser = new CSVParser(fileReader, csvFileFormat);
			
			logger.info("Parse file and extract values from CSV Records");
			String indexName = csvFile.getName().split("[.]")[0].split("_")[0];
			
			List<CSVRecord> historicalCsvRecords = csvParser.getRecords();
			for (int i=1; i<historicalCsvRecords.size(); i++)
			{
				CSVRecord historicalCsvRecord = historicalCsvRecords.get(i);
				Date date = dateFormat.parse(historicalCsvRecord.get(HEADER_MONTH));
				Double openPrice = parseDouble(historicalCsvRecord.get(HEADER_OPEN));
				Double highPrice = parseDouble(historicalCsvRecord.get(HEADER_HIGH));
				Double lowPrice = parseDouble(historicalCsvRecord.get(HEADER_LOW));
				Double closePrice = parseDouble(historicalCsvRecord.get(HEADER_CLOSE));
				
				HistoricalIndexRawData historcalIndexRawData = new HistoricalIndexRawData(indexName, date, openPrice, highPrice, lowPrice, closePrice, null, null, null);
				historicalIndexRawDataList.add(historcalIndexRawData);
			}
		}
		catch(IOException ioException)
		{
			logger.debug("IOException occured while loading CSV Historical Data");
			logger.debug(ioException.getMessage());
			return historicalIndexRawDataList;
		}
		catch (ParseException parseException)
		{
			logger.debug("ParseException occured while loading CSV Historical Data");
			logger.debug(parseException.getMessage());
			return historicalIndexRawDataList;
		}
		finally
		{
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException ioException) {
				logger.debug("IOException occured while closing fileReader/csvParser");
				logger.debug(ioException.getMessage());
				return historicalIndexRawDataList;
			}
		}
		
		return historicalIndexRawDataList;
	}
	
	
	private Double parseDouble(String doubleString)
	{
		if(doubleString.trim().isEmpty())
			return null;
		else
			return Double.parseDouble(doubleString);
	}
}
