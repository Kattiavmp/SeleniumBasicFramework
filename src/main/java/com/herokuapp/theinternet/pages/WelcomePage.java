package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com";
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLinkLocator = By.xpath("//*[@id=\"content\"]/ul/li[6]/a");
	private By dropDownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLocator = By.linkText("Multiple Windows");
	private By wsysiwygEditorLocator = By.linkText("WYSIWYG Editor");
	private By keyPressessLocator = By.linkText("Key Presses");
	private By uploadFileLocator = By.linkText("File Upload");
	private By dragAndDropLocator = By.linkText("Drag and Drop");
	private By hoverOverLocator = By.linkText("Hovers");
	private By horizontalSliderLocator = By.linkText("Horizontal Slider");
	private By jsErrorLocator = By.linkText("JavaScript onload event error");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);

	}

	// Open WelcomePage with its url
	public void openPage() {
		log.info("Opening Page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	// Code to click 'form authentication Page'
	public LoginPage clickFormAuthenticationLink() {
		log.info("Opening Page: " + pageUrl);
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	// Code to click checkboxes page
	public CheckboxesPage clickCheckBoxesLink() {
		log.info("Opening Page: " + pageUrl); // Preguntar Pecoso
		click(checkBoxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	// Code to Click dropdown page
	public DropdownPage clickDropdownLink() {
		log.info("Opening Page: " + pageUrl);
		click(dropDownLinkLocator);
		return new DropdownPage(driver, log);
	}

	// Code to Click JavaScript Alerts
	public JavaScriptsAlertsPage clickJavaScriptAlertsLink() {
		log.info("Opening Page: " + pageUrl);
		click(javaScriptAlertsLocator);
		return new JavaScriptsAlertsPage(driver, log);
	}

	// Code to Click MultipleWindows Page
	public MultipleWindowsPage clickMultipleWindowsLink() {
		log.info("Opening Page: " + pageUrl);
		click(multipleWindowsLocator);
		return new MultipleWindowsPage(driver, log);
	}

	// Code to Click WYSIWYG Editor Link
	public EditorPage clickWysiwygEditorLink() {
		log.info("Opening Page: " + pageUrl);
		click(wsysiwygEditorLocator);
		return new EditorPage(driver, log);
	}

	public KeyPressesPage clickKeyPressessLink() {
		log.info("Opening Page: " + pageUrl);
		click(keyPressessLocator);
		return new KeyPressesPage(driver, log);
	}

	public FileUploadPage clickFileUploadLink() {
		log.info("Opening Page: " + pageUrl);
		click(uploadFileLocator);
		return new FileUploadPage(driver, log);
	}

	public DragAndDropPage clickDragAndDropLink() {
		log.info("Opening Page: " + pageUrl);
		click(dragAndDropLocator);
		return new DragAndDropPage(driver, log);
	}

	public HoverOverPage clickHoverOverPage() {
		log.info("Opening Page: " + pageUrl);
		click(hoverOverLocator);
		return new HoverOverPage(driver, log);
	}

	public HorizontalSliderPage clickHorizontalSliderPage() {
		log.info("Opening Page: " + pageUrl);
		click(horizontalSliderLocator);
		return new HorizontalSliderPage(driver, log);
	}

	public JSErrorPage clickJSErrorPage() {
		log.info("Opening Page: " + pageUrl);
		click(jsErrorLocator);
		return new JSErrorPage(driver, log);
	}


}
