package finalRankingTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import ModelForms.ChildForm;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.PlacementService;

public class FinalRankingSteps {
	private String phone;
	
	@Given("^Потребителя отваря екрана за окончателното класиране$")
	public void openRegisterScreen() throws Throwable {
		PlacementService.calculateRanking();;
	}
	
	@When("^Въвежда телефонния номер на родителя: \"([^\"]*)\"$")
	public void addPhone(final String phone) throws Throwable {
		this.phone = phone;
	}

	@ParameterType("\"\\[([0-9, ]*)\\]\"")
    public List<Integer> listOfIntegers(String integers) {
        return Arrays.stream(integers.split(", ?"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
	@Then("Вижда резултат: {listOfIntegers}")
	public void showResult(List<Integer> list) throws Throwable {
		Assert.assertEquals(list, PlacementService.showChildRanking());
	}
	
	@Then("Админът вижда резултат: {listOfIntegers}")
	public void adminShowResult(List<Integer> list) throws Throwable {
		Assert.assertEquals(list, PlacementService.showChildRanking(phone));
	}
}
