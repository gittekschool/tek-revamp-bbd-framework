package tek.sqa.framework.config;

import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Mohammad Shokriyan
 *
 */
public interface Browser {
	
	/**
	 * Returning WebDriver one Implemented with any of browser types. 
	 * @param url URI should pass to open 
	 * @return
	 */
	WebDriver openBrowser(String url);

}
