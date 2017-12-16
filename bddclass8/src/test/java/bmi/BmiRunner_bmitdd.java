package bmi;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// purpose: To tell where do I find the feature file and step defination file?
@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/bmi/bmitdd.feature",
	glue={"bmi"} // Only need find step defination file for this purpose! 
)
public class BmiRunner_bmitdd {

}


/* 
 * 
 *  output:

4 Scenarios ([32m4 passed[0m)
20 Steps ([32m20 passed[0m)
0m21.941s

*/
