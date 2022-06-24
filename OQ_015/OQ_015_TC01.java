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
@Feature("OQ_015 Test cases")
public class OQ_015_TC01 extends BaseTest {
	PatientPage patientPage;
	ParticipantsPage participantsPage;
	String patient = "2012091706 MG";
	String llc = "KARIM BENIN";

	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}
		
	@Test(priority = 1, description = "OQ_015 Test case 1: TC-01.01")
	@Step("step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	
	
	@Test(priority = 2, description = "OQ_015 Test case 1: TC-01.02")
	@Step("step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_015 Test case 1: TC-01.03")
	@Step("step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 4, description = "OQ_015 Test case 1: TC-01.04")
	@Step("step 4. Scroll down to the Participants and LCCs section, click on the New Patient Participant button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Scroll down to the Participants and LCCs section, click on the New Patient Participant button, the Patient Participant Edit page is displayed"
			+ "")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Scroll down to the Participants and LCCs section, click on the New Patient Participant button, the Patient Participant Edit page is displayed");
		homePage.moveToSectionForm("Participants and LCCs");
		patientPage.clickOnNewParticipant();
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}
	
	@Test(priority = 5, description = "OQ_015 Test case 1: TC-01.05")
	@Step("step 5. Confirm that the required fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the required fields are properly displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Confirm that the required fields are properly displayed");
		String[] fields = new String[] {"Patient","Participant", "Status for Patient"};
		boolean result = false;
		for(int i=0;i<fields.length;i++) {
			result = super.madantoryFieldCheck(fields[i]);
			if(result == false) break;
			
		}
		Assert.assertTrue(result);	
	}

	@Test(priority = 6, description = "OQ_015 Test case 1: TC-01.06")
	@Step("Step 6. The Status for Patient's values in the drop down list are properly displayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("The Status for Patient's values in the drop down list are properly displayed")
	public void Ts0106(Method method) {
		String[] fields = new String[] {"Active", "Inactive"};
		boolean result = false;
		String value = null;
		startTest(method.getName(), "The Status for Patient's values in the drop down list are properly displayed");
		super.clickOnDropDownListBtn("Status for Patient");
		for(int i=0;i<fields.length;i++) {
			value = homePage.getDropDownListItem("Status for Patient", fields[i]);
			if(value.equals(fields[i])) { 
				result = true;
			}else {
				result = false;
				break;
			}
		}
		Assert.assertTrue(result);		
	}
	
	@Test(priority = 7, description = "OQ_015 Test case 1: TC-01.07")
	@Step("Step 7. Click on the Participant Lookup button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Click on the Participant Lookup button, the popup appreas as expected")
	public void Ts0107(Method method) {
		startTest(method.getName(), "Click on the Participant Lookup button, the popup appreas as expected");
		patientPage.clickOnParticipantLookup();
		Assert.assertTrue(super.isTextShowing("Lookup"));			
	}
	
	@Test(priority = 8, description = "OQ_015 Test case 1: TC-01.08")
	@Step("Step 8. In the search field, enter the LCC's name and click the Go! button")
	@Severity(SeverityLevel.NORMAL)
	@Description("In the search field, enter the LCC's name and click the Go! button")
	public void Ts0108(Method method) {
		startTest(method.getName(), "In the search field, enter the LCC's name and click the Go! button");
		homePage.lookupSearch(llc);	
		Assert.assertTrue(super.isTextShowing("Participants ["));
	}
	
	@Test(priority = 9, description = "OQ_015 Test case 1: TC-01.09")
	@Step("Step 9. Click the LLC's name to select")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click the LLC's name to select, the Patient Participant Edit page is displayed")
	public void Ts0109(Method method) {
		startTest(method.getName(), "Click the LLC's name to select, the Patient Participant Edit page is displayed");
		homePage.selectSearchResult(llc);
		Assert.assertTrue(super.isTextShowing("Patient Participant Edit"));
	}
	
	@Test(priority = 10, description = "OQ_015 Test case 1: TC-01.10")
	@Step("step 10. Click on the Save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Save button, the Patient Participant detail page is displayed")
	public void Ts0110(Method method) {
		startTest(method.getName(), "Click on the Save button, the Patient Participant Detail page is displayed");
		homePage.clickOnSaveBtn();
		Assert.assertTrue(super.isTextShowing("Patient Participant Detail"));
	}
	
	@Test(priority = 11, description = "OQ_015 Test case 1: TC-01.11")
	@Step("Step 11. Click on the Patient field")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Patient field, the Patient page is displayed")
	public void Ts0111(Method method) {
		startTest(method.getName(), "Click on the Patient field, the Patient page is displayed");
		patientPage.clickOnPatientLink("Patient");
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}
	
	@Test(priority = 12, description = "OQ_015 Test case 1: TC-01.12")
	@Step("Step 12.Scroll down to the Participants and LCCs section, confirm the information has been updated")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants and LCCs section, confirm the information has been updated")
	public void Ts0112(Method method) {
		startTest(method.getName(), "Scroll down to the Participants and LCCs section, confirm the information has been updated");
		List<String> info = new ArrayList<String>();
		String today = super.getToday("M/d/yyyy");
		homePage.moveToSectionForm("Participants and LCCs");
		info = patientPage.getParticipantsAndLCCsInformation("Active 	LCC", llc);
		String startDate = info.get(2).toString();
		String endDate = info.get(3).toString();
		Assert.assertTrue(today.equals(startDate) && endDate.length()>0);
	}
}

