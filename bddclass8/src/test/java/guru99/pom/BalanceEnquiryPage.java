package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {
	private WebDriver driver;
	
	@FindBy(name = "accountno")
	private WebElement accountField;
	
	@FindBy(name = "AccSubmit")
	private WebElement submitBtn;
	
	public BalanceEnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BalanceResultPage query(String accountNo) {
		accountField.clear();
		accountField.sendKeys(accountNo);
		submitBtn.click();
		return new BalanceResultPage(driver);
	}
}
