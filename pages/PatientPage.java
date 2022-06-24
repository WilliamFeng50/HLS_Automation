package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class PatientPage extends BaseTest{
	
	private @FindBy(xpath = "//a/div[@title='New Patient']")
	WebElement newPatientBtn;
	
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@title='Edit']")
	WebElement edittBtn;
	
	private @FindBy(xpath = "//div/div[2]/div/button[@title='Select a List View']")
	WebElement listViewBtn;
	
	private @FindBy(xpath = "//div/input[@role = 'combobox']")
	WebElement viewTxt;
	
	private @FindBy(xpath = "//li[1]/a/span/mark")
	WebElement clozarilAllBtn;
	
	private @FindBy(xpath = "//div/input[@name=\"Patient__c-search-input\"]")
	WebElement searchCondictionTxt;
	
	private @FindBy(xpath = "//div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
	WebElement firstRecordLink;
		
	private @FindBy(xpath = "//div/a[@href=\"/lightning/r/a0T0A000000FWrEUAW/view\"]")
	WebElement csanNumberLink;
	
	private @FindBy(xpath = "//div/a/slot/span[contains(text(),'Alerts')]")
	WebElement alertLink;
	
	private @FindBy(xpath = "//div/a/slot/span[contains(text(),'Activity History')]")
	WebElement activityHistoryLink;
	
	private @FindBy(xpath = "//div/a/slot/span[contains(text(),'Test Results')]")
	WebElement testResultLink;
	
	private @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/table/tbody/tr[1]/td[1]")
	WebElement physicianSaluText;
	
	private @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/table/tbody/tr/td")
	List<WebElement> physicianInformationList;
	
	private @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/table/tbody/tr/td")
	List<WebElement> institutionInformationList;
	
	private @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/table/tbody/tr/td")
	List<WebElement> pharmacyInformationList;
	
	private @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/table/tbody/tr/td")
	List<WebElement> laboratoryInformationList;
	
	private @FindBy(xpath = "//input[@value='New Patient Participant']")
	WebElement newParticipantCBtn;
	
	private @FindBy(xpath = "//input[@value='Add Multiple Patient Participants']")
	WebElement addMulParticipantBtn;
	
	private @FindBy(xpath = "//th[text()='Active 	LCC']//preceding::td[1]/a")
	WebElement editLCCBtn;
	
	private @FindBy(xpath = "//th[text()='Active Institution']//preceding::td[1]/a")
	WebElement editInstitutionBtn;
	
	private @FindBy(xpath = "//th[text()='Active Laboratory']//preceding::td[1]/a")
	WebElement editLaboratoryBtn;
	
	private @FindBy(xpath = "//th[text()='Active Pharmacy']//preceding::td[1]/a")
	WebElement editPharmacyBtn;
	
	private @FindBy(xpath = "//th[text()='Active Physician']//preceding::td[1]/a")
	WebElement editPhysicianBtn;
	
	private @FindBy(xpath = "//th[text()='Active 	LCC']//following::td[2]/a")
	WebElement lccLink;
	
	private @FindBy(xpath = "//th[text()='Active Institution']//following::td[2]/a")
	WebElement institutionLink;
	
	private @FindBy(xpath = "//th[text()='Active Laboratory']//following::td[2]/a")
	WebElement laboratoryLink;
	
	private @FindBy(xpath = "//th[text()='Active Pharmacy']//following::td[2]/a")
	WebElement pharmacyLink;
	
	private @FindBy(xpath = "//th[text()='Active Physician']//following::td[2]/a")
	WebElement physicianLink;
	
	private @FindBy(xpath = "//a[@title='Participant Lookup (New Window)']")
	WebElement participantLookupBtn;
	
	private @FindBy(xpath = "//tr[2]/th/a[text()='eLetter']")
	WebElement eLetterLink;
	
	private @FindBy(xpath = "//th[text()='Test Result ID']//parent::tr//following-sibling::tr")
	List<WebElement> testResultList;
	
	
	public PatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click On New Patient button")
	public void clickOnNewPatientBtn() {
		newPatientBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On Edit Patient button")
	public void clickOnEditBtn() {
		edittBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On Recently Viewed button")
	public void clickOnListViewBtn() {
		listViewBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Select Clozaril All and click")
	public void clozarilAllView() {
		super.sendKeys(viewTxt, "Clozaril (All)");
		clozarilAllBtn.click();
		super.waitForSleep(4000);
	}
	
	@Step("Input the search condiction, search the patient in the list")
	public void search(String condiction) {
		super.sendKeys(searchCondictionTxt, condiction);
		searchCondictionTxt.sendKeys(Keys.RETURN);
		super.waitForSleep(4000);
	}
	
	@Step("Click On the patient in the table list")
	public void clickOnRecordLink() {
		firstRecordLink.click();
		super.waitForSleep(3000);
	}
	
	@Step("Click On the patient {0} in the table list")
	public void clickOnRecordLink(String csan) {
		elementsPg.searchListItemLink(csan).click();
		super.waitForSleep(3000);
	}
	
	@Step("Get the Patient number")
	public String getpatient() {
		return firstRecordLink.getAttribute("title");
	}
	
		
	@Step("Click On CSAN number link")	
	public void clickOnCsanNumberLink() {
		csanNumberLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click On Alert link")	
	public void clickOnAlertLink() {
		alertLink.click();
		super.waitForSleep(4000);
	}
	
	@Step("Click On Activity History link")	
	public void clickOnActivityHistoryLink() {
		activityHistoryLink.click();
		super.waitForSleep(4000);
	}
	
	@Step("Click on Save button")
	public void clickOnSaveBtn() {
		elementsPg.button("SaveEdit").click();
		super.waitForSleep(3000);
	}
	
	public boolean checkPatientShowing(String patient) {
		if(elementsPg.locatePatient(patient).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("Click On displaying subsection button")
	public void clickSubsectionDisplayBtn(String title) {
		super.moveToElement(elementsPg.styleValue(title));
		String style = elementsPg.styleValue(title).getAttribute("style");
		if (style.equalsIgnoreCase("display:none;")) {
			elementsPg.hidingSubsectionBtn(title).click();
			super.waitForSleep(2000);
		}
	}
	
	@Step("Get the Physician information")
	public Map<String, String> getPhysicianInformation() {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<physicianInformationList.size();i=i+2) {
			key = physicianInformationList.get(i).getText();
		    value =  physicianInformationList.get(i+1).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the Institution information")
	public Map<String, String> getInstitutionInformation() {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<institutionInformationList.size();i=i+2) {
			key = institutionInformationList.get(i).getText();
		    value =  institutionInformationList.get(i+1).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the Pharmacy information")
	public Map<String, String> getPharmacyInformation() {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<pharmacyInformationList.size();i=i+2) {
			key = pharmacyInformationList.get(i).getText();
		    value =  pharmacyInformationList.get(i+1).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the Laboratory information")
	public Map<String, String> getLaboratoryInformation() {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<laboratoryInformationList.size();i=i+2) {
			key = laboratoryInformationList.get(i).getText();
		    value =  laboratoryInformationList.get(i+1).getText();
			details.put(key, value);
		}
		return details;
	}
	
	
	@Step("Click on the Participants {0} link")
	public void clickOnParticipantLink(String field) {
		super.moveToElement(elementsPg.formLink(field));
		elementsPg.formLink(field).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Patient {0} link")
	public void clickOnPatientLink(String field) {
		super.moveToElement(elementsPg.formLink(field));
		elementsPg.formLink(field).click();
		super.waitForSleep(2000);
	}
	
	@Step("Get the physician name")
	public String getPhysicianName() {
		super.moveToElement(elementsPg.formLink("Physician"));
		return elementsPg.formLink("Physician").getText();
	}
	
	@Step("Click on the lookup button")
	public void clickOnLookup(String label) {
		super.moveToElement(elementsPg.lookupButton(label));
		elementsPg.lookupButton(label).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the new patient participant button")
	public void clickOnNewParticipant() {
		newParticipantCBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Add Multiple Patient Participants button")
	public void clickOnAddMulParticipant() {
		addMulParticipantBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the active Physician Link")
	public void clickOnPhysicianLink() {
		physicianLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the active LCC Link")
	public void clickOnLCCLink() {
		lccLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the active Institution")
	public void clickOnInstitutionLink() {
		institutionLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the active Laboratory link")
	public void clickOnLaboratoryLink() {
		laboratoryLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active Pharmacy button")
	public void clickOnPharmacyLink() {
		pharmacyLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active Physician button")
	public void editActivePhysician() {
		editPhysicianBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active LCC button")
	public void editActiveLCC() {
		editLCCBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active Institution button")
	public void editActiveInstitution() {
		editInstitutionBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active Laboratory button")
	public void editActiveLaboratory() {
		editLaboratoryBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Edit active Pharmacy button")
	public void editActivePharmacy() {
		editPharmacyBtn.click();
		super.waitForSleep(2000);
	}
	
	
	@Step("Click on the Participant lookup button")
	public void clickOnParticipantLookup() {
		participantLookupBtn.click();
		super.waitForSleep(2000);
		super.switchToSubWindow();
		driver.manage().window().maximize();
	}
		
	public String getSalutation() {
		return physicianSaluText.getText();
	}
	
	@Step("Get the participants and LCCs infomation, type: {0}, name: {1}")
	public List<String> getParticipantsAndLCCsInformation(String type, String name) {
		List<String> details = new ArrayList<String>();
			for(int i=0;i<elementsPg.participantsAndLCC(type, name).size();i++) {
				details.add(elementsPg.participantsAndLCC(type, name).get(i).getText());
			}
		return details;
	}
	
	@Step("Click on Edit button which the name is {0}, the type is {0}")
	public void clickOnParticipantsAndLCCsEditButton(String type, String name) {
		elementsPg.participantsAndLCCEdit(type, name).click();
		super.waitForSleep(1000);
	}
	
	@Step("Click On New Test Result button")		
	public void clickOnNewTestResult() {
		elementsPg.button("New Test Result").click();
	}
	
	@Step("Get the last blood test date")
	public String getBloodLastTestDate() {
		return elementsPg.helpFormText("Last Blood Test").getText();
	}
	
	@Step("Get the test result of {0}")
	public Map<String, String> getTestResultValues(String id) {
		Map<String, String> details = new HashMap<String, String>();
		String [] col = {"Test Date","WBC","ANC","GRC", "Test Result Alert", "Type"};
		String key, value, xp;
		for(int i=1;i<=col.length;i++) {
			key = col[i-1];
			xp = "//th/a[text()='" + id + "']//following::td[" + i +"]";
		    value = driver.findElement(By.xpath(xp)).getText();
			details.put(key, value);
		}
		return details;
	}

	@Step("Get the test result of {0}")
	public Map<String, String> getActivityValues(String id) {
		Map<String, String> details = new HashMap<String, String>();
		String s = "//td/a[text()='" + id + "']//preceding::th[1]";
		String subject = driver.findElement(By.xpath(s)).getText();
		details.put("Subject", subject);
		String d = "//td/a[text()='" + id + "']//following::td[3]";
		String createDate = driver.findElement(By.xpath(d)).getText();
		details.put("Create Date", createDate);
		return details;
	}
	
	public String getTestResultId(int row) {
		String id = null;
	    String xp = "//h3[text()='Test Results (Units of measure 10^9/L)']//ancestor::div[1]//following-sibling::div/table/tbody/tr[" + row + "]/th";
	    id = driver.findElement(By.xpath(xp)).getText();
	    return id;
	}
	
	@Step("Change the patient status to {0}")
	public void changePatientStatus(String status) {
		elementsPg.dropDownBtn("Patient Status").click();
		elementsPg.dropDownListItem(status).click();
	}
	
	@Step("Get the patient status: {0}")
	public String getPatientStatus() {
		return elementsPg.formText("Patient Status").getText();
	}
	
	@Step("Click on eLetter button")
	public void clickOnEletterButton() {
		elementsPg.button("eLetter").click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the eLetter link in the Activity History list")
	public void clickOnEletterLink() {
		eLetterLink.click();
		super.waitForSleep(2000);
	}
	
	@Step("Get the Treatments details")
	public Map<String, String> getTreatmentsInformation(String status) {
		Map<String, String> details = new HashMap<String, String>();
		String s = "//td[text()='" + status + "']//preceding::th[1]/a";
		String id = driver.findElement(By.xpath(s)).getText();
		details.put("Treatment ID", id);
		String d1 = "//td/a[text()='" + status + "']//following::td[1]";
		String startDate = driver.findElement(By.xpath(d1)).getText();
		details.put("Start Date", startDate);
		String d2 = "//td/a[text()='" + status + "']//following::td[2]";
		String endDate = driver.findElement(By.xpath(d2)).getText();
		details.put("End Date", endDate);
		
		String d3 = "//td/a[text()='" + status + "']//following::td[3]";
		String weeks = driver.findElement(By.xpath(d3)).getText();
		details.put("Total Weeks", weeks);
		
		String d4 = "//td/a[text()='" + status + "']//following::td[4]";
		String reason = driver.findElement(By.xpath(d4)).getText();
		details.put("Withdrawn Reason", reason);
				
		return details;
	}
	
	@Step("Get the test result ID from test result alert")
	public String getTestResultIDByAlert(String alert) {
		String id = "";
		int size = testResultList.size();
		for(int i=1; i<=size; i++) {
			String xpA = "//th[text()='Test Result ID']//parent::tr//following-sibling::tr[" + 1 + "]/td/img";
			String xpID = "//th[text()='Test Result ID']//parent::tr//following-sibling::tr[" + 1 + "]/th/a";
			String resultAlert = driver.findElement(By.xpath(xpA)).getAttribute("src");
			if(resultAlert.equalsIgnoreCase(alert)) {
				id = driver.findElement(By.xpath(xpID)).getText();
				break;
			}
		}
		return id; 
	}
	
	@Step("Get the alert type")
	public String getAlertType(String alertNumber) {
		String xp = "//th/a[text()='" + alertNumber + "']//following::td[2]";
		String type = driver.findElement(By.xpath(xp)).getText();
		return type;
	}
}
