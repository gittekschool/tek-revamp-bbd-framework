package tek.sqa.framework.pages;

import org.openqa.selenium.By;

public class AccountsPages {
	
	public static final By ACCOUNT_LINK_BUTTON = By.xpath("//a//span[contains(text(),'Accounts')]/../..");
	
	public static final By ACCOUNT_TABLE_ROWS = By.xpath("//table/tbody/tr");
	
	public static final By FILTER_INPUT = By.cssSelector("#filter");
	
	public static final By FIRST_ROW_DETAIL_LINK = By.xpath("//table/tbody/tr[1]/td[8]/a");
	
}
