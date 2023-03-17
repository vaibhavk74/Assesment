package BizCover.UI_Automation;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.vimalselvam.cucumber.listener.ExtentCucumberFormatter;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "UI_Automation/src/test/java/FeatureFiles",
		   glue = {"UI_Automation/src/test/java/BizCover/UI_Automation"},
		   plugin = {"pretty", "html:target/cucumber-reports",
		            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunner {

}