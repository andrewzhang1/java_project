package bmi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// purpose: To tell where do I find the feature file and step defination file?
@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/bmi/bmi.feature",
	glue={"bmi"} // Only need find step defination file for this purpose! 
)
public class BmiRunner {

}


/* 
 * 
 *  output:


2 Scenarios ([31m2 failed[0m)
10 Steps ([36m10 skipped[0m)
0m0.048s


*/
