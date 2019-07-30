package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject {

	private By iframeBodyLocator = By.id("tinymce");

	public EditorPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public String getEditorText() {
		switchToIframe("mce_0_ifr");
		return find(iframeBodyLocator).getText();
	}

}
