package tek.sqa.framework.utilities;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.sqa.framework.base.BaseSetup;

public class CommonUtilities extends BaseSetup {
	
	//All the methods we need for Testing should add here. 
	
	// Explicitly Waits. 
	// Selenium Actions. 
	
	private final long EXPLICITLY_WAIT_TIME_SECOND = 20; 
	
	/**
	 * this method will return new Instance of WebDriverWait
	 * @return WebDriverWait  for Explicitly Waits. 
	 */
	private WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICITLY_WAIT_TIME_SECOND));
	}
	
	/**
	 * This method use to Click on And Element 
	 * Useful when using @FindBy 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		System.out.println("Clicking on a Element ");
		getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	/**
	 * this method is doing click action
	 * Useful when Using By Locator.
	 * @param locator By Locator from Selenium.
	 */
	public void clickElement(By locator) {
		System.out.println("Clicking on a Element ");
		getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * This method is to get the text of element. 
	 * Useful when using @FindBy 
	 * @param element
	 * @return String of Element Text
	 */
	public String getElementText(WebElement element) {
		System.out.println("Getting and Element text ");
		return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public String getElementText(By element) {
		System.out.println("Getting and Element text ");
		return getWait().until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
	}
	
	/**
	 * Send Keys to Element By Locator. 
	 * 
	 * @param element  By
	 * @param value   String to sendKeys
	 */
	public void sendTextToInput(By element, String value) {
		System.out.println("Sending text and input element");
		WebElement input = getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
		input.sendKeys(value);
	}
	
	/**
	 * JavaScript Executor for Scrolling down to the pixels
	 * @param pixels value of pixels
	 */
	public void scrollDown(long pixels) {
		//Cast Driver to JavascriptExecutor.
		System.out.println("Scrolling down with pixels " + pixels);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		js.executeScript("scroll(0, arguments[0]);", pixels);
	}
	
	
	public void assertEqual(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}
	
	public void assertElementDisabled(By elementLocator) {
		WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		//element.isEnables. will return true if that element is enable otherwise will return false. 
		Assert.assertFalse("Element should be disabled", element.isEnabled());
	
	}
	
	public byte[] getScreenShot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
}
