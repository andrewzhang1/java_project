package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "uid")
	WebElement userId;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	private String URL = "http://demo.guru99.com/v4/";

	public LoginPage(WebDriver driver) {
		driver.get(URL);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public HomePage Login(String userName, String userPassword) {
		userId.clear();
		userId.sendKeys(userName);
		password.clear();
		password.sendKeys(userPassword);
		loginBtn.submit();
		return new HomePage(driver);

	}

}
