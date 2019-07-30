package com.herokuapp.theinternet.windowstests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class WindowsTests extends TestUtilities {

	@Test
	public void newWindowsTest() {
		log.info("Starting WindowsTests");

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click MultipleWindows Link
		MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();

		// Click 'Click Here' link to open a new window.
		multipleWindowsPage.openNewTab();
		
		// Find a switch to new Window Page
		multipleWindowsPage.switchToNewWindowPage();
		
		// Verification that new page contains expected text in source
		String currentSource = multipleWindowsPage.getPageSource();
		Assert.assertTrue(currentSource.contains("New Window"), "New page not found");
		
		
		
	}

}
