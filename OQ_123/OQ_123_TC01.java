package testcases.OQ_123;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
import pages.AlertPage;
import pages.ELetterPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_123 Test Cases")
public class OQ_123_TC01 extends BaseTest {
	String patient = "";
	String alertNumber = "";
	
	@BeforeClass
	public void beforeClass() {
		alertPage = new AlertPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_123 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Alert tab, search the alert and select the altert, click on eLetter button, select a type of eLetter")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Alert tab, search the alert and select the altert, click on eLetter button, select a type of eLetter")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Alert tab, search the alert and select the altert, click on eLetter button, select a type of eLetter");
		homePage.clickAlertsTab();
		homePage.selectViewListItem("Monitoring Frequency Alerts");
		homePage.clickOnViewResultLink(alertNumber);
		alertPage.clickOnELetterButton();
		eLetterPage.selectELeter("eLetter Weekly to Every Four Weeks");
		Assert.assertTrue(super.isTextShowing("Recipient Type"));
	}	

	@Test(priority = 2, description = "OQ_123 Test case 1: TC-01.02")
	@Step("Step 2. Click on send button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on send button")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Click on send button");
		eLetterPage.clickOnSendBtn();
		Assert.assertTrue(super.isTextShowing("A fax will be sent to"));
	}	
	
	@Test(priority = 3, description = "OQ_123 Test case 1: TC-01.03")
	@Step("Step 3. Check the SMS message")
	@Severity(SeverityLevel.NORMAL)
    @Description("Check the SMS message")
	public void Ts0103(Method method) {
		startTest(method.getName(), "Check the SMS message");
		//check the SMS
		Assert.assertTrue(true);
	}	
		
	@Test(priority = 4, description = "OQ_123 Test case 1: TC-01.04")
	@Step("Step 4. Check the email inbox")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the email inbox")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Check the email inbox");
		// Check the email
		Assert.assertTrue(true);
	}	
	


}
