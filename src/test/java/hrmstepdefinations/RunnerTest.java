package hrmstepdefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources//hrm",
                 glue= {"hrmstepdefinations"},
                 monochrome=true,
                 dryRun=false,
                tags="@All",
               // plugin= {
                		//"pretty",
                		//"json:target/Myreports/report.json",
                		//"junit:target/Myreports/report.xml",
                		//"html:target/Myreports/report.html",
                		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
             
                		plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                publish=true
                		
                		
                
                
                 )

public class RunnerTest {

}
