package tek.sqa.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tek.sqa.framework.utilities.CommonUtilities;

public class HooksSteps extends CommonUtilities{

	@Before
	public void initiateTest() {
		System.out.println("Starting Test Here. Opening Browser.");
		super.setupBrowser();
	}
	
	@After
	public void closeTest() {
		//quite browser after test done.
		System.out.println("Closing Test here. quite the browser.");
		super.quitBrowser();
	}
}
