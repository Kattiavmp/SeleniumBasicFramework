package com.herokuapp.theinternet.keypressestests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesTest extends TestUtilities {
	
	@Test
	public void pressKeyTest() {
		log.info("Starting PressKeyTest");
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on WYSIWYG Editor link
		KeyPressesPage pressesPage = welcomePage.clickKeyPressessLink();
		
		//Push keyboard key
		pressesPage.pressKey(Keys.ENTER);
		
		//Get Results Text
		String result = pressesPage.getResultText();
		
		//Verify Result Text is Expected
		Assert.assertTrue(result.equals("You entered: ENTER"), "Expected Message is not correct");
		
		
		
	}

}
