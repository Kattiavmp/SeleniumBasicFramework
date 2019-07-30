package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	protected void sleep(long millis) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Data Provider files 
	@DataProvider(name="files")
	protected static Object[][] files() {
		return new Object[][] {
			{1, "index.html"},
			{2, "logo.png"},
			{3, "text.txt"}
		};
	}
	
	//Take Screenshot
	protected void takeSreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = getScreenshotPath(fileName, testSuiteName, testName, testMethodName);
	try {
		FileUtils.copyFile(srcFile, new File(path));
	} catch (IOException e) {
		e.printStackTrace();
	}		
	}

	private String getScreenshotPath(String fileName, String testSuiteName, String testName, String testMethodName ) {
		return new StringBuilder()
		   .append(System.getProperty("user.dir"))
		   .append(File.separator)
		   .append("test-output")
		   .append(File.separator)
		   .append("screenshots")
		   .append(File.separator)
		   .append(getTodaysDate())
		   .append(File.separator)
		   .append(testSuiteName)
		   .append(File.separator)
		   .append(testName)
		   .append(File.separator)
		   .append(testMethodName)
		   .append(File.separator)
		   .append(getSystemTime())
		   .append(" ")
		   .append(fileName)
		   .append(".png").toString();
	}
	
	// Todays date in yyyMMdd format
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyMMdd")).format(new Date());
	}
	
	// Current time in HHmmssSSS
	public String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS")).format(new Date());
	}
	
	//Get logs from browser console
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
}

