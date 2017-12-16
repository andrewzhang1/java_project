package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
	
	WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a[href='EditCustomer.php']")
	WebElement editCustomerMenu;
	
	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	

	public EditCustomerPage getEditCustomerPage() {
		editCustomerMenu.click();
		return new EditCustomerPage(driver);
		
	}
}
