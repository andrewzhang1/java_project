package guru99.EditCustomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guru99.pom.EditCustomerPage;
import guru99.pom.EditCustomerResultsPage;
import guru99.pom.HomePage;
import guru99.pom.LoginPage;
import static org.junit.Assert.*;

public class EditCustomerStepDefs {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	EditCustomerPage editCustomerPage;
	EditCustomerResultsPage editCustomerResultsPage;

	@Before
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:/AGZ1/workspace_java_final1/WebAppTesting/drivers/chromedriver.exe");

		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("the user has logged in with user id \"([^\"]*)\" and password \"([^\"]*)\"")
	public void userHasLoggedIn(String userName, String password) {
		loginPage = new LoginPage(driver);
		homePage = loginPage.Login(userName, password);

	}

	@And("the user is on the Edit Customer page")
	public void userIsOnEditCustomerPage() {
		editCustomerPage = homePage.getNavigationMenu().getEditCustomerPage();
	}

	@When("he submits \"([^\"]*)\" as customer id")
	public void userSubmitsCustomerId(String customerId) {
		editCustomerResultsPage = editCustomerPage.submitCustomerId(customerId);
	}

	@Then("ensure the customer name is \"([^\"]*)\"")
	public void userEnsuresCustomerName(String customerName) {
		assertEquals(customerName, editCustomerResultsPage.getCustomerName());
	}

	@And("ensure the customer gender is \"([^\"]*)\"")
	public void userEnsuresCustomerGender(String customerGender) {
		assertEquals(customerGender, editCustomerResultsPage.getCustomerGender());
	}

	@And("ensure the customer DoB is \"([^\"]*)\"")
	public void userEnsuresCustomerDOB(String customerDOB) {
		assertEquals(customerDOB, editCustomerResultsPage.getCustomerDOB());
	}

}
