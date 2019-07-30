package com.herokuapp.theinternet.alertstests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptsAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertsTests extends TestUtilities {
	@Test
	public void jsAlertTest() {
		log.info("Starting jsAlertTest");

		SoftAssert softAssert = new SoftAssert();

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click JavaScriptAlerts Link
		JavaScriptsAlertsPage javaScriptsAlerts = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Alert Button
		javaScriptsAlerts.openAlert();

		// Get Alert Text
		String actualAlertMessage = javaScriptsAlerts.getAlertText();

		// Click ok Button
		javaScriptsAlerts.acceptJsAlert();

		// Get Results Text
		String actualSuccessMessage = javaScriptsAlerts.getResultText();

		// Verifications
		// 1 --- Alert text is expected
		String expectedAlertMessage = "I am a JS Alert";
		// Soft Assert
		softAssert.assertTrue(actualAlertMessage.equals(expectedAlertMessage), "Different alert Message");

		// Hard Assert
		// Assert.assertTrue(actualAlertMessage.equals(expectedAlertMessage), "Different
		// alert Message");

		// 2 --- Result Text is expected
		String expectedSuccessMessage = "You successfuly clicked an alert";
		// Soft Assert
		softAssert.assertTrue(actualSuccessMessage.equals(expectedSuccessMessage), "Different Result Message");

		softAssert.assertAll();
		// hard - Assert.assertTrue(actualSuccessMessage.equals(expectedSuccessMessage),
		// "Different Result Message");
	}

	@Test
	public void jsDissmissTest() {

		SoftAssert softAssert = new SoftAssert();
		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click JavaScriptAlerts Link
		JavaScriptsAlertsPage javaScriptsAlerts = welcomePage.clickJavaScriptAlertsLink();

		// Click JS Confirm Button
		javaScriptsAlerts.openAlertJSConfirm();

		// Get Alert Text
		String actualAlertMessage = javaScriptsAlerts.getAlertText();

		// Dismiss the Alert
		javaScriptsAlerts.dismissCurrentAlert();

		// Get Results Text
		String actualSuccessMessage = javaScriptsAlerts.getResultText();

		// Verifications
		// 1 --- Alert text is expected

		String expectedAlertMessage = "I am a JS Confirm";
		softAssert.assertTrue(actualAlertMessage.equals(expectedAlertMessage), "Different alert Message");

		// 2 --- Result Text is expected
		String expectedSuccessMessage = "You clicked: Cancel";
		softAssert.assertTrue(actualSuccessMessage.equals(expectedSuccessMessage), "Different Result Message");

		softAssert.assertAll();

	}

	@Test
	public void jsPromptTest() {
		SoftAssert softAssert = new SoftAssert();
		// Open main Page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click JavaScriptAlerts Link
		JavaScriptsAlertsPage javaScriptsAlerts = welcomePage.clickJavaScriptAlertsLink();

		// Click JS prompt Button
		javaScriptsAlerts.openAlertJSPrompt();

		// Get Alert Text
		String actualAlertMessage = javaScriptsAlerts.getAlertText();

		// Type text into the alert
		String InsertedText = "Jueputica";
		javaScriptsAlerts.TypeTextInPrompt(InsertedText);

		// Click ok Button
		javaScriptsAlerts.acceptJsAlert();

		// Get Results Text
		String actualSuccessMessage = javaScriptsAlerts.getResultText();

		// Verifications
		// 1 --- Alert text is expected
		String expectedAlertMessage = "I am a JS prompt";
		softAssert.assertTrue(actualAlertMessage.equals(expectedAlertMessage), "Different alert Message");

		// 2 --- Result Text is expected
		softAssert.assertTrue(actualSuccessMessage.equals("You entered: " + InsertedText), "Different Result Message");
		softAssert.assertAll();
	}

}
