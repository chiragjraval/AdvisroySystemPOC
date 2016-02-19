package com.advisory.bse.data.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class ScrapBseDataTest {

	static String downloadFolder = "G:\\Workspace\\Advisory\\BSEHistoricalData";
	
	static String[] indices = {"SENSEX",
			"BSE100",
			"BSE200",
			"BSE500",
			"SPBSAIP",
			"SPBSLIP",
			"BSEMID",
			"BSESML",
			"SPBSLMIP",
			"SPBSMSIP",
			"SPBMDSIP",
			"SPBSSSIP",
			"SPBSBMIP",
			"SPBSCDIP",
			"SPBSENIP",
			"SI0600",
			"SPBSFIIP",
			"SI0800",
			"SPBSIDIP",
			"SI1000",
			"SPBSTLIP",
			"SPBSUTIP",
			"SI1900",
			"SIBANK",
			"SI0200",
			"SI0400",
			"SI1200",
			"SI1400",
			"SIPOWE",
			"SIREAL",
			"SIBTEC",
			"INFRA",
			"SPBSE5S",
			"SIBPSU",
			"CPSE",
			"SPBIMIP",
			"DOLL30",
			"DOL100",
			"DOLLEX",
			"IPO   ",
			"SMEIPO",
			"CARBON",
			"GREENX",
			"SPBDISBT"};
	
	
	private static FirefoxProfile getFirefoxProfile()
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv,text/csv,application/vnd.ms-excel");
		profile.setPreference("browser.download.dir",downloadFolder);
		profile.setPreference("browser.download.folderList",2);
		profile.setPreference("browser.download.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
		return profile;
	}
	
	public static void main(String[] args)
	{
		FirefoxProfile firefoxProfile = getFirefoxProfile();
		WebDriver driver = new FirefoxDriver(firefoxProfile);
		int retryCount = 0;
		
		//Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
		//Launch website
		//driver.navigate().to("http://www.nseindia.com/products/content/equities/indices/historical_index_data.htm");
	  
		//Maximize the browser
		driver.manage().window().maximize();
  
		for (int i=0; i<indices.length;) {
			String index = indices[i];
			driver.navigate().to("http://www.bseindia.com/indices/IndexArchiveData.aspx");
			System.out.println("Browsing for Index : " + index);
			
			Select indexSelector = new Select(driver.findElement(By.cssSelector("select[id$='ddlIndex']")));
			indexSelector.selectByValue(index);
	  
			driver.findElement(By.cssSelector("input[id$='rdbMonthly']")).click();
	  
			Select monthSelector = new Select(driver.findElement(By.cssSelector("select[id$='cmbMonthly']")));
			monthSelector.selectByValue("01");
	  
			Select yearSelector = new Select(driver.findElement(By.cssSelector("select[id$='cmbMYear']")));
			yearSelector.selectByValue("1993");
			
			// Click Calculate Button
			driver.findElement(By.cssSelector("input[id$='btnSubmit']")).click();
			
			try {
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("input[id$='btnDownload1']")).click();
				
				if(checkIfFileExists(downloadFolder, index+".csv") || retryCount > 5) {
					retryCount = 0;
					i++;
				}
				else
					retryCount++;
				
				//String csvUrl = driver.findElement(By.cssSelector("a[href$='" + year + ".csv']")).getAttribute("href");
				//driver.navigate().to(csvUrl);
				
				/*Robot robot = new Robot();
						
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(1000);
				
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);*/
			} catch(Exception ex) {
				System.out.println("Error Downloading for Index : " + index);
				ex.printStackTrace();
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
