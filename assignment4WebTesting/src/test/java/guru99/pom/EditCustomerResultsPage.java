package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerResultsPage {

	@FindBy(name = "name")
	WebElement customerName;

	@FindBy(name = "gender")
	WebElement customerGender;

	@FindBy(name = "dob")
	WebElement customerDOB;

	public EditCustomerResultsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public String getCustomerName() {
		return customerName.getAttribute("value");

	}

	public String getCustomerGender() {
		return customerGender.getAttribute("value");

	}

	public String getCustomerDOB() {
		return customerDOB.getAttribute("value");

	}

}
