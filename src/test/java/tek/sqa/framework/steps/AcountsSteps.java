package tek.sqa.framework.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sqa.framework.pages.AccountsPages;
import tek.sqa.framework.utilities.CommonUtilities;

public class AcountsSteps extends CommonUtilities{
	
	@When("user click on accounts Link")
	public void userClickOnAccountsLink() {
	   clickElement(AccountsPages.ACCOUNT_LINK_BUTTON);
	}
	@Then("number of rows in account table should be {int}")
	public void numberOfRowsInAccountTableShouldBe(Integer expectedRowsCount) {
	   List<WebElement> elementList = getElementsList(AccountsPages.ACCOUNT_TABLE_ROWS);
	   
	   assertEqual(expectedRowsCount, elementList.size());
	}

}
