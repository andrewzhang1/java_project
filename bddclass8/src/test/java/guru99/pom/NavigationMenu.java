package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
	private WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a[href='BalEnqInput.php']")
    WebElement balanceEnquiryEntry;
	
	public NavigationMenu(WebDriver driver){
		this .driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BalanceEnquiryPage gotoBalanceEnquriyPage(){
		System.out.println("balance line");

		balanceEnquiryEntry.click();
		System.out.println("balance line2");

		return new BalanceEnquiryPage(driver);
	}
}




