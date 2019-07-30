package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragAndDropTests extends TestUtilities {
	
	@Test
	public void dragAToBTest() {
		log.info("Starting dragAToBTest");
	
	
	//Open main page
	WelcomePage welcomePage = new WelcomePage(driver, log);
	welcomePage.openPage();
	
	
	//Click on Drag And Drop Page Editor link
	DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();
	
	//Drag box A and dropit on box B
	sleep(3000);
	dragAndDropPage.dragAToB();
	sleep(3000);
	
	//Verify correct headers in correct boxes
	String columnAText = dragAndDropPage.getColumnAText();
	String columnBText = dragAndDropPage.getColumnBText();
	Assert.assertTrue(columnAText.equals("B"), "Expected column name is B but it is displaying " + columnAText);
	Assert.assertTrue(columnBText.equals("A"), "Expected column name is B but it is displaying " + columnBText);

}
}
