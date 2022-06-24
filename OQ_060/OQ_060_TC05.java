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
import pages.LocationPage;
import pages.LookupPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_060 Test cases")
public class OQ_060_TC05 extends BaseTest {
	String participant = "MARIA ARISTA";
	String locationName = "";
	String patient = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		patientPage = new PatientPage(); 
		locationPage = new LocationPage();
		lookupPage = new LookupPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 5: TC-05.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0501(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 5: TC-05.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0502(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0503(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}
	
	@Test(priority = 4, description = "OQ_060 Test case 5: TC-05.04")
	@Step("Step 4. Scroll down to the Additional Location Access section, click the New Additional Location Access button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Additional Location Access section, click the New Additional Location Access button")
	public void Ts0504(Method method) {
		startTest(method.getName(), "Scroll down to the Additional Location Access section, click the New Additional Location Access button");
		homePage.moveToSectionForm("Additional Location Access");
		homePage.clickOnTableLink(locationName);
		Assert.assertTrue(super.isTextShowing("Location Detail"));			
	}
		
	@Test(priority = 5, description = "OQ_060 Test case 5: TC-05.05")
	@Step("Step 5. Scroll down to the Patients section, get the patient name")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Patients section, get the patient name")
	public void Ts0505(Method method) {
		startTest(method.getName(), "Scroll down to the Patients section, get the patient name");
		homePage.moveToSectionForm("Patients");
		patient = participantsPage.getFirstPatient();
		super.browserBack();
		Assert.assertTrue(super.isTextShowing("Participant Detail"));		
	}
	
	@Test(priority = 6, description = "OQ_060 Test case 5: TC-05.06")
	@Step("Step 6. Scroll down to the Additional Location Access section, click on the Del button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Scroll down to the Additional Location Access section, click on the Del button, the record disappears")
	public void Ts0506(Method method) {
		startTest(method.getName(), "Scroll down to the Additional Location Access section, click on the Del button, the record disappears");
		boolean result = false;
		homePage.moveToSectionForm("Additional Location Access");
		participantsPage.clickOnDelButton();
		homePage.acceptAlert();
		homePage.moveToSectionForm("Additional Location Access");
		try {
			participantsPage.clickOnDelButton();
		}catch (Exception NoSuchElementException) {
			result = true;
		}
		Assert.assertTrue(result);			
	}
	
	
}

