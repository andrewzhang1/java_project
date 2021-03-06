package guru99.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guru99.pom.HomePage;
import guru99.pom.LoginPage;

public class LoginStepDefs {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
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
	
	@Given("the user is on the login page")
	public void heIsOnLoginPage() {
		loginPage = new LoginPage(driver);
	}
	
	@When("he enters %([^%]*)% as user id")
	public void heEntersUserId(String userId) {
		loginPage.entersUserId(userId);
	}
	
	@When("he enters %([^%]*)% as password")
	public void heEntersPassword(String password) {
		loginPage.entersPassword(password);
	}
	
	@And("he clicks the Login button")
	public void heClicksLoginButton() {
		homePage = loginPage.clickLogin();
	}
	
	@Then("ensure the manager id is %([^%]*)%")
	public void ensureManagerId(String managerId) {
		assertTrue(homePage.getManagerId().endsWith(managerId));
	}
}
