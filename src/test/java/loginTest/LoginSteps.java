package loginTest;

import static org.junit.Assert.assertEquals;

import ModelForms.LoginForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class LoginSteps {
	private LoginForm loginForm;
	
	@Given("^Потребителя отваря екрана за вход в системата$")
	public void openLoginScreen() {
		loginForm = new LoginForm();
	}

	@When("^Въведе \"([^\"]*)\" потребителско име$")
	public void addUserName(final String username) {
		loginForm.setUsername(username);
	}

	@When("^въведе парола: \"([^\"]*)\"$")
	public void addPassword(final String password) {
		loginForm.setPassword(password);
	}

	@When("^натисне бутона за вход в системата$")
	public void clickLoginButton() {
		loginForm.clickLoginButton();;
	}

	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(final String expectedMessage) {
		assertEquals(expectedMessage, loginForm.getLoginMessage());
	}
}
