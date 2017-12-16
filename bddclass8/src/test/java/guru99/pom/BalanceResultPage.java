package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceResultPage {
	@FindBy(xpath = "//*[@id=\"balenquiry\"]/tbody/tr[6]/td[2]")
	private WebElement acctNo;

	@FindBy(xpath = "//*[@id=\"balenquiry\"]/tbody/tr[11]/td[2]")
	private WebElement acctType;

	@FindBy(xpath = "//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]")
	private WebElement balance;
	
	public BalanceResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getAcctNo() {
		return acctNo.getText();
	}
	
	public String getAcctType() {
		return acctType.getText();
	}
	
	public String getBalance() {
		return balance.getText();
	}
}
