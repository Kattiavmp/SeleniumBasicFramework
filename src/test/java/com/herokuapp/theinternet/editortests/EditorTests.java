package com.herokuapp.theinternet.editortests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class EditorTests extends TestUtilities {

	@Test
	public void defaultEditorValueText() {
		log.info("Starting defaultEditorValueText");
	
	
	//Open main page
	WelcomePage welcomePage = new WelcomePage(driver, log);
	welcomePage.openPage();
	
	//Scroll to the bottom
	sleep(5000);
	welcomePage.scrollToBottom();
	sleep(5000);
	
	//Click on WYSIWYG Editor link
	EditorPage editorPage = welcomePage.clickWysiwygEditorLink();
	
	//Get default Editor Text
	String editorText = editorPage.getEditorText();
	
	//Verification that new page contains Expected Text in Source
	Assert.assertTrue(editorText.equals("Your content goes here."), "Editor Text is not expected");
	}
}
