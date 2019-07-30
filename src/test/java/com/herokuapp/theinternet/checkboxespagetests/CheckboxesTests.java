package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities {

	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectingTwoCheckboxesTest ");
		
		//Open Main Page
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on checkboxes link
		CheckboxesPage checkboxesPage = welcomePage.clickCheckBoxesLink();
		
		//Select All Checkboxes
		checkboxesPage.selectAllCheckboxes();
		
		//Verify all checkboxes are checked
		Assert.assertTrue(checkboxesPage.checkedCheckBoxes(), "Not all the checkbox are checked");
	}

}
