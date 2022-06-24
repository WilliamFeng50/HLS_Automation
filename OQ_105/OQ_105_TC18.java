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
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_105 Test cases")
public class OQ_105_TC18 extends BaseTest {
	String patient = "2018041401 CL";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_105 Test case 18: TC-18.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts1801(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_105 Test case 18: TC-18.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts1802(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 18: TC-18.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts1803(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		homePage.moveToSectionForm("Treatments");
		patientPage.getTreatmentsInformation("Withdrawn");
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_105 Test case 18: TC-18.04")
	@Step("step 4. Check the patient Owner's email account for two messages from Salesforce")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Check the patient Owner's email account for two messages from Salesforce")
	public void Ts1804(Method method) {
		startTest(method.getName(), "Check the patient Owner's email account for two messages from Salesforce");
		//How to check the email
		Assert.assertTrue(true);
	}
	
}
