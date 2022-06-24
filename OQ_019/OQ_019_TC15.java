package testcases.OQ_019;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.BloodTestEntryPage;
import pages.PatientPage;
import testLibs.BaseTest;

public class OQ_019_TC15 extends BaseTest {
	BloodTestEntryPage bloodTestEntryPage;
	PatientPage patientPage;
	String patient = "2022022303";
	String today;
	String testResultID;
	
	@BeforeClass
	@Description("From the Blood Test Entry tab")
	public void beforeClass() {
		bloodTestEntryPage = new BloodTestEntryPage();
		patientPage = new PatientPage();
		today = super.getToday("yyyyMMdd");
		
		homePage.clickHomeTab();
		homePage.clickBloodTestEntryTab();
	}
		
	@Test(priority = 1, description = "OQ_019 Test case 15: TC-15.01")
	@Step("Step 1: In the Quick Search section, enter the patient's CSAN Number")
	@Severity(SeverityLevel.BLOCKER)
    @Description("In the Quick Search section, enter the patient's CSAN Number, confirm the patient is showing in the result table")
	public void Ts1501(Method method) {
		startTest(method.getName(), "In the Quick Search section, enter the patient's CSAN Number, confirm the patient is showing in the result table");
		bloodTestEntryPage.search(patient);
		Assert.assertTrue(bloodTestEntryPage.addIconIsDisplayed());		
	}	
	
	@Test(priority = 2, description = "OQ_019 Test case 15: TC-15.02")
	@Step("Step 2: In the search resluts, click on add icon")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on add icon, confirm that 1 row is added to the blood test entry table")
	public void Ts1502(Method method) {
		startTest(method.getName(), "Click on add icon, confirm that 1 row is added to the blood test entry table");
		bloodTestEntryPage.clickOnAddIcon();
		Assert.assertTrue(bloodTestEntryPage.csanRowIsDisplayed());	
	}	
	
	@Test(priority = 3, description = "OQ_019 Test case 15: TC-15.03")
	@Step("Step 3: Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 6, ANC 3, GRC 3, click on save button, confirm the values have ben autocompleted for ANC%:50, GRC%:50")
	public void Ts1503(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 6, ANC 3, GRC 3, click on save button, confirm the values have ben autocompleted for ANC%:50, GRC%:50");
		String wbc = "6";
		String anc = "3";
		String ancP = "";
		String grc = "3";
		String grcP = "";
		
		bloodTestEntryPage.newTestResult("", "", today, wbc, anc, ancP, grc, grcP, "Entered from Blood Test Entry page");
		bloodTestEntryPage.clickOnSaveBtn();
		Assert.assertTrue(!bloodTestEntryPage.csanRowIsDisplayed());		
	}	
}
