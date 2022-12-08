package tek.sqa.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import tek.sqa.framework.utilities.CommonUtilities;

public class HooksSteps extends CommonUtilities{

	@Before
	public void initiateTest() {
		System.out.println("Starting Test Here. Opening Browser.");
		super.setupBrowser();
	}
	
	@After
	public void closeTest(Scenario scenario) {
		
		if (scenario.getStatus().equals(Status.FAILED)) {
			scenario.attach(getScreenShot(), "image/png", scenario.getName());
		}
		
		//quite browser after test done.
		System.out.println("Closing Test here. quite the browser.");
		super.quitBrowser();
	}
}
