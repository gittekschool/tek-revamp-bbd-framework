package tek.sqa.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sqa.framework.pages.CSRLoginPage;
import tek.sqa.framework.utilities.CommonUtilities;

public class LoginPageSteps extends CommonUtilities {

	@Then("Login page title is {string}")
	public void login_page_title_is(String expectedTitle) {

		String actualTitle = getElementText(CSRLoginPage.APP_TITLE);
		// Assert Here expected with actual.
		assertEqual(expectedTitle, actualTitle);
	}

	@Then("Loaded Section is {string}")
	public void loaded_section_is(String expectedSectionTitle) {
		String actualSectionTitle = getElementText(CSRLoginPage.CSR_LOGIN_SECTION_TITLE);
		// Assert Here expected with actual.
		assertEqual(expectedSectionTitle, actualSectionTitle);
	}
	
	@When("user enter username {string} and password {string}")
	public void user_enter_username_and_password(String username, String password) {
	   //enter username
		sendTextToInput(CSRLoginPage.USERNAME_INPUT, username);
		
		sendTextToInput(CSRLoginPage.PASSWORD_INPUT, password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    clickElement(CSRLoginPage.LOGIN_BUTTON);
	}
	
	@When("wait {int} second")
	public void wait_second(Integer waitInSecond) {
	    try {
	    	Thread.sleep(waitInSecond * 1000);
	    }catch (InterruptedException e) {
	    	System.out.println("Exception on thread Sleep");
	    }
	}
	
	@Then("validate banner message to be {string}")
	public void validate_banner_message_to_be(String expectedMessaged) {
	    String actualMessage = getElementText(CSRLoginPage.BANNER_MESSAGE);
	    
	    assertEqual(expectedMessaged, actualMessage.trim());
	}

	
	@Then("login button should be disabled.")
	public void login_button_should_be_disabled() {
	    assertElementDisabled(CSRLoginPage.LOGIN_BUTTON);
	}
	

}
