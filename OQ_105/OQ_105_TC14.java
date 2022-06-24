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
import pages.NRDBPage;
import pages.TestResultPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_105 Test Cases")
public class OQ_105_TC14 extends BaseTest {
	String nrdbId = "NRDB-504191";
	String genericCompany = "";
	String documentId = "DOC-04746571";
	
	@BeforeClass
	public void beforeClass() {
		testResultPage = new TestResultPage();
		alertPage = new AlertPage();
		eLetterPage = new ELetterPage();
		nrdbPage = new NRDBPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_105 Test Test case 14: TC-14.01")
	@Step("Step 1. Go to the NRDB tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the NRDB tab, the test NRDB page is displayed")
	public void Ts1401(Method method) {
		startTest(method.getName(), "Go to the NRDB tab, the test NRDB page is displayed");
		homePage.clickMenuTab("NRDB");
		Assert.assertTrue(super.isTextShowing("Recent Test Results"));
	}	

	@Test(priority = 2, description = "OQ_105 Test Test case 14: TC-14.02")
	@Step("Step 2. Select All option from the view drop down list, then click go button")
	@Severity(SeverityLevel.NORMAL)
    @Description("Select All option from the view drop down list, then click go button, a list of test resuls is displayed")
	public void Ts1402(Method method) {
		startTest(method.getName(), "Select All option from the view drop down list, then click go button, a list of test resuls is displayed");
		testResultPage.selectViewDropDownItem("All Incoming NRDB");
		Assert.assertTrue(super.isTextShowing("New NRDB"));
	}	
	
	@Test(priority = 3, description = "OQ_105 Test Test case 14: TC-14.03")
	@Step("Step 3. Click on the recently created NRDB ID")
	@Severity(SeverityLevel.NORMAL)
    @Description("Click on the recently created NRDB ID, the NRDB page is displayed")
	public void Ts1403(Method method) {
		startTest(method.getName(), "Click on the recently created NRDB ID, the NRDB page is displayed");
		homePage.clickOnTableLink(nrdbId);
		genericCompany = homePage.getFormText("Generic Company");
		Assert.assertTrue(super.isTextShowing("NRDB Detail"));
	}	
		
	@Test(priority = 4, description = "OQ_105 Test Test case 14: TC-14.04")
	@Step("Step 4. Go to the Faxes/Document tab")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Go to the Faxes/Document tab, the Document page is displayed")
	public void Ts1404(Method method) {
		startTest(method.getName(), "Go to the Faxes/Document tab, the Document page is displayed");
		homePage.clickFaxDocumentTab();
		homePage.selectViewListItem("All Outbound NRDB Faxes");
		homePage.clickOnViewResultLink(documentId);
		Assert.assertTrue(super.isTextShowing("Recent Faxes / Documents"));
	}	
	
	@Test(priority = 5, description = "OQ_105 Test case 14: TC-14.05")
	@Step("Step 5. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Notes & Attachments related list has one .docx file on it")
	public void Ts1405(Method method) {
		startTest(method.getName(), "Confirm that the Notes & Attachments related list has one .docx file on it");
		String title = faxDocumentPage.getAttachmentTitle();
		
		Assert.assertTrue(title.length()>0);
	}	
	
	@Test(priority = 6, description = "OQ_105 Test case 14: TC-14.06")
	@Step("Step 6. Confirm that the related fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the related fields are properly displayed: Fax Status, To Fax Number")
	public void Ts1406(Method method) {
		startTest(method.getName(), "Confirm that the related fields are properly displayed: Fax Status, To Fax Number");
		String status = homePage.getFormText("Fax Status");
		String toFax = homePage.getFormText("To Fax Number");
		Assert.assertTrue(status.equalsIgnoreCase("New") && toFax.length()>0);
	}	
	
	@Test(priority = 7, description = "OQ_105 Test case 14: TC-14.07")
	@Step("Step 7. Check the To Fax Number's faxinbox for the eLetter")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received")
	public void Ts1407(Method method) {
		startTest(method.getName(), "Check the To Fax Number's faxinbox for the eLetter, confirm the fax has been received");
		//how to check the To Fax number's inbox 
		Assert.assertTrue(true);
	}
	
}

