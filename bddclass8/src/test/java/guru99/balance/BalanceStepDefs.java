package guru99.balance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guru99.pom.BalanceEnquiryPage;
import guru99.pom.BalanceResultPage;
import guru99.pom.HomePage;
import guru99.pom.LoginPage;
import guru99.pom.NavigationMenu;

public class BalanceStepDefs {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private NavigationMenu navMenu;
	private BalanceEnquiryPage enquiry;
	private BalanceResultPage result;
	
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
	
	@Given("the user has logged in with user id %([^%]*)% and password %([^%]*)%")
	public void userHasLoggedIn(String userId, String password) {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(userId, password);
	}
	
	@And("the user is on the Balance Query page")
	public void heIsOnBalanceQueryPage() {
		System.out.println("firts line");
		navMenu = homePage.getNavigationMenu();
		System.out.println("second line");

		enquiry = navMenu.gotoBalanceEnquriyPage();
	}
	
	@When("he submits %([^%]*)% as account no")
	public void heSubmitsAccountNo(String acctNo) {
		result = enquiry.query(acctNo);
	}
	
	@Then("ensure the account no is %([^%]*)%")
	public void ensureAcctNo(String acctNo) {
		assertEquals(acctNo, result.getAcctNo());
	}
	
	@Then("ensure the account type is %([^%]*)%")
	public void ensureAcctType(String acctType) {
		assertEquals(acctType, result.getAcctType());
	}

	@Then("ensure the balance is %([^%]*)%")
	public void ensureBalance(String balance) {
		assertEquals(balance, result.getBalance());
	}	
}
