package testcases.OQ_016;

import static utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
@Feature("OQ_016 Test Cases")
public class OQ_016_TC01 extends BaseTest {
	ParticipantsPage participantsPage;
	String participant = "APOTEX";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_016 Test case 1: TC-01.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_016 Test case 1: TC-01.02")
	@Step("Step 2: From the View dropdown list, select Generic Companies")
	@Severity(SeverityLevel.BLOCKER)
	@Description("From the View dropdown list, select Generic Companies, A list of LCCs is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From the View dropdown list, select Generic Companies, A list of LCCs is displayed");
		homePage.selectViewListItem("Generic Companies");
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_016 Test case 1: TC-01.03")
	@Step("Step 3: In the list view, find the desired LCC and click the LCC's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC");
		homePage.clickOnViewResultItemLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_016 Test case 1: TC-01.04")
	@Step("Step 4.Confirm that the following related lists are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following related lists are properly displayed")
	public void Ts0104(Method method) {
		startTest(method.getName(), "Confirm that the following related lists are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] titles = {"Activity History", "NRDB"};
		titleList = participantsPage.getRelatedTitleList();
		result = titleList.equals(Arrays.asList(titles));
		Assert.assertTrue(result);
	}
	
	@Test(priority = 5, description = "OQ_016 Test case 1: TC-01.05")
	@Step("Step 5. Confirm that the LCC information is properly displayed")
	@Severity(SeverityLevel.BLOCKER)
    @Description("Confirm that the LCC information is properly displayed")
	public void Ts0105(Method method) {
		startTest(method.getName(), "Confirm that the LCC information is properly displayed");
		String [] labels = {"Name", "Address 1", "City", "Province", "Communication Language", "Preferred method of communication", "Phone", "Fax", "First Name", "Salutation", "Last Name"};
		Map<String, String> lcc = new HashMap<String, String>();
		lcc = homePage.getLCCInformation();
		for (String name: labels) {
		    String value = lcc.get(name).toString();
		    Reporter.log("The details of LCC are: " + name + " " + value, true);
		}
		Assert.assertTrue(lcc.size()>0);
	}	
	
}

