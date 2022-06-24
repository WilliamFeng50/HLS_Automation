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
import pages.ManagePortalUserPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_060 Test cases")
public class OQ_060_TC06 extends BaseTest {
	String participant = "MARIA ARISTA";
	String patient = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		managePortalUserPage = new ManagePortalUserPage(); 		
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_060 Test case 6: TC-06.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0601(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_060 Test case 6: TC-06.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0602(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_060 Test case 6: TC-06.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0603(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_060 Test case 6: TC-06.04")
	@Step("Step 4. Click on the Manage Portal User button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the Manage Portal User button, the Manage Portal User page is displayed")
	public void Ts0604(Method method) {
		startTest(method.getName(), "Click on the Manage Portal User button, the Manage Portal User page is displayed");
		participantsPage.clickOnManagePortalUserButton();
		Assert.assertTrue(super.isTextShowing("Deactivate User"));		
	}
	
	@Test(priority = 5, description = "OQ_060 Test case 6: TC-06.05")
	@Step("Step 5. Click on the Deactivate User button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the Deactivate User button, confirm the Deactivate User and Reset Password buttons have been replaced by the Reactivate User button")
	public void Ts0605(Method method) {
		startTest(method.getName(), "Click on the Deactivate User button, confirm the Deactivate User and Reset Password buttons have been replaced by the Reactivate User button");
		managePortalUserPage.clickOnDeactivateUserButton();
		Assert.assertTrue(!super.isTextShowing("Deactivate User") && !super.isTextShowing("Reset Password") && super.isTextShowing("Reactivate User"));			
	}
}

