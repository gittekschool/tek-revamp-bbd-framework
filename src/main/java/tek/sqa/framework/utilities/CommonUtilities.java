package tek.sqa.framework.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	/**
	 * this method is doing click action
	 * Useful when Using By Locator.
	 * @param locator By Locator from Selenium.
	 */
	public void clickElement(By locator) {
		getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * This method is to get the text of element. 
	 * Useful when using @FindBy 
	 * @param element
	 * @return String of Element Text
	 */
	public String getElementText(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	/**
	 * JavaScript Executor for Scrolling down to the pixels
	 * @param pixels value of pixels
	 */
	public void scrollDown(long pixels) {
		//Cast Driver to JavascriptExecutor. 
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		js.executeScript("scroll(0, argumanets[0]);", pixels);
	}
}
