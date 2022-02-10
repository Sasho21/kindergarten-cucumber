package registerTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.User;
import services.RegisterService;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import ModelForms.RegisterForm;

public class RegisterSteps {
	private RegisterForm registerForm;

	@Given("^Потребителя отваря екрана за регистрация на потребител$")
	public void openRegisterScreen() throws Throwable {
		this.registerForm = new RegisterForm();
	}

	@When("^Въвежда потребитесло име: \"([^\"]*)\"$")
	public void addUsername(final String username) throws Throwable {
		registerForm.setUsername(username);
	}

	@When("^Въвежда първа парола: \"([^\"]*)\"$")
	public void addPassword(final String password) throws Throwable {
		registerForm.setPassword(password);
	}

	@When("^Въвежда втора парола: \"([^\"]*)\"$")
	public void addConfirmPassword(final String password) throws Throwable {
		registerForm.setConfirmPassword(password);
	}

	@When("^Въвежда електронна поща: \"([^\"]*)\"$")
	public void addEmail(final String email) throws Throwable {
		registerForm.setEmail(email);
	}
	
	@When("^Въвежда телефонен номер: \"([^\"]*)\"$")
	public void addPhone(final String phone) throws Throwable {
		registerForm.setPhone(phone);
	}
	
	@When("^Въвежда собственото си име: \"([^\"]*)\"$")
	public void addFirstName(final String first_name) throws Throwable {
		registerForm.setFirstName(first_name);
	}
	
	@When("^Въвежда фамилното си име: \"([^\"]*)\"$")
	public void addLastName(final String last_name) throws Throwable {
		registerForm.setLastName(last_name);
	}

	@When("^Натиска бутона за регистрация$")
	public void clickRegisterButton() throws Throwable {
		registerForm.clickRegisterButton();
	}
	
	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(final String expectedMessage) {
		assertEquals(expectedMessage, registerForm.getRegisterMessage());
	}
}
