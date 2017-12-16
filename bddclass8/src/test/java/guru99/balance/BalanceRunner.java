package guru99.balance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/guru99/balance.feature",
		glue={"guru99.balance"}
	)
public class BalanceRunner {

}
