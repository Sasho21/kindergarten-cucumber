package childPlacementTest;

import static org.junit.Assert.assertEquals;

import ModelForms.ChildForm;
import ModelForms.RegisterForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChildPlacementSteps {
	private ChildForm childForm;

	@Given("^Потребителя отваря екрана за регистрация на дете$")
	public void openRegisterScreen() throws Throwable {
		this.childForm = new ChildForm();
	}

	@When("^Въвежда собственото име на детето: \"([^\"]*)\"$")
	public void addFirstName(final String first_name) throws Throwable {
		childForm.setFirstName(first_name);
	}

	@When("^Въвежда фамилното име на детето: \"([^\"]*)\"$")
	public void addLastName(final String last_name) throws Throwable {
		childForm.setLastName(last_name);
	}

	@When("^Въвежда рождената дата на детето: \"([^\"]*)\"$")
	public void DateOfBirth(final String date_of_birth) throws Throwable {
		childForm.setDateOfBirth(date_of_birth);
	}

	@When("^Въвежда дали детето е инвалид: \"([^\"]*)\"$")
	public void addIsDisabled(final boolean disabled) throws Throwable {
		childForm.setIsDisabled(disabled);
	}
	
	@When("^Въвежда броя на работещите родители: \"([^\"]*)\"$")
	public void addWorkingParents(final int count) throws Throwable {
		childForm.setWorkingParents(count);
	}
	
	@When("^Въвежда дали детето има близнак: \"([^\"]*)\"$")
	public void addHasTwin(final boolean has_twin) throws Throwable {
		childForm.setHasTwin(has_twin);
	}
	
	@When("^Въвежда телефонния номер на родителя: \"([^\"]*)\"$")
	public void addParentPhone(final String phone) throws Throwable {
		childForm.setParentPhone(phone);
	}

	@When("^Натиска бутона за регистрация$")
	public void clickRegisterChildButton() throws Throwable {
		childForm.clickRegisterChildButton();
	}
	
	@When("^Админът натиска бутона за регистрация$")
	public void adminClickRegisterChildButton() throws Throwable {
		childForm.adminClickRegisterChildButton();
	}
	
	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(final String expectedMessage) {
		assertEquals(expectedMessage, childForm.getMessage());
	}
}
