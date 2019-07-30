package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptsAlertsPage extends BasePageObject {
	
	private By jsAlertTextElement = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
	private By jsConfirmElement = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
	private By jsPrompt = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");
	private By resultText = By.xpath("/html//p[@id='result']");

	public JavaScriptsAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	// Open JS Alert
	public void openAlert() {
		click(jsAlertTextElement);
	}
	
	//Get alert text
	public String getAlertText() {
		return getCurrentAlertText();
	}
	
	//click ok button
	public void acceptJsAlert() {
		acceptCurrentAlert();
	}
	
	//Get result text
	public String getResultText() {
		return find(resultText).getText();
	}

		// Open JS Confirm Alert
	public void openAlertJSConfirm() {
		click(jsConfirmElement);
		
	}
	public void openAlertJSPrompt() {
		click(jsPrompt);
		
	}

}
