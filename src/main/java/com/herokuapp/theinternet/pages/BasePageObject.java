package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	// Open page with given URL
	protected void openUrl(String url) {
		driver.get(url);
	}

	// Find element using given locator
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	// Get current Alert Text
	public String getCurrentAlertText() {
		return driver.switchTo().alert().getText();
	}

	// Accept Current Alert
	public void acceptCurrentAlert() {
		driver.switchTo().alert().accept();
	}

	// Dismiss Current Alert
	public void dismissCurrentAlert() {
		driver.switchTo().alert().dismiss();
	}

	// Insert text in a Current Alert
	public void TypeTextInPrompt(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// Find locator for Many elements
	protected List<WebElement> findMany(By locator) {
		return driver.findElements(locator);
	}

	// Click on element with given locator when it is visible
	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();

	}

	// GetCurrent URL from browser
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Type value in a locator
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}

	// Wait for specific ExpectedCondition for the given amount of time in seconds
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	// Wait for given number of seconds for element with given locator to be visible
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {

			}
			attempts++;
		}
	}

	// Move to new chrome tab

	private String getCurrentPageTitle() {
		return driver.getTitle();
	}

	public void switchToWindowWithTitle(String pageTitle) {
		// Switching to new window
		String firstWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIterator = allWindows.iterator();

		while (windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next().toString();
			if (!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				if (getCurrentPageTitle().equals(pageTitle)) {
					break;
				}

			}
		}
	}

	// View Page Source
	public String getPageSource() {
		return driver.getPageSource();
	}

	// Switch to Iframe
	public void switchToIframe(String id) {
		driver.switchTo().frame(id);
	}

	// Method to press any key from the keybord
	public void pressKeyTo(By locator, Keys key) {
		find(locator).sendKeys(key);
	}

	// Perform Scroll to the bottom
	public void scrollToBottom() {
		log.info("Scrolling to the bottom of the page");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// Drag and Drop
	public void dragAndDrop(WebElement source, WebElement target) {
		// Actions action = new Actions(driver); Este no funciona por un error open
		// action.dragAndDrop(source, target).build();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				source, target);

	}
	
	// Hover Over
	public void hoverOver(WebElement hover) {
		Actions action = new Actions(driver);
		action.moveToElement(hover).click().build().perform();	
	}
	
	//
	public WebElement searchElementByString(List<WebElement> list, String searchParameter) {
		for (WebElement webElement : list) {
			if (webElement.getText().contains(searchParameter)) {
				return webElement;
			}
		}
		return null;
	}
	
	//Set Slider Value   -- Plan A however it is not working for th testing page
	public void setSliderValue(WebElement slider, int value) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, value, 0).build().perform();
	}
}
