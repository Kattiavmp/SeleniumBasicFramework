package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePageObject {
	
	private By chooseFileLink = By.xpath("/html//input[@id='file-upload']");
	private By uploadButton = By.xpath("/html//input[@id='file-submit']");
	private By imageName =  By.xpath("/html//div[@id='uploaded-files']");


	
	public FileUploadPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void selectFile(String file) {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/" + file;
		type(filePath,chooseFileLink);
	}
	
	public void clickUploadButton() {
		click(uploadButton);
	}
	
	public String getImageName() {
		return find(imageName).getText();
	}

}
