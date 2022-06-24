package testcases.OQ_019;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.EditPatientPage;
import pages.PatientPage;
import pages.TestResultPage;
import testLibs.BaseTest;

@Epic("Regression Tests")
@Feature("OQ_019 Test Cases")
public class OQ_019_TC26 extends BaseTest {
	PatientPage patientPage;
	TestResultPage testResultPage;
	EditPatientPage editPatientPage;
	
	String patient = "1990101503 PD";
	String testResultID;
	String today;
	
	@BeforeClass
	public void beforeClass() {
		patientPage = new PatientPage();
		testResultPage = new TestResultPage();
		editPatientPage = new EditPatientPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickHomeTab();
		homePage.clickPatientTab();
		homePage.clickOnSearch(patient);
		
		
	}
		
	@Test(priority = 1, description = "OQ_019 Test Test case 26: TC-26.01")
	@Step("step 1. On the patient detail page, click on edit button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("On the patient detail page, click on edit button, the patient edit page is showing")
	public void Ts2601(Method method) {
		startTest(method.getName(), "On the patient detail page, click on edit button, the patient edit page is showing");
		patientPage.clickOnEditBtn();
		Assert.assertTrue(super.isTextShowing("Patient Edit"));
	}	
	
	@Test(priority = 2, description = "OQ_019 Test Test case 26: TC-26.02")
	@Step("step 2. Edit the patient information, then click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Patient Status is now Active")
	public void Ts2602(Method method) {
		startTest(method.getName(), "Confirm that the Patient Status is now Active");
		editPatientPage.changePatientStatus("Withdrawn");
		editPatientPage.editTreatment("", today, "", "No", "", "", "");
		editPatientPage.clickOnSaveButton();
		Assert.assertTrue(super.isTextShowing("Confirmed Red Alert Date Must be filled out"));
	}	
	
	@Test(priority = 3, description = "OQ_019 Test Test case 26: TC-26.03")
	@Step("step 3. Confirm that the Patient Status is now Active.")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the Patient Status is now Active")
	public void Ts2603(Method method) {
		startTest(method.getName(), "Confirm that the Patient Status is now Active");
		editPatientPage.editTreatment(today, today, "", "No", "", "", "");
		editPatientPage.clickOnSaveButton();
		String status = homePage.getFormText("Patient Status");
		Assert.assertTrue(status.equals("Withdrawn"));
	}	
}
