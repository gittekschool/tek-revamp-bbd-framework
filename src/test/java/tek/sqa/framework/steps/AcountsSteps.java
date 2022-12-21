package tek.sqa.framework.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sqa.framework.pages.AccountsPages;
import tek.sqa.framework.utilities.CommonUtilities;
import tek.sqa.framework.utilities.DatabaseUtility;

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
	
	@When("user filter by email that have account plan")
	public void userFilterByEmailThatHaveAccountPlan() {
	   DatabaseUtility dbConnection = super.getDbConnection();
	   StringBuilder builder = new StringBuilder();
	   builder.append("select email from primary_person ");
	   builder.append("where id = (select primary_person_id from account_plan ");
	   builder.append("order by created_date desc limit 1);");
	   
	   ArrayList<Map<String, Object>> result =dbConnection.executeSelectQuery(builder.toString());
	  
	   Assert.assertTrue(result.size() > 0 && result.size() == 1);
	   System.out.println(result);
	   String email = result.get(0).get("email").toString();
	   sendTextToInput(AccountsPages.FILTER_INPUT, email);
	}
	
	@When("user click on first row detail link")
	public void userClickOnFirstRowDetailLink() {
	    clickElement(AccountsPages.FIRST_ROW_DETAIL_LINK);
	}

}
