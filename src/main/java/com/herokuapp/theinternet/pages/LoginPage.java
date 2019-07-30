package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {


	private By userNameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By loginButtonLocator = By.className("radius");
	private By errorMessageLocator = By.id("flash");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing Login with username" + username + "and " + "password "  + password);
		type(username, userNameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
		return new SecureAreaPage(driver, log);
		
	}
	
	public String getErrorMessage() {
		return find(errorMessageLocator).getText();
		
	}
	

}
