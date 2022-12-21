package tek.sqa.framework.pages;

import org.openqa.selenium.By;

public class AccountDetailPage {
	
	public static final By VIEW_PLAN_BUTTON = By.xpath("//mat-card-content/mat-grid-list//mat-grid-tile[4]//button");

	public static final By All_PLAN_COST_AMOUNT = By.xpath("//div[@class='dialog']/mat-dialog-content/div[1]/span[2]");
}
