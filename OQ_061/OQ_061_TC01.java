package testcases.OQ_061;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
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
@Feature("OQ_061 Test cases")
public class OQ_061_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	EditParticipantsPage editParticipantsPage;
	String participant = "MARIA ARISTA";
	String tempPass = "";
	String userName = "";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		editParticipantsPage = new EditParticipantsPage();
		managePortalUserPage = new ManagePortalUserPage();
		homePage.clickHomeTab();
		homePage.clickParticipantsTab();
		homePage.clickOnSearch(participant);
		participantsPage.clickOnParticipantsLink(participant);
	}

	@Test(priority = 1, description = "OQ_001 Test case 1: TC-01.01")
	@Step("Step 1. Click on the Manage Portal User button")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on the Manage Portal User button, the Manage Portal User page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on the Manage Portal User button, the Manage Portal User page is displayed");
		participantsPage.clickOnManagePortalUserButton();
		Assert.assertTrue(super.isTextShowing("Deactivate User"));		
	}
	
	@Test(priority = 2, description = "OQ_061 Test case 1: TC-01.02")
	@Step("Step 2. Confirm the following information is displayed: Username, Email, Last Login Date, Active")
	@Severity(SeverityLevel.NORMAL)
	@Description("Confirm the following information is displayed: Username, Email, Last Login Date, Active")
	public void Ts0102(Method method) {
		startTest(method.getName(), "Confirm the following information is displayed: Username, Email, Last Login Date, Active");
		Map<String, String> portalUser = new HashMap<String, String>();
		String[] fields = {"Username", "Email", "Last Login Date", "Active"};
		portalUser = managePortalUserPage.getPortalUserInformation(fields);
		for (String key: portalUser.keySet()) {
		   String value = portalUser.get(key).toString();
		   Reporter.log("The portal user information is " + key + " " + value, true);
		}
		Assert.assertTrue(portalUser.size() > 0);		
	}
		
	@Test(priority = 3, description = "OQ_061 Test case 1: TC-01.03")
	@Step("Step 3. Click on the Reset Password button")
	@Severity(SeverityLevel.NORMAL)
	@Description("Click on the Reset Password button, confirm the temporary password is showing")
	public void Ts0103(Method method) {
		startTest(method.getName(), "Click on the Reset Password button, confirm the temporary password is showing");
		managePortalUserPage.clickOnRestPasswordButton();
		tempPass = managePortalUserPage.getPassword();
		userName = managePortalUserPage.getUserName();
		Reporter.log("The portal username is " + userName + ", the password is " + tempPass, true);
		Assert.assertTrue(super.isTextShowing("Temporary password is "+ tempPass + ". The user will be prompted to change their password after logging in."));		
	}
	
	//test cases 02 and 03 should be added in after this step
}

