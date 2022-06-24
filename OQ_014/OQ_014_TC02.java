package testcases.OQ_014;

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
@Feature("OQ_014 Tests")
public class OQ_014_TC02 extends BaseTest {
	ParticipantsPage participantsPage;
	MailPage mailPage;
	String participant = "KARIM BENIN";
	
	@BeforeClass
	public void beforeClass() {
		participantsPage = new ParticipantsPage();
		mailPage = new MailPage();
		homePage.clickHomeTab();
	}

	@Test(priority = 1, description = "OQ_014 Test case 2: TC-02.01")
	@Step("Step 1: Click on Participants tab, the Participants page is displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Click on Participants tab, the Participants page is displayed")
	public void Ts0101(Method method) {
		startTest(method.getName(), "Click on Participants tab, the Participants page is displayed");
		homePage.clickParticipantsTab();
		Assert.assertTrue(super.isTextShowing("Recent Participants"));

	}

	@Test(priority = 2, description = "OQ_014 Test case 2: TC-02.02")
	@Step("Step 2: From the View dropdown list, select LCCs-ALL")
	@Severity(SeverityLevel.BLOCKER)
	@Description("From the View dropdown list, select LCCs-ALL, A list of LCCs is displayed")
	public void Ts0102(Method method) {
		startTest(method.getName(), "From the View dropdown list, select LCCs-ALL, A list of LCCs is displayed");
		homePage.selectViewListItem("LCCs - All");
		Assert.assertTrue(super.isTextShowing("New Participant"));
	}

	@Test(priority = 3, description = "OQ_014 Test case 2: TC-02.03")
	@Step("Step 3: In the list view, find the desired LCC and click the LCC's name")
	@Severity(SeverityLevel.BLOCKER)
	@Description("In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC")
	public void Ts0103(Method method) {
		startTest(method.getName(), "In the list view, find the desired LCC and click the LCC's name, The Participant page is displayed for the selected LCC");
		homePage.clickOnViewResultItemLink(participant);
		Assert.assertTrue(super.isTextShowing("Participant Detail"));
	}

	@Test(priority = 4, description = "OQ_014 Test case 2: TC-02.04")
	@Step("Step 4.Confirm that the following related lists are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following related lists are properly displayed")
	public void Ts0204(Method method) {
		startTest(method.getName(), "Confirm that the following related lists are properly displayed");
		List <String> titleList = new ArrayList<String>();
		boolean result;
		String [] titles = {"Patient Participants", "Scheduled Reports", "Locations", "Additional Location Access", "Activity History", "Participant History"};
		titleList = participantsPage.getRelatedTitleList();
		result = titleList.equals(Arrays.asList(titles));
		Assert.assertTrue(result);
	}
	
	@Test(priority = 5, description = "OQ_014 Test case 2: TC-02.05")
	@Step("Step 5.Confirm that the following fields are properly displayed")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Confirm that the following fields are properly displayed")
	public void Ts0205(Method method) {
		startTest(method.getName(), "Confirm that the following fields are properly displayed");
		String [] labels = {"First Name", "Last Name", "Address 1", "Communication Language", "Preferred method of communication", "Phone", "Fax", "Participant Name"};
		Map<String, String> fieldMap = new HashMap<String, String>();
		fieldMap = homePage.getFormText(labels);
		for (String name: labels) {
		    String value = fieldMap.get(name).toString();
		    Reporter.log("The information for the displaying fields are: " + name + " " + value, true);
		}
		Assert.assertTrue(fieldMap.size()>0);
	}
}

