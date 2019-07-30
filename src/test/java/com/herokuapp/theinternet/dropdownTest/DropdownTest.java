package com.herokuapp.theinternet.dropdownTest;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DropdownTest extends TestUtilities {
	@Test
	public void selectingDropdownTest () {
		log.info("Starting selecting dropdown Test ");
		
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on Dropdown link
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();
		
		//Select Option 2
		dropdownPage.selectOption(2);
		
		//Verify option 2 is selected
		String selectedOption = dropdownPage.getSelectedOption();
		Assert.assertTrue(selectedOption.equals("Option 2"), "Option 2 is not selected " + selectedOption);
		
		//Assert.assertTrue(dropdownPage.isOptionSelected(2),"Option is not selected");
	}


	
}
