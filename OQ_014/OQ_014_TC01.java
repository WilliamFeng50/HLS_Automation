package testcases.OQ_014;

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
import pages.MailPage;
import pages.ParticipantsPage;
import testLibs.BaseTest;
import utils.listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("OQ_014 Test Cases")
public class OQ_014_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	MailPage mailPage;
	String participant = "KARIM BENIN";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		mailPage = new MailPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_014 Test case 1: TC-01.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_014 Test case 1: TC-01.02")
	@Step("Step 2: From the View dropdown list, select LCCs-ALL")
	@Severity(SeverityLevel.BLOCKER)
	@Description("From the View dropdown list, select LCCs-ALL, A list of LCCs is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From the View dropdown list, select LCCs-ALL, A list of LCCs is displayed");
		homePage.selectViewListItem("LCCs - All");
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_014 Test case 1: TC-01.03")
	@Step("Step 3: In the list view, find the desired LCC and click the LCC's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC");
		homePage.clickOnViewResultItemLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_014 Test case 1: TC-01.04")
	@Step("Step 4: In the Recent Items section on the left, find the LCC noted above and hover over the LCC's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the Recent Items section on the left, find the LCC noted above and hover over the LCC's name, The popup appears as expected")
	public void Ts0104(Method method) {
		homePage.hoverOverRecentItem(participant);
		Assert.assertTrue(homePage.hoverViewBtn.isDisplayed());
	}
	
	@Test(priority = 5, description = "OQ_014 Test case 1: TC-01.05")
	@Step("Step 5. Confirm that the LCC information is properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the LCC information is properly displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Confirm that the LCC information is properly displayed");
		String [] labels = {"First Name", "Last Name", "Address 1", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Participant Name"};
		Map<String, String> lcc = new HashMap<String, String>();
		lcc = homePage.getLCCInformation();
		for (String name: labels) {
		    String value = lcc.get(name).toString();
		    Reporter.log("The details of LCC are: " + name + " " + value, true);
		}
		Assert.assertTrue(lcc.size()>0);
	}	
	
}

