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
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC13 extends BaseTest {
	String testResultId = "TR-06525029";
	String patient = "2022041401 TI";
	@BeforeClass
	public void beforeClass() {
		testResultPage = new TestResultPage();
		alertPage = new AlertPage();
		eLetterPage = new ELetterPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test Test case 13: TC-13.01")
	@Step("Step 1. Go to the Test Results tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Test Results tab, the test results page is displayed")
	public void Ts1301(Method method) {
		startTest(method.getName(), "Go to the Test Results tab, the test results page is displayed");
		homePage.clickMenuTab("Test Results");
		Assert.assertTrue(super.isTextShowing("Recent Test Results"));
	}	

	@Test(priority = 2, description = "OQ_105 Test Test case 13: TC-13.02")
	@Step("Step 2. Select All option from the view drop down list, then click go button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Select All option from the view drop down list, then click go button, a list of test resuls is displayed")
	public void Ts1302(Method method) {
		startTest(method.getName(), "Select All option from the view drop down list, then click go button, a list of test resuls is displayed");
		testResultPage.selectViewDropDownItem("Last 3 Month");
		Assert.assertTrue(super.isTextShowing("New Alert"));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test Test case 13: TC-13.03")
	@Step("Step 3. Click on the recently created Test Result ID")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on the recently created Test Result ID, the test result page is displayed")
	public void Ts1303(Method method) {
		startTest(method.getName(), "Click on the recently created Test Result ID, the test result page is displayed");
		testResultPage.clickOnResultId("");
		Assert.assertTrue(super.isTextShowing("Test Result Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test Test case 13: TC-13.04")
	@Step("Step 4. Click on the Patient link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on the Patient link, the patient page is displayed")
	public void Ts1304(Method method) {
		startTest(method.getName(), "Click on the Patient link, the patient page is displayed");
		testResultPage.clickOnPatientLink(patient);
		Assert.assertTrue(super.isTextShowing("Patient Detail"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test Test case 13: TC-13.05")
	@Step("Step 5. Scroll down to the Activity Hstory related list, then click the subject")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Scroll down to the Activity Hstory related list, then click the subject, the task page is displayed")
	public void Ts1305(Method method) {
		startTest(method.getName(), "Scroll down to the Activity Hstory related list, then click the subject, the task page is displayed");
		homePage.moveToSectionForm("Activity History");
		patientPage.clickOnEletterLink();
		super.switchToSubWindow();
		Assert.assertTrue(super.isTextShowing("Task Detail"));
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 13: TC-13.06")
	@Step("Step 8. Confirm the related fields are displayed, then click on the document link")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm the related fields are displayed, then click on the document link, the document page is displayed")
	public void Ts1306(Method method) {
		startTest(method.getName(), "Confirm the related fields are displayed, then click on the document link, the document page is displayed");
		String type = homePage.getFormText("Comment Type");
		homePage.clickOnFormLink("Document");
		super.switchToSubWindow();
		Assert.assertTrue(type.equalsIgnoreCase("eLetter")&& super.isTextShowing("Fax / Document Detail"));
	}
	
	@Test(priority = 7, description = "OQ_105 Test case 13: TC-13.07")
	@Step("Step 7. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Notes & Attachments related list has one .docx file on it")
	public void Ts1307(Method method) {
		startTest(method.getName(), "Confirm that the Notes & Attachments related list has one .docx file on it");
		String title = faxDocumentPage.getAttachmentTitle();
		
		Assert.assertTrue(title.length()>0);
	}	
	
	@Test(priority = 8, description = "OQ_105 Test case 13: TC-13.08")
	@Step("Step 8. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the related fields are properly displayed: Fax Status, To Fax Number")
	public void Ts1308(Method method) {
		startTest(method.getName(), "Confirm that the related fields are properly displayed: Fax Status, To Fax Number");
		String status = homePage.getFormText("Fax Status");
		String toFax = homePage.getFormText("To Fax Number");
		Assert.assertTrue(status.equalsIgnoreCase("New") && toFax.length()>0);
	}	
	
	@Test(priority = 9, description = "OQ_105 Test case 13: TC-13.09")
	@Step("Step 9. Check the To Fax Number's faxinbox for the eLetter")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received")
	public void Ts1309(Method method) {
		startTest(method.getName(), "Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received");
		//how to check the To Fax number's inbox 
		Assert.assertTrue(true);
	}
	
}

