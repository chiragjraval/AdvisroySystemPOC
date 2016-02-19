package com.advisory.nse.data.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class ScrapNseDataTest {

	static String downloadFolder = "G:\\Workspace\\Advisory\\NSEHistoricalData\\HistoricalData1";
	
	static String[] indices = {/*"CNX NIFTY", "CNX NIFTY JUNIOR",*/ "LIX 15", "LIX15 Midcap", "CNX 100", "CNX 200", "CNX 500",
		    "NIFTY MIDCAP 50", "CNX MIDCAP", "CNX SMALLCAP", "CNX AUTO", "CNX BANK", "CNX ENERGY", "CNX FINANCE",
		    "CNX FMCG", "CNX IT", "CNX MEDIA", "CNX METAL", "CNX PHARMA", "CNX PSU BANK", "CNX REALTY", "CNX COMMODITIES",
		    "CNX CONSUMPTION", "CPSE INDEX", "CNX INFRA", "CNX MNC", "CNX PSE", "CNX SERVICE", "CNX SHARIAH25", "CNX NIFTY SHARIAH",
		    "CNX 500 SHARIAH", "CNX 100 Equal Weight", "CNX DEFTY", "NIFTY DIVIDEND", "CNX DIVIDEND OPPT", "CNX ALPHA INDEX",
		    "CNX HIGH BETA", "CNX LOW VOLATILITY", "NSE QUALITY 30", "NV20", "NI15", "NIFTY TR 2X LEV", "NIFTY PR 2X LEV",
		    "NIFTY TR 1X INV", "NIFTY PR 1X INV"};
	
	static int[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015};
	
	private static FirefoxProfile getFirefoxProfile()
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv");
		profile.setPreference("browser.download.dir",downloadFolder);
		profile.setPreference("browser.download.folderList",2);
		profile.setPreference("browser.download.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
		return profile;
	}
	
	public static void main(String[] args)
	{
		FirefoxProfile firefoxProfile = getFirefoxProfile();
		WebDriver driver = new FirefoxDriver(firefoxProfile);
		
		//Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  
		driver.manage().window().maximize();
  
		for (String index : indices) {
			int retryCount = 1;
			
			for (int i=0; i<years.length; ) {
				int year = years[i];
				driver.navigate().to("http://www.nseindia.com/products/content/equities/indices/historical_index_data.htm");
				//System.out.println("Browsing for Index : " + index + " Year : " + year );
				
				Select indexSelector = new Select(driver.findElement(By.id("indexType")));
				indexSelector.selectByValue(index);
		  
				// Enter value 10 in the first number of the percent Calculator
				driver.findElement(By.id("fromDate")).sendKeys("02-01-" + year);
		  
				// Enter value 50 in the second number of the percent Calculator
				driver.findElement(By.id("toDate")).sendKeys("31-12-" + year);
		  
				// Click Calculate Button
				driver.findElement(By.id("get")).click();
				
				try {
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("a[href$='" + year + ".csv']")).click();
					Thread.sleep(1000);
					if(!checkIfFileExists(downloadFolder, index+"02-01-"+year+"-31-12-"+year+".csv") && retryCount<3) {
						System.out.println("File could not be downloaded for Index : " + index + " Year : " + year + " RetryCount : " + retryCount);
						retryCount++;
						driver.quit();
						driver = new FirefoxDriver(firefoxProfile);
						driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
						driver.manage().window().maximize();
					} else {
						retryCount = 1;
						i++;
					}
					
				} catch(Exception ex) {
					System.out.println("Data does not exitst for Index : " + index + " Year : " + year );
					retryCount = 1;
					i++;
				}
			}
			
		}
					
		//Close the Browser.
		driver.close();
	}
	
	
	private static boolean checkIfFileExists(String directory, String fileName) {
		
		File folder = new File(directory);
		
		for (File file : folder.listFiles()) {
			if(fileName.equals(file.getName()))
				return true;
		}
		
		return false;
	}

}
