package testcases;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.FaxDocumentPage;
import pages.FaxManagementPage;
import pages.HomePage;
import pages.NewNRDBPage;
import testLibs.BaseTest;

public class PQ_008_TC_1 extends BaseTest {
	FaxDocumentPage faxDocumentPage;
	FaxManagementPage faxManagementPage;
	NewNRDBPage newNRDBPage;

	@BeforeClass
	@Step("step 0. Login and go to home page")
	public void beforeClass() {
		faxDocumentPage = new FaxDocumentPage();
		faxManagementPage = new FaxManagementPage();
		newNRDBPage = new NewNRDBPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "PQ-008 Test case 1: TC-010.01")
	@Step("step 1. click Faxes/Documents tab")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Go to the “Faxes/Documents tab, Faxes/Documents homepage should appear")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Go to the “Faxes/Documents tab, Faxes/Documents homepage should appear");
		
		homePage.clickFaxDocumentTab();
		Assert.assertTrue(super.isTextShowing("Recently Viewed"));

	}

	@Test(priority = 2, description = "PQ-008 Test case 1: TC-010.02")
	@Step("step 2. click dropdown list button, then select NRDB Request Faxes CL")
	@Severity(SeverityLevel.BLOCKER)
	@Description("From List view dropdown, select 'NRDB Request', list of all NRDB request faxes should appear")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From List view dropdown, select 'NRDB Request', list of all NRDB request faxes should appear");
		faxDocumentPage.clickDropDownBtn();
		faxDocumentPage.select09NRDBRequest();
		Assert.assertTrue(faxDocumentPage.verifyDocumentList("NRDB Request"));
	}

	@Test(priority = 3, description = "PQ-008 Test case 1: TC-010.03")
	@Step("step 3. click view button from the list of NRDB Request with a new fax")
	@Severity(SeverityLevel.BLOCKER)
	@Description("select view the new fax doucment, going to fax management page, showing the document and search patient")
	public void Ts0103(Method method) {
		startTest(method.getName(), "select view the new fax doucment, going to fax management page, showing the document and search patient");
		faxDocumentPage.viewNewFax();
		super.switchWindow();
		Assert.assertTrue(super.isTextShowing("Search Patient"));
	}

	@Test(priority = 4, description = "PQ-008 Test case 1: TC-010.04")
	@Step("step 4. click Incoming NRDB button, new NRDB Record Type window opened")
	@Severity(SeverityLevel.BLOCKER)
	@Description("click Incoming NRDB button, new NRDB Record Type window openes in edit mode with a record type Incoming NRDB")
	public void Ts0104(Method method) {
		startTest(method.getName(), "click Incoming NRDB button, new NRDB Record Type window openes in edit mode with a record type Incoming NRDB");
		faxManagementPage.clickIncomingNRDB();
		super.switchWindow();
		Assert.assertTrue(super.isTextShowing("New NRDB: Incoming NRDB"));
	}
	
	@Test(priority = 5, description = "PQ-008 Test case 1: TC-010.05")
	@Step("step 4. Enter into the information, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Enter into the information, click on save button, then new window appres with the NRDB document details displaying")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Enter into the information, click on save button, then new window appres with the NRDB document details displaying");
		newNRDBPage.newNRDBInformation("Apotex", "Released Not in DB",	super.getToday(), super.getToday());
		newNRDBPage.notInDBInformation("XX", "M", "non-existant");
		newNRDBPage.clickSaveButton();
		Assert.assertTrue(super.isTextShowing("Archived Document Logs"));
	}
	
}
