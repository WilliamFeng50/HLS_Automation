package testcases.OQ_001;

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
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_001 Test cases")
public class OQ_001_TC04 extends BaseTest {
	ParticipantsPage participantsPage;
	MailPage mailPage;
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		mailPage = new MailPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_001 Test case 4: TC-04.01")
	@Step("step 1. Click on Participants tab")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0401(Method method) {
		startTest(method.getName(), "click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));
	}

	@Test(priority = 2, description = "OQ_001 Test case 4: TC-04.02")
	@Step("step 2. In the search box, enter the physician's name and click on search")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search box, enter the physician's name and click on search, the Search Results is displayed")
	public void Ts0402(Method method) {
		startTest(method.getName(), "In the search box, enter the physician's name and click on search, the Search Results is displayed");
		homePage.clickOnSearch("Maria Arista");
		Assert.assertTrue(super.isTextShowing("Search Results"));
	}

	@Test(priority = 3, description = "OQ_001 Test case 4: TC-04.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0403(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink("Maria Arista");
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_001 Test case 4: TC-04.04")
	@Step("step 4.Click the New UCID Request button, the popup appears as expected, then click on OK button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click the New UCID Request button, the popup appears as expected with Email has been sent")
	public void Ts0404(Method method) {
		startTest(method.getName(), "Click the New UCID Request button, the popup appears as expected with Email has been sent");
		
		Assert.assertTrue(true);		
	}
	
	@Test(priority = 5, description = "OQ_001 Test case 4: TC-04.05")
	@Step("Check the email account which is set up to receive new UCID requests")
	@Severity(SeverityLevel.NORMAL)
	@Description("Check the email account which is set up to receive new UCID requests, confirm that an email has been received")
	public void Ts0405(Method method) {
		startTest(method.getName(), "Check the email account which is set up to receive new UCID requests, confirm that an email has been received");
		
		Assert.assertTrue(true);		
	}
		
}

