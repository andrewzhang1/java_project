package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;

	@FindBy(name = "cusid")
	WebElement customerId;

	@FindBy(name = "AccSubmit")
	WebElement submitButton;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public EditCustomerResultsPage submitCustomerId(String customerIdValue) {
		customerId.clear();
		customerId.sendKeys(customerIdValue);
		submitButton.click();
		return new EditCustomerResultsPage(driver);
	}

}
