package tek.sqa.framework.steps;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sqa.framework.pages.AccountDetailPage;
import tek.sqa.framework.utilities.CommonUtilities;
import tek.sqa.framework.utilities.DatabaseUtility;

public class AccountPageSteps extends CommonUtilities {

	@When("user click on view plans button")
	public void userClickOnViewPlansButton() {
		clickElement(AccountDetailPage.VIEW_PLAN_BUTTON);
	}

	@Then("all Plans Cost should be as Expected")
	public void allPlansCostShouldBeAsExpected() {
		DatabaseUtility dbConnection = super.getDbConnection();

		StringBuilder builder = new StringBuilder();
		builder.append("select email from primary_person ");
		builder.append("where id = (select primary_person_id from account_plan ");
		builder.append("order by created_date desc limit 1);");

		ArrayList<Map<String, Object>> result = dbConnection.executeSelectQuery(builder.toString());

		Assert.assertTrue(result.size() > 0 && result.size() == 1);
		System.out.println(result);
		String email = result.get(0).get("email").toString();

		StringBuilder query = new StringBuilder();
		query.append("select email , (sum(plan_price) * 6) as allPlanCost from primary_person as pp ");
		query.append("inner join account_plan as ap ");
		query.append("on pp.id = ap.primary_person_id ");
		query.append("where pp.email = '"+ email +"' ");
		query.append("group by pp.email;");
		
		ArrayList<Map<String, Object>> queryResult = dbConnection.executeSelectQuery(query.toString());
		Assert.assertTrue(queryResult.size() > 0 && queryResult.size() == 1);
		String allCost = queryResult.get(0).get("allPlanCost").toString();
		
		String actual = getElementText(AccountDetailPage.All_PLAN_COST_AMOUNT);
		String actualAfter = actual.replace("$", "").replace(",","");
		assertEqual(allCost, actualAfter);
	}

}
