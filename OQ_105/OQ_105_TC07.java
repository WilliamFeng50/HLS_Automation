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
import pages.AlertPage;
import pages.ELetterPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC07 extends BaseTest {
	String alertNumber = "A-352111";
	@BeforeClass
	public void beforeClass() {
		alertPage = new AlertPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test case 7: TC-07.01")
	@Step("Step 1. Go to the Alerts tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Alerts tab, the alerts page is displayed")
	public void Ts0701(Method method) {
		startTest(method.getName(), "Go to the Alerts tab, the alerts page is displayed");
		homePage.clickAlertsTab();
		Assert.assertTrue(super.isTextShowing("Recent Alerts"));
	}	

	@Test(priority = 2, description = "OQ_105 Test case 7: TC-07.02")
	@Step("Step 2. Select Monitoring Frequency Alerts option from the view drop down list, then click go button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Select Monitoring Frequency Alerts option from the view drop down list, then click go button, a list of alerts is displayed")
	public void Ts0702(Method method) {
		startTest(method.getName(), "Select Monitoring Frequency Alerts option from the view drop down list, then click go button, a list of alerts is displayed");
		alertPage.selectViewDropDownItem("Monitoring Frequency Alerts");
		Assert.assertTrue(super.isTextShowing("New Alert"));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 7: TC-07.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0703(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		alertPage.clickViewAlertNumber(alertNumber);
		Assert.assertTrue(super.isTextShowing("Alert Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test case 7: TC-07.04")
	@Step("Step 4. Click on the Edit button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Edit button, the Alert Edit page is displayed")
	public void Ts0704(Method method) {
		startTest(method.getName(), "Click on the Edit button, the Alert Edit page is displayed");
		alertPage.clickOnEditButton();
		Assert.assertTrue(super.isTextShowing("Alert Edit"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test case 7: TC-07.05")
	@Step("Step 5. Change the Alert Status to Accept, then click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Change the Alert Status to Accept, then click on save button")
	public void Ts0705(Method method) {
		startTest(method.getName(), "Change the Alert Status to Accept, then click on save button");
		alertPage.selectStatus("Accept");
		alertPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Alert Detail"));
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 7: TC-07.06")
	@Step("Step 6. Click on the eLetter button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the eLetter button, the eLetter page is displayed")
	public void Ts0706(Method method) {
		startTest(method.getName(), "Click on the eLetter button, the eLetter page is displayed");
		alertPage.clickOnELetterButton();
		Assert.assertTrue(super.isTextShowing("Select eLetter"));
	}	
	
	@Test(priority = 7, description = "OQ_105 Test case 7: TC-07.07")
	@Step("Step 7. Select eLetter Every Two Weeks")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Select eLetter Every Two Weeks, the list of Target Recipients is displayed")
	public void Ts0707(Method method) {
		startTest(method.getName(), "Select eLetter Every Two Weeks, the list of Target Recipients is displayed");
		eLetterPage.selectELeter("eLetter Every Two Weeks");
		Assert.assertTrue(super.isTextShowing("Recipient Type"));
	}	
	
	@Test(priority = 8, description = "OQ_105 Test case 7: TC-07.08")
	@Step("Step 8. Click on the send fax button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the send fax button, 'A fax will be sent to' message is displayed")
	public void Ts0708(Method method) {
		startTest(method.getName(), "Click on the send fax button, 'A fax will be sent to' message is displayed");
		eLetterPage.clickOnSendBtn();
		Assert.assertTrue(super.isTextShowing("A fax will be sent to"));
	}
	
	//9 Check the Recipient's fax inbox for a Four Weeks Alert letter Confirm that a fax has been received for the letter
	
	//10 Check the Recipients inbox for an email for every four weeks alert
	
}

