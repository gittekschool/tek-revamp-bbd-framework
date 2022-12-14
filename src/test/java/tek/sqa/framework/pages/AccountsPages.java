package tek.sqa.framework.pages;

import org.openqa.selenium.By;

public class AccountsPages {
	
	public static final By ACCOUNT_LINK_BUTTON = By.xpath("//a//span[contains(text(),'Accounts')]/../..");
	
	public static final By ACCOUNT_TABLE_ROWS = By.xpath("//table/tbody/tr");
}
