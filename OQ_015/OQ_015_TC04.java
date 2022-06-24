package testcases.OQ_015;

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
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_015 Test Cases")
public class OQ_015_TC04 extends BaseTest {
	PatientPage patientPage;
	ParticipantsPage participantsPage;
	String patient = "2012091706 MG";
	String llc = "ABIE OSAWE";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_015 Test case 4: TC-04.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0401(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_015 Test case 4: TC-04.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0402(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_015 Test case 4: TC-04.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0403(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_015 Test case 4: TC-04.04")
	@Step("step 4. Scroll down to the Participants and LCCs section, click on the New Patient Participant button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Participants and LCCs section, click on the New Patient Participant button, the Patient Participant Edit page is displayed"
			+ "")
	public void Ts0404(Method method) {
		startTest(method.getName(), "Scroll down to the Participants and LCCs section, click on the New Patient Participant button, the Patient Participant Edit page is displayed");
		homePage.moveToSectionForm("Participants and LCCs");
		patientPage.clickOnParticipantsAndLCCsEditButton("Active 	LCC", llc);
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_015 Test case 4: TC-04.05")
	@Step("step 5. Confirm that the required fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the required fields are properly displayed")
	public void Ts0405(Method method) {
		startTest(method.getName(), "Confirm that the required fields are properly displayed");
		String[] fields = new String[] {"Patient","Participant", "Status for Patient"};
		boolean result = false;
		startTest(method.getName(), "Confirm the required fields are displayed");
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);	
	}

	@Test(priority = 6, description = "OQ_015 Test case 4: TC-04.06")
	@Step("Step 6. Change the Status for Patient's values to Inactive, then click on Save button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Change the Status for Patient's values to Inactive, then click on Save button")
	public void Ts0406(Method method) {
		startTest(method.getName(), "Change the Status for Patient's values to Inactive, then click on Save button");
		homePage.changeDropDownListItem("Status for Patient", "Inactive");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Patient Detail"));	
	}
	
	@Test(priority = 7, description = "OQ_015 Test case 4: TC-04.07")
	@Step("Step 7. Click on the Participant Lookup button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Click on the Participant Lookup button, the popup appreas as expected")
	public void Ts0407(Method method) {
		startTest(method.getName(), "Click on the Participant Lookup button, the popup appreas as expected");
		List<String> info = new ArrayList<String>();
		String today = super.getToday("M/d/yyyy");
		homePage.moveToSectionForm("Participants and LCCs");
		info = patientPage.getParticipantsAndLCCsInformation("Inactive 	LCC", llc);
		String endDate = info.get(3).toString();
		Assert.assertTrue(today.equals(endDate));
	}
	
	
}

