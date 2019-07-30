package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DragAndDropPage extends BasePageObject{
	
	private By aElement = By.xpath("/html//div[@id='column-a']");
	private By bElement = By.xpath("/html//div[@id='column-b']");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void dragAToB() {
		WebElement sourceA = find(aElement);
		WebElement sourceB = find(bElement);
		dragAndDrop(sourceA, sourceB);
	}
	
	public String getColumnAText() {
		WebElement sourceA = find(aElement);
		return sourceA.getText();
	}
	
	public String getColumnBText() {
		WebElement sourceB = find(bElement);
		return sourceB.getText();
	}
	
	

}
