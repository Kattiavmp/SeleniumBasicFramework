package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class UploadTests extends TestUtilities {
	
	
	@Test(dataProvider="files")
	public void fileUploadTest(int testNumber, String fileName) { 
		log.info("Starting file Upload Test number " + testNumber + "for " + fileName);
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on FileUpload Page
		FileUploadPage fileUpload = welcomePage.clickFileUploadLink();
		
		//Select file
		fileUpload.selectFile(fileName);
		
		//Push upload button
		fileUpload.clickUploadButton();
		
		// verify selecte file uploaded
		String imageName = fileUpload.getImageName();
		
		//
		Assert.assertTrue(imageName.contains(fileName), "Uploaded Image Name is not the expected");		
				
}
}
