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

public class OQ_019_TC18 extends BaseTest {
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
		
	@Test(priority = 1, description = "OQ_019 Test case 11: TC-11.01")
	@Step("Step 1: In the Quick Search section, enter the patient's CSAN Number")
	@Severity(SeverityLevel.BLOCKER)
    @Description("In the Quick Search section, enter the patient's CSAN Number, confirm the patient is showing in the result table")
	public void Ts1101(Method method) {
		startTest(method.getName(), "In the Quick Search section, enter the patient's CSAN Number, confirm the patient is showing in the result table");
		bloodTestEntryPage.search(patient);
		Assert.assertTrue(bloodTestEntryPage.addIconIsDisplayed());		
	}	
	
	@Test(priority = 2, description = "OQ_019 Test case 09: TC-09.02")
	@Step("Step 2: In the search resluts, click on add icon")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Click on add icon, confirm that 1 row is added to the blood test entry table")
	public void Ts1102(Method method) {
		startTest(method.getName(), "Click on add icon, confirm that 1 row is added to the blood test entry table");
		bloodTestEntryPage.clickOnAddIcon();
		Assert.assertTrue(bloodTestEntryPage.csanRowIsDisplayed());	
	}	
	
	@Test(priority = 3, description = "OQ_019 Test case 09: TC-09.03")
	@Step("Step 3: Input Test Date, WBC, ANC, GRC, click on save button")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Input Test Date, WBC 5, ANC% 60, GRC% 60, click on save button, confirm the values have ben autocompleted for ANC 3, GRC 3")
	public void Ts1103(Method method) {
		startTest(method.getName(), "Input Test Date, WBC 5, ANC% 60, GRC% 60, click on save button, confirm the values have ben autocompleted for ANC 3, GRC 3");
		String wbc = "5";
		String anc = "";
		String ancP = "60";
		String grc = "";
		String grcP = "60";
		
		bloodTestEntryPage.newTestResult("", "", today, wbc, anc, ancP, grc, grcP, "Entered from Blood Test Entry page");
		bloodTestEntryPage.clickOnSaveBtn();
		Assert.assertTrue(!bloodTestEntryPage.csanRowIsDisplayed());		
	}	
}
