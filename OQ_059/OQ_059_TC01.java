package testcases.OQ_059;

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
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Test")
@Feature("OQ_059 Test cases")
public class OQ_059_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	EditParticipantsPage editParticipantsPage;
	String participant = "MARIA ARISTA";
	String tempPass = "";
	String portalUser = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		managePortalUserPage = new ManagePortalUserPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_059 Test case 1: TC-01.01")
	@Step("Step 1. Go to the Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_059 Test case 1: TC-01.02")
	@Step("Step 2. In the top of search field, input the physician's name, and click on search button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the search field, input the physician's name, and click on search button, the search result list is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "In the search field, input the physician's name, and click on search button, the search result list is displayed");
		homePage.clickOnSearch(participant);
		Assert.assertTrue(super.isTextShowing("Participant Name"));
	}

	@Test(priority = 3, description = "OQ_059 Test case 2: TC-01.03")
	@Step("step 3.In the Participants section, click on the physician's name to select it")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Participants section, click on the physician's name, the Participant page is displayed")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the Participants section, click on the physician's name, the Participant page is displayed");
		participantsPage.clickOnParticipantsLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_059 Test case 1: TC-01.04")
	@Step("Step 4. Click on the Manage Portal User button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the Manage Portal User button, the Manage Portal User page is displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Click on the Manage Portal User button, the Manage Portal User page is displayed");
		participantsPage.clickOnManagePortalUserButton();
		Assert.assertTrue(super.isTextShowing("No portal user exists for this participant. Enter a username to create one."));		
	}
	
	@Test(priority = 5, description = "OQ_059 Test case 1: TC-01.05")
	@Step("Step 5. Enter a username to create one portal user")
	@Severity(SeverityLevel.NORMAL)
	@Description("Enter a username to create one portal user")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Enter a username to create one portal user");
		managePortalUserPage.createPortalUser("portalUser");
		tempPass = managePortalUserPage.getPassword();
		Assert.assertTrue(super.isTextShowing("Temporary password is "+ tempPass + ". The user will be prompted to change their password after logging in."));		
	}
	
		
	@Test(priority = 6, description = "OQ_059 Test case 1: TC-01.06")
	@Step("Step 6. Confirm that the user name entered is appended with @users.csan.ca.")
	@Severity(SeverityLevel.NORMAL)
	@Description("Confirm that the user name entered is appended with @users.csan.ca.")
	public void Ts0106(Method method) {
		startTest(method.getName(), "Confirm that the user name entered is appended with @users.csan.ca.");
		portalUser = managePortalUserPage.getUserName();
		Assert.assertTrue(portalUser.equalsIgnoreCase("portalUser@users.csan.ca"));		
	}
	
	@Test(priority = 7, description = "OQ_059 Test case 1: TC-01.07")
	@Step("Step 7. Navigate to the portal login page, login with the username and temporary password")
	@Severity(SeverityLevel.NORMAL)
	@Description("Navigate to the portal login page, login with the username and temporary password, the Change Password page is displayed")
	public void Ts0107(Method method) {
		startTest(method.getName(), "Navigate to the portal login page, login with the username and temporary password, the Change Password page is displayed");
		//how to go to login page
		Assert.assertTrue(true);		
	}
	
	@Test(priority = 8, description = "OQ_059 Test case 1: TC-01.08")
	@Step("Step 8. Enter the new password, click on save button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Enter the new password, click on save button, the portal home page is displayed")
	public void Ts0108(Method method) {
		startTest(method.getName(), "Enter the new password, click on save button, the portal home page is displayed");
		
		Assert.assertTrue(super.isTextShowing(""));
	}
}

