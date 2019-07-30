package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoverOverPage extends BasePageObject {

	private By linkViewProfileLocator = By.xpath("/html//div[@id='content']//a[@href='/users/2']");

	public HoverOverPage(WebDriver driver, Logger log) {
		super(driver, log);
		
	}

	public void openUserProfile(int id) {
		String avatarXpath = "/html//div[@id='content']/div/div[" + id + "]/img[@alt='User Avatar']";
		hoverOver(find(By.xpath(avatarXpath)));
		click(linkViewProfileLocator);
	}

}
