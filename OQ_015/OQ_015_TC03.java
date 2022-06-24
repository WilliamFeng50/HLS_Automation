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
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_015 Test Cases")
public class OQ_015_TC03 extends BaseTest {
	PatientPage patientPage;
	String patient = "2012091706 MG";
	String llc = "KARIM E BENIN";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_015 Test case 3: TC-03.01")
	@Step("Step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0301(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_015 Test case 3: TC-03.02")
	@Step("Step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0302(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_015 Test case 3: TC-03.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0303(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_015 Test case 3: TC-03.04")
	@Step("Step 4. Scroll down to the Participants section, Click on New Patient Participant button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants section, Click on New Patient Participant button, Patient Participant Edit page is displayed")
	public void Ts0304(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, Click on New Patient Participant button, Patient Participant Edit page is displayed");
		homePage.moveToSectionForm("Participants and LCCs");
		patientPage.clickOnNewParticipant();
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}	
	
	@Test(priority = 5, description = "OQ_015 Test case 3: TC-03.05")
	@Step("Step 5. Confirm that the following information is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the following information is displayed")
	public void Ts0305(Method method) {
		startTest(method.getName(), "Confirm that the following information is displayed");
		Assert.assertTrue(super.isTextShowing("LCC") && super.isTextShowing("Active"));
	}	
	
	@Test(priority = 6, description = "OQ_015 Test case 3: TC-03.06")
	@Step("Step 6. Click on the Participant Lookup button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Click on the Participant Lookup button, the popup appreas as expected")
	public void Ts0306(Method method) {
		startTest(method.getName(), "Click on the Participant Lookup button, the popup appreas as expected");
		patientPage.clickOnParticipantLookup();
		Assert.assertTrue(super.isTextShowing("Lookup"));			
	}
	
	@Test(priority = 7, description = "OQ_015 Test case 3: TC-03.07")
	@Step("Step 7. In the search field, enter the LCC's name and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
	@Description("In the search field, enter the LCC's name and click the Go! button")
	public void Ts0307(Method method) {
		startTest(method.getName(), "In the search field, enter the LCC's name and click the Go! button");
		homePage.lookupSearch(llc);	
		Assert.assertTrue(super.isTextShowing("Participants ["));
	}
	
	@Test(priority = 8, description = "OQ_015 Test case 3: TC-03.08")
	@Step("Step 8. Click the LLC's name to select")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the LLC's name to select, the Patient Participant Edit page is displayed")
	public void Ts0308(Method method) {
		startTest(method.getName(), "Click the LLC's name to select, the Patient Participant Edit page is displayed");
		homePage.selectSearchResult(llc);
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}
	
	@Test(priority = 9, description = "OQ_015 Test case 3: TC-03.09")
	@Step("step 9. Click on the Save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Save button, the Patient Participant detail page is displayed")
	public void Ts0309(Method method) {
		startTest(method.getName(), "Click on the Save button, the Patient Participant Detail page is displayed");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Error: Invalid Data.") && super.isTextShowing("Review all error messages below to correct your data.") && super.isTextShowing("Duplicate value on record"));
	}
	
	@Test(priority = 13, description = "OQ_015 Test case 3: TC-03.13")
	@Step("Step 13. Click on the Participant Lookup button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Click on the Participant Lookup button, the popup appreas as expected")
	public void Ts0313(Method method) {
		startTest(method.getName(), "Click on the Participant Lookup button, the popup appreas as expected");
		patientPage.clickOnParticipantLookup();
		Assert.assertTrue(super.isTextShowing("Lookup"));			
	}
	
	@Test(priority = 14, description = "OQ_015 Test case 3: TC-03.14")
	@Step("Step 14. In the search field, enter the LCC's name and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
	@Description("In the search field, enter the LCC's name and click the Go! button")
	public void Ts0314(Method method) {
		startTest(method.getName(), "In the search field, enter the LCC's name and click the Go! button");
		homePage.lookupSearch("ABIE OSAWE");	
		Assert.assertTrue(super.isTextShowing("Participants ["));
	}
	
	@Test(priority = 15, description = "OQ_015 Test case 3: TC-03.15")
	@Step("Step 15. Click the LLC's name to select")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the LLC's name to select, the Patient Participant Edit page is displayed")
	public void Ts0315(Method method) {
		startTest(method.getName(), "Click the LLC's name to select, the Patient Participant Edit page is displayed");
		homePage.selectSearchResult(llc);
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}
	
	@Test(priority = 16, description = "OQ_015 Test case 3: TC-03.16")
	@Step("step 16. Click on the Save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Save button, the Patient Participant detail page is displayed")
	public void Ts0316(Method method) {
		startTest(method.getName(), "Click on the Save button, the Patient Participant Detail page is displayed");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Patient Participant Detail"));
	}
	
	@Test(priority = 17, description = "OQ_015 Test case 3: TC-03.17")
	@Step("step 17. Click on the Patient link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Patient link, the Patient detail page is displayed")
	public void Ts0317(Method method) {
		startTest(method.getName(), "Click on the Patient link, the Patient Detail page is displayed");
		patientPage.clickOnPatientLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
	
	@Test(priority = 18, description = "OQ_015 Test case 3: TC-03.18")
	@Step("Step 18. Scroll down to the Participants section, confirm that the LCC record has been added")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants section, confirm that the LCC record has been added")
	public void Ts0318(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, confirm that the LCC record has been added");
		List<String> info = new ArrayList<String>();
		String today = super.getToday("M/d/yyyy");
		homePage.moveToSectionForm("Participants and LCCs");
		info = patientPage.getParticipantsAndLCCsInformation("Active 	LCC", "ABIE OSAWE");
		String startDate = info.get(2).toString();
		String endDate = info.get(3).toString();
		Assert.assertTrue(today.equals(startDate) && endDate.length()>0);
	}	
}
