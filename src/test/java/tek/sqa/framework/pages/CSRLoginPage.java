package tek.sqa.framework.pages;

import org.openqa.selenium.By;

public class CSRLoginPage {
	
	//Page Object Model Follow By Approach. 
	
	public static final By APP_TITLE = By.xpath("//mat-toolbar/span[1]");
	
	public static final By CSR_LOGIN_SECTION_TITLE = By.xpath("//mat-card/mat-card-title/strong");
	
	public static final By USERNAME_INPUT = By.name("username");
	
	public static final By PASSWORD_INPUT = By.name("password");
	
	public static final By LOGIN_BUTTON = By.id("loginButton");

	public static final By BANNER_MESSAGE = By.xpath("//app-banner/div");
}
