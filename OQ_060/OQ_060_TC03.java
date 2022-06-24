package testcases.OQ_060;

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
import pages.EditParticipantsPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_060 Test cases")
public class OQ_060_TC03 extends BaseTest {
	String participant = "MARIA ARISTA";
	String patient = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		patientPage = new PatientPage(); 		
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 3: TC-03.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0301(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 3: TC-03.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0302(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0303(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_060 Test case 3: TC-03.04")
	@Step("Step 4. Select Additional Permission: --None-- , then click on save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Select Additional Permission: --None-- , then click on save button")
	public void Ts0304(Method method) {
		startTest(method.getName(), "Select Additional Permission: --None-- , then click on save button");
		participantsPage.clickOnEditBtn();
		homePage.changeDropDownListItem("Additional Permission", "--None--");
		editParticipantsPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));		
	}
		
	@Test(priority = 5, description = "OQ_060 Test case 3: TC-03.05")
	@Step("Step 5. Log into the portal as the external user for the participant, go to the Patients tab")
	@Severity(SeverityLevel.NORMAL)
	@Description("Log into the portal as the external user for the participant, go to the Patients tab")
	public void Ts0305(Method method) {
		startTest(method.getName(), "Log into the portal as the external user for the participant, go to the Patients tab");
		//how to go to login page
		Assert.assertTrue(true);		
	}
	
	@Test(priority = 6, description = "OQ_060 Test case 3: TC-03.06")
	@Step("Step 7. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0306(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 7, description = "OQ_060 Test case 3: TC-03.07")
	@Step("Step 7. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0307(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
	
	@Test(priority = 8, description = "OQ_060 Test case 3: TC-03.08")
	@Step("Step 8. Confirm that the values are visible in the First Name and the Last Name fields")
	@Severity(SeverityLevel.NORMAL)
    @Description("Confirm that the values are visible in the First Name and the Last Name fields")
	public void Ts0308(Method method) {
		startTest(method.getName(), "Confirm that the values are visible in the First Name and the Last Name fields");
		//get the first name and the last name values, should be null
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
}

