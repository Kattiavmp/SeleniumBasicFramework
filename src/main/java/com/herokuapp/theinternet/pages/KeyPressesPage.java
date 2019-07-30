package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {
	private By bodyLocator = By.xpath("//xpath");
	private By resultTextLocator = By.xpath("/html//p[@id='result']");
	
	

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getResultText() {
	return find(resultTextLocator).getText();
	}
	
	public void pressKey (Keys key) {
		pressKeyTo(bodyLocator, key);
	}
	

}
