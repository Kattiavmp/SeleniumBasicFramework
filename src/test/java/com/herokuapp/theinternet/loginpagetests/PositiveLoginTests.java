package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		takeSreenshot("WelcomePage opened");

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		takeSreenshot("Login Page opened");
		
		// enter username and password and execute login
		SecureAreaPage securePage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		takeSreenshot("Secure Area Page Opened");
	
		// validate new url
		Assert.assertEquals(securePage.getCurrentUrl(), securePage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(securePage.isLogOutButtonVisible(),
				"logOutButton is not visible.");		
	

		// Successful log in message
		
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = securePage.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
