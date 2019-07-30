package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {

	private By checkboxesLocator = By.xpath("//input[@type='checkbox']");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	//Get list of all checkboxes and check if unchecked
	public void selectAllCheckboxes() {
		List<WebElement> checkboxes = findMany(checkboxesLocator);
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkboxElement = checkboxes.get(i);
			if (!checkboxElement.isSelected()) {
				checkboxElement.click();
			}
		}
	}
	
	//Verify all availabe checkboxes are checked.
	public boolean checkedCheckBoxes() {
		List<WebElement> checkboxes = findMany(checkboxesLocator);
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkboxElement = checkboxes.get(i);
			if (!checkboxElement.isSelected()) {
				return false;
			}
		}
		return true;
	} 
}
