package testcases.OQ_105;

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
import pages.ELetterPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	PatientPage patientPage;
	ELetterPage eLeterPage;
	String patient = "1990101503 PD";
	String llcName = "LINDA BJORNSON";
	String fax = "";
	String language = "";
	
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		patientPage = new PatientPage();
		eLeterPage = new ELetterPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	

	@Test(priority = 2, description = "OQ_105 Test case 1: TC-01.02")
	@Step("Step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 1: TC-01.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test case 1: TC-01.04")
	@Step("Step 4. Scroll down to the Participants section, hover over the physician's name")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants section, hover over the physician's name, the popup of physician's details are displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, hover over the physician's name, the popup of physician's details are displayed");
		patientPage.clickSubsectionDisplayBtn("Participants");
		homePage.hoverOverLink("Physician");
		Assert.assertTrue(super.isTextShowing("Physician License"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test case 1: TC-01.05")
	@Step("Step 5. Scroll down to the Participants section, hover over the physician's name")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants section, hover over the physician's name, the popup of pharmacy's details are displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Scroll down to the Participants section, hover over the physician's name, the popup of pharmacy's details are displayed");
		patientPage.clickSubsectionDisplayBtn("Participants");
		homePage.hoverOverLink("Pharmacy");
		Assert.assertTrue(super.isTextShowing("Pharmacy License"));
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 1: TC-01.06")
	@Step("Step 6. Scroll down to the Participants and LCCs related list， click on the active LCC's name")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Participants and LCCs related list， click on the active LCC's name")
	public void Ts0106(Method method) {
		startTest(method.getName(), "Scroll down to the Participants and LCCs related list， click on the active LCC's name");
		homePage.moveToSectionForm("Participants and LCCs");
		homePage.clickOnTableLink(llcName);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}	
	
	@Test(priority = 7, description = "OQ_105 Test case 1: TC-01.07")
	@Step("Step 7. Note the LCC's communication language and fax number, click on the browser's back button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Note the LCC's communication language and fax number, click on the browser's back button, the patient details page is diaplayed")
	public void Ts0107(Method method) {
		startTest(method.getName(), "Note the LCC's communication language and fax number, click on the browser's back button, the patient details page is diaplayed");
		fax = homePage.getFormText("Fax");
		language = homePage.getFormText("Communication Language");
	    driver.navigate().back();
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 8, description = "OQ_105 Test case 1: TC-01.08")
	@Step("Step 8. Click on eLeter button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on eLeter button, the eLeter management page is diaplayed")
	public void Ts0108(Method method) {
		startTest(method.getName(), "Click on eLeter button, the eLeter management page is diaplayed");
		patientPage.clickOnEletterButton();
		Assert.assertTrue(super.isTextShowing("Select eLetter"));
	}
	
	@Test(priority = 9, description = "OQ_105 Test case 1: TC-01.09")
	@Step("Step 9. Select eLeter Discontinuation in the drop down list")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Select eLeter Discontinuation in the drop down list, confirm the values of the Recipient, Communication language, Fax")
	public void Ts0109(Method method) {
		startTest(method.getName(), "Select eLeter Discontinuation in the drop down list, confirm the values of the Recipient, Communication language, Fax");
		List <String> info = new ArrayList<String>();
		info = eLeterPage.getRecipientInformation("LCC");
		
		Assert.assertTrue(info.get(0).equalsIgnoreCase(llcName) && info.get(1).equalsIgnoreCase(language) && info.get(2).equalsIgnoreCase(fax));
	}
}

