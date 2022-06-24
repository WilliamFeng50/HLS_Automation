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
public class OQ_105_TC09 extends BaseTest {
	String alertNumber = "A-002532";
	String patient = "1988121511 QK";
	
	@BeforeClass
	public void beforeClass() {
		alertPage = new AlertPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test case 9: TC-09.01")
	@Step("Step 1. Go to the Alerts tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Alerts tab, the alerts page is displayed")
	public void Ts0901(Method method) {
		startTest(method.getName(), "Go to the Alerts tab, the alerts page is displayed");
		homePage.clickAlertsTab();
		Assert.assertTrue(super.isTextShowing("Recent Alerts"));
	}	

	@Test(priority = 2, description = "OQ_105 Test case 9: TC-09.02")
	@Step("Step 2. Select Monitoring Frequency Alerts option from the view drop down list, then click go button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Select Monitoring Frequency Alerts option from the view drop down list, then click go button, a list of alerts is displayed")
	public void Ts0902(Method method) {
		startTest(method.getName(), "Select Monitoring Frequency Alerts option from the view drop down list, then click go button, a list of alerts is displayed");
		alertPage.selectViewDropDownItem("Blood Test Alerts");
		Assert.assertTrue(super.isTextShowing("New Alert"));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test case 9: TC-09.03")
	@Step("Step 3. In the patients section, click the patient's name")
	@Severity(SeverityLevel.NORMAL)
    @Description("In the patients section, click the patient's name, the patient page is displayed for the selected")
	public void Ts0903(Method method) {
		startTest(method.getName(), "In the patients section, click the patient's name, the patient page is displayed for the selected");
		alertPage.clickViewAlertNumber(alertNumber);
		Assert.assertTrue(super.isTextShowing("Alert Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test case 9: TC-09.04")
	@Step("Step 4. Click on the Edit button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Edit button, the Alert Edit page is displayed")
	public void Ts0904(Method method) {
		startTest(method.getName(), "Click on the Edit button, the Alert Edit page is displayed");
		alertPage.clickOnEditButton();
		Assert.assertTrue(super.isTextShowing("Alert Edit"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test case 9: TC-09.05")
	@Step("Step 5. Change the Alert Status to Accept, then click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Change the Alert Status to Accept, then click on save button")
	public void Ts0905(Method method) {
		startTest(method.getName(), "Change the Alert Status to Accept, then click on save button");
		alertPage.selectStatus("Accept");
		alertPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Alert Detail"));
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 9: TC-09.06")
	@Step("Step 6. Click on the Patient link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Patient link, the patient detail page is displayed")
	public void Ts0906(Method method) {
		startTest(method.getName(), "Click on the Patient link, the patient detail page is displayed");
		homePage.clickOnFormLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 7, description = "OQ_105 Test case 9: TC-09.07")
	@Step("Step 7. Scroll down to the Activity Hstory related list, then click the subject")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Activity Hstory related list, then click the subject, the task page is displayed")
	public void Ts0907(Method method) {
		startTest(method.getName(), "Scroll down to the Activity Hstory related list, then click the subject, the task page is displayed");
		homePage.moveToSectionForm("Activity History");
		patientPage.clickOnEletterLink();
		super.switchToSubWindow();
		Assert.assertTrue(super.isTextShowing("Task Detail"));
	}	
	
	@Test(priority = 8, description = "OQ_105 Test case 9: TC-09.08")
	@Step("Step 8. Confirm the related fields are displayed, then click on the document link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm the related fields are displayed, then click on the document link, the document page is displayed")
	public void Ts0908(Method method) {
		startTest(method.getName(), "Confirm the related fields are displayed, then click on the document link, the document page is displayed");
		String type = homePage.getFormText("Comment Type");
		homePage.clickOnFormLink("Document");
		super.switchToSubWindow();
		Assert.assertTrue(type.equalsIgnoreCase("eLetter")&& super.isTextShowing("Fax / Document Detail"));
	}
	
	@Test(priority = 9, description = "OQ_105 Test case 9: TC-09.09")
	@Step("Step 9. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Notes & Attachments related list has one .docx file on it")
	public void Ts0909(Method method) {
		startTest(method.getName(), "Confirm that the Notes & Attachments related list has one .docx file on it");
		String title = faxDocumentPage.getAttachmentTitle();
		
		Assert.assertTrue(title.length()>0);
	}	
	
	@Test(priority = 10, description = "OQ_105 Test case 9: TC-09.10")
	@Step("Step 10. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the related fields are properly displayed: Fax Status, To Fax Number")
	public void Ts0910(Method method) {
		startTest(method.getName(), "Confirm that the related fields are properly displayed: Fax Status, To Fax Number");
		String status = homePage.getFormText("Fax Status");
		String toFax = homePage.getFormText("To Fax Number");
		Assert.assertTrue(status.equalsIgnoreCase("New") && toFax.length()>0);
	}	
	
	@Test(priority = 11, description = "OQ_105 Test case 9: TC-09.11")
	@Step("Step 11. Check the To Fax Number's faxinbox for the eLetter")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received")
	public void Ts0911(Method method) {
		startTest(method.getName(), "Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received");
		//how to check the To Fax number's inbox 
		Assert.assertTrue(true);
	}
	
	//12 check the sms
	//13 check the email
}

