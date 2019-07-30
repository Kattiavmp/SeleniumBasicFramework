package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePageObject {
	
	private By sliderLocator = By.xpath("/html//div[@id='content']//input[@value='0']");
	private By sliderValueLocator = By.xpath("/html//span[@id='range']");

	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

		//Move slider to the specified value
	public void setSliderTo(String value) {
		int steps = (int) (Double.parseDouble(value) / 0.5);   //0.5 due to it is the 'step' in the slider se mueve de 0.5 en 0.5
		//Perform Steps
		pressKeyTo(sliderLocator, Keys.ENTER);  //press key to q ya tenemos en base
		for (int i = 0; i < steps; i++) {
			pressKeyTo(sliderLocator, Keys.ARROW_RIGHT); 
		}	
	}
	
	// Getting slider value // 
	public String getSliderValue() {
		return find(sliderValueLocator).getText();
	}
}
