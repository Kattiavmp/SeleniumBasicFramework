package com.herokuapp.theinternet.hoverovertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverOverPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HoversOverTests extends TestUtilities {

	@Test
	public void user2ProfileTest() {
		log.info("Starting HoverOver Test User 2");
	

	// Open main page
	WelcomePage welcomePage = new WelcomePage(driver, log);
	welcomePage.openPage();

	// Click on Hover Over Page Editor link
	HoverOverPage hoverover = welcomePage.clickHoverOverPage();
	
	// Open User 2 Profile
	hoverover.openUserProfile(2);
	
	// Verify correct user profile opened.
	Assert.assertTrue(hoverover.getCurrentUrl().contains("/users/2"), "Page is not the expected");
	

}
}
