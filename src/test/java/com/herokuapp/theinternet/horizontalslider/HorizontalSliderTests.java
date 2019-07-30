package com.herokuapp.theinternet.horizontalslider;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HorizontalSliderTests extends TestUtilities {
	
	@Test
	public void sliderTest() {
		log.info("Starting Slider Test");

	// Open main page
	WelcomePage welcomePage = new WelcomePage(driver, log);
	welcomePage.openPage();

	// Click on Horizontal Slider link
	HorizontalSliderPage horizontalSlider = welcomePage.clickHorizontalSliderPage();
	
	String value = "3.5";
	
	// Set Slider Value
	sleep(2000);
	horizontalSlider.setSliderTo(value);
	sleep(2000);
	
	//Verify slider value
	String sliderValue = horizontalSlider.getSliderValue();
	Assert.assertTrue(sliderValue.contains("3"), "Range is not correct");
	

}
}
