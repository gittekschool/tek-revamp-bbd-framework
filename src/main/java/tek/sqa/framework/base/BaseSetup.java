package tek.sqa.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import tek.sqa.framework.config.ChromeBrowser;
import tek.sqa.framework.config.EdgeBrowser;
import tek.sqa.framework.utilities.ReadYamlFiles;

public class BaseSetup {

	// Encapsulated property.
	private static WebDriver driver;

	private final ReadYamlFiles environmentVariables;

	// ready property file (env_config yaml file).
	public BaseSetup() {
		String configFilePath = System.getProperty("user.dir") + "/src/main/resources/configuration/env_configs.yml";
		// handle exception might throw by the method.
		try {
			this.environmentVariables = ReadYamlFiles.getInstance(configFilePath);
		} catch (FileNotFoundException ex) {
			System.out.println("Exception while reading Yaml File. posible path problem check the directory.");
			throw new RuntimeException("Unable to Load environment variables." + ex.getMessage());
		}
	}

	public void setupBrowser() {
		HashMap<String, Object> uiVariables = environmentVariables.getProprty("ui");
		String url = uiVariables.get("url").toString();
		
		switch (uiVariables.get("browser").toString().toLowerCase()) {
		case "chrome":
			boolean headless = (boolean) uiVariables.get("headless");
			ChromeBrowser chrome = new ChromeBrowser(headless);
			driver = chrome.openBrowser(url);
			break;
		case "edge":
			EdgeBrowser edge = new EdgeBrowser();
			driver = edge.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Env Config have wrong browser Type check Env Config");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
