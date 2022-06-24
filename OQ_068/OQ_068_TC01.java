package testcases.OQ_068;

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
import pages.ParticipantsPage;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_068 Test cases")
public class OQ_068_TC01 extends BaseTest {
	String patient = "2018042004 HY";
	String testResultID = "";
	String alertNumber = "";
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		testResultPage = new TestResultPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_068 Test case 1: TC-01.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_068 Test case 1: TC-01.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_068 Test case 1: TC-01.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_068 Test case 1: TC-01.04")
	@Step("step 4. Scroll down to the Test Results section, indicates a Yellow alert and click on the Test Result ID")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Test Results section, indicates a Yellow alert and click on the Test Result ID, the test results page is displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Scroll down to the Test Results section, indicates a Yellow alert and click on the Test Result ID, the test results page is displayed");
		homePage.moveToSectionForm("Test Results (Units of measure 10^9/L)");
		testResultID = patientPage.getTestResultIDByAlert(YellowAlert);
		homePage.clickOnTableLink(testResultID);
		Assert.assertTrue(super.isTextShowing("Test Result Detail"));
	}
	
	@Test(priority = 5, description = "OQ_068 Test case 1: TC-01.05")
	@Step("step 5. Next to the Patient field, click the patient's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Next to the Patient field, click the patient's name, the patient page is displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Next to the Patient field, click the patient's name, the patient page is displayed");
		homePage.moveToSectionForm("Alerts");
		alertNumber = testResultPage.getAlertNumber();
		testResultPage.clickOnPatientLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}

	@Test(priority = 6, description = "OQ_068 Test case 1: TC-01.06")
	@Step("step 6. Scroll down to the Alerts section")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Alerts section, Confirm that a Yellow Alert was generated for the test result")
	public void Ts0106(Method method) {
		startTest(method.getName(), "Scroll down to the Alerts section, Confirm that a Yellow Alert was generated for the test result");
		homePage.moveToSectionForm("Alerts");
		String type = patientPage.getAlertType(alertNumber);
		Assert.assertTrue(type.equalsIgnoreCase("Yellow"));
	}
}

