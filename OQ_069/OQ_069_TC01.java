package testcases.OQ_069;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.AlertPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_069 Test cases")
public class OQ_069_TC01 extends BaseTest {
	String alertNumber = "A-002517";
	
	@BeforeClass
	public void beforeClass() {
		alertPage = new AlertPage();
		patientPage = new PatientPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_069 Test case 1: TC-01.01")
	@Step("step 1.Go to the Alerts tab, the alerts page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Alerts tab, the alerts page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Alerts tab, the alerts page is displayed");
		homePage.clickAlertsTab();
		Assert.assertTrue(super.isTextShowing("Recent Alerts"));
	}	
	
	@Test(priority = 2, description = "OQ_069 Test case 1: TC-01.02")
	@Step("step 2. From the View drop down menu, select the All Alerts option and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
    @Description("From the View drop down menu, select the All Alerts option and click the Go! button")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From the View drop down menu, select the All Alerts option and click the Go! button");
		homePage.selectViewListItem("All Alerts");
		Assert.assertTrue(super.isTextShowing("New Alert"));
	}	
	
	@Test(priority = 3, description = "OQ_069 Test case 1: TC-01.03")
	@Step("step 3. In the list view, click the alert number")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the list view, click the alert number, the Alert Page is displayed")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the list view, click the alert number, the Alert Page is displayed");
		homePage.clickOnViewResultLink(alertNumber);
		Assert.assertTrue(super.isTextShowing("Alert Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_069 Test case 1: TC-01.04")
	@Step("step 4. Confirm the information is properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm the information is properly displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Confirm the information is properly displayed");
		Map<String, String> details = new HashMap<String, String>();
		String[] fields = {"Alert Number", "Alert Date", "Patient", "Type", "CSAN Number", "Initials", "Alert Status", "Reason for Override", "Territory"};
		for(String key : fields) {
			String value = homePage.getFormText(key);
			details.put(key, value);
			Reporter.log("The field " + key + "'s value is " + value , true);
		}
		Assert.assertTrue(!details.isEmpty());
	}
	
}

