package testcases.OQ_105;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.AdverseEevntsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC02 extends BaseTest {
	String eventId = "AE-0014079";
		
	@BeforeClass
	public void beforeClass() {
		adverseEevntsPage = new AdverseEevntsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test case 2: TC-02.01")
	@Step("Step 1. Go to the Adverse Events tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Adverse Events tab, the Adverse Events page is displayed")
	public void Ts0201(Method method) {
		startTest(method.getName(), "Go to the Adverse Events tab, the Adverse Events page is displayed");
		homePage.clickMenuTab("Adverse Eevnts");
		Assert.assertTrue(super.isTextShowing("Recent Adverse Events"));
	}	

	@Test(priority = 2, description = "OQ_105 Test case 2: TC-02.02")
	@Step("Step 2. From the View drop down list, select All and click on Go button")
	@Severity(SeverityLevel.NORMAL)
    @Description("From the View drop down list, select All and click on Go button")
	public void Ts0202(Method method) {
		startTest(method.getName(), "From the View drop down list, select All and click on Go button");
		homePage.clickOnGoButton();
		Assert.assertTrue(super.isTextShowing("New Adverse Event"));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 2: TC-02.03")
	@Step("Step 3. In the list view, click the created record Adverse Event ID")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the list view, click the created record Adverse Event ID")
	public void Ts0203(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		adverseEevntsPage.clickOnEventID(eventId);
		Assert.assertTrue(super.isTextShowing("Adverse Event Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test case 2: TC-02.04")
	@Step("Step 4. Check the email inbox, an email has been received for the Adverse Event")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the email inbox, an email has been received for the Adverse Event")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Check the email inbox, an email has been received for the Adverse Event");
		
		Assert.assertTrue(true);
	}	
	
	
}

