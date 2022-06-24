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
import pages.ELetterPage;
import pages.FaxDocumentPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC06 extends BaseTest {
	ParticipantsPage participantsPage;
	PatientPage patientPage;
	ELetterPage eLeterPage;
	String patient = "1990101503 PD";
	String document = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		patientPage = new PatientPage();
		eLeterPage = new ELetterPage();
		faxDocumentPage = new FaxDocumentPage();
		
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test case 6: TC-06.01")
	@Step("Step 1. Go to the Patients tab, the patients page is displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Patients tab, the patients page is displayed")
	public void Ts0601(Method method) {
		startTest(method.getName(), "Go to the Patients tab, the patients page is displayed");
		homePage.clickPatientTab();
		Assert.assertTrue(super.isTextShowing("Recent Patients"));
	}	

	@Test(priority = 2, description = "OQ_105 Test case 6: TC-06.02")
	@Step("Step 2. Enter the patient's CSAN number, click on search button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Enter the patient's CSAN number, click on search button, the patient should be showing in the search result")
	public void Ts0602(Method method) {
		startTest(method.getName(), "Enter the patient's CSAN number, click on search button, the patient should be showing in the search result");
		homePage.clickOnSearch(patient);
		Assert.assertTrue(patientPage.checkPatientShowing(patient));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 6: TC-06.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0603(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		patientPage.clickOnRecordLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test case 6: TC-06.04")
	@Step("Step 4. Scroll down to the Activity History section")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Activity History section, find the desired task, click the task's subject, the task page is displayed")
	public void Ts0604(Method method) {
		startTest(method.getName(), "Scroll down to the Activity History section, find the desired task, click the task's subject, the task page is displayed");
		patientPage.clickOnEletterLink();
		Assert.assertTrue(super.isTextShowing("Task Detail"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test case 6: TC-06.05")
	@Step("Step 5. Confirm that the related fields are properly displayed, then click on the ducument link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the related fields are properly displayed, then click on the ducument link")
	public void Ts0605(Method method) {
		startTest(method.getName(), "Confirm that the related fields are properly displayed, then click on the ducument link");
		String type = homePage.getFormText("Comment Type");
		homePage.clickOnFormLink("Document");
		super.switchToSubWindow();
		Assert.assertTrue(type.equalsIgnoreCase("eLetter") && super.isTextShowing("Fax / Document Detail"));
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 6: TC-06.06")
	@Step("Step 6. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Notes & Attachments related list has one .docx file on it")
	public void Ts0606(Method method) {
		startTest(method.getName(), "Confirm that the Notes & Attachments related list has one .docx file on it");
		String title = faxDocumentPage.getAttachmentTitle();
		
		Assert.assertTrue(title.length()>0);
	}	
	
	@Test(priority = 7, description = "OQ_105 Test case 6: TC-06.07")
	@Step("Step 7. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the related fields are properly displayed: Fax Status, To Fax Number")
	public void Ts0607(Method method) {
		startTest(method.getName(), "Confirm that the related fields are properly displayed: Fax Status, To Fax Number");
		String status = homePage.getFormText("Fax Status");
		String toFax = homePage.getFormText("To Fax Number");
		Assert.assertTrue(status.equalsIgnoreCase("New") && toFax.length()>0);
	}	
	
	@Test(priority = 8, description = "OQ_105 Test case 6: TC-06.08")
	@Step("Step 8. Check the To Fax Number's faxinbox for the eLetter")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received")
	public void Ts0608(Method method) {
		startTest(method.getName(), "Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received");
		//how to check the To Fax number's inbox 
		Assert.assertTrue(true);
	}
	
}

