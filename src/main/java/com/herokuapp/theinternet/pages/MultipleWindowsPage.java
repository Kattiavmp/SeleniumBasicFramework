package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {
	
	private By clickHereLinkLocator = By.linkText("Click Here");


	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

// Click here option
	
	public void openNewTab() {
		click(clickHereLinkLocator);	
	}
	
// Find Page with Title "New Window" and switch to it
	public NewWindowPage switchToNewWindowPage() {
		log.info("Looking for 'New Window Page");
		switchToWindowWithTitle("New Window");
		return new NewWindowPage(driver, log);
	}
	
   

}
