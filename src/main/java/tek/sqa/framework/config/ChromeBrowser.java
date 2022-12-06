package tek.sqa.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser implements Browser {

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		//Bring Options
		//Bring Browser capabilities 
		//any other configuration for Chrome. 
		WebDriver driver = new ChromeDriver(); 
		driver.get(url);
		return driver;
	}

}
