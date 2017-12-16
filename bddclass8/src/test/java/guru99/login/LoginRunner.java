//package guru99;
package guru99.login;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/guru99/login.feature",
		glue={"guru99.login"}
	)
public class LoginRunner {

}

/* Output"
 * 
 * 1 Scenarios ([32m1 passed[0m)
5 Steps ([32m5 passed[0m)
0m8.415s

*/


