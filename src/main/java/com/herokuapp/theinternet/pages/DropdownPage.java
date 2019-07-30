package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {
	private By dropdownLocator = By.xpath("/html//select[@id='dropdown']");
	//private By optionsLocator = By.xpath("/html//select[@id='dropdown']/option"); este me sirve para el commented code

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	
	}
	
	
	public void selectOption(int option) {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		//Option#1
		dropdown.selectByValue("" + option);  // Como option es un int hay  q pasarlo a string 
	
	}
	
	//This method returns selected option in dropdown as a string
	
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}
	
	
	
	////// In case that I want to get other dropdown options //////
	
	
	/*
	 * public void selectOption(int option) { click(dropdownLocator);
	 * List<WebElement> dropdownOptions = findMany(optionsLocator); for (int i = 0;
	 * i < dropdownOptions.size(); i++) { WebElement element =
	 * dropdownOptions.get(i); if
	 * (element.getAttribute("value").equals(Integer.toString(option))) {
	 * element.click(); return; } } }
	 * 
	 * public boolean isOptionSelected(int option) { List<WebElement>
	 * dropdownOptions = findMany(optionsLocator); for (int i = 0; i <
	 * dropdownOptions.size(); i++) { WebElement element = dropdownOptions.get(i);
	 * String value = element.getAttribute("value"); String parsedOption =
	 * Integer.toString(option); boolean isSelected = element.isSelected(); if
	 * (value.equals(parsedOption) && isSelected) { return true ; } } return false;
	 * }
	 */
}
