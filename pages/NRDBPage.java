package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class NRDBPage extends BaseTest{
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='topButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
	
	private @FindBy(xpath = "//input[@title='Educator']")
	WebElement educatorTxt;
	
	
	public NRDBPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on new button")
	public void clickOnNewButton() {
		elementsPg.button(" Go! ").click();
	}
	
	@Step("Select the record type of new record {0}")
	public void selectRecordType(String type) {
		elementsPg.dropDownBtn("Record Type of new record").click();
		elementsPg.dropDownListItem(type).click();
	}
	
	@Step("Click on continue button")
	public void clickOnContinueButton() {
		elementsPg.button("Continue").click();
	}
	
	@Step("Click on cancel button")
	public void clickOnCancelButton() {
		elementsPg.button("Cancel").click();
	}
		
	@Step("Edit NRDB information: Patient {0}, Generic Company {1}, NRDB Status {2} Incoming NRDB Request Date {3}, NRDB Response Date {4}")
	public void editIncomingInformation(String patient, String company, String status, String requestDate, String responseDate) {
		if (patient.length()>0) super.sendKeys(elementsPg.inputField("Patient"), patient);
		if(company.length()>0) {
			elementsPg.dropDownBtn("Generic Company").click();
			elementsPg.dropDownListItem(company).click();
		}
		if(status.length()>0) {
			elementsPg.dropDownBtn("NRDB Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if (requestDate.length()>0) super.sendKeys(elementsPg.inputField("Incoming NRDB Request Date"), requestDate);
		
		if (responseDate.length()>0) super.sendKeys(elementsPg.inputField("NRDB Response Date"), responseDate);
		
		super.waitForSleep(2000);
	}
	
		
	@Step("Complete ONLY if NRDB Status = Released Not in DB or Release Consent, Initials {0}, DOB {1}, Sex {2}")
	public void notInDBInformation(String initials, String dob,  String sex) {
		if (initials.length()>0) super.sendKeys(elementsPg.inputField("Initials"), initials);
		if (dob.length()>0) super.sendKeys(elementsPg.inputField("DOB"), dob);
		if(sex.length()>0) {
			elementsPg.dropDownBtn("Sex").click();
			elementsPg.dropDownListItem(sex).click();
		}
	}
	
	@Step("Additional information")
	public void additionalInformation(String license, String physician, String institution, String province, String region) {
		homePage.moveToSectionEdit("Additional information");
		if (license.length()>0) super.sendKeys(elementsPg.inputField("Licence Number"), license);
		if (physician.length()>0) super.sendKeys(elementsPg.inputField("Physician"), physician);
		if (institution.length()>0) super.sendKeys(elementsPg.inputField("Institution"), institution);
		
		if(province.length()>0) {
			elementsPg.dropDownBtn("Province").click();
			elementsPg.dropDownListItem(province).click();
		}
		
		if (region.length()>0) super.sendKeys(elementsPg.inputField("Region"), region);
	}
	
	@Step("Switch Request Follow-up")
	public void switchRequestFollowup(String type, String educator, String savedDate, String reason, String executed, String details) {
		homePage.moveToSectionEdit("Switch Request Follow-up");
		if(type.length()>0) {
			elementsPg.dropDownBtn("Educator").click();
			elementsPg.dropDownListItem(type).click();
		}
		if (educator.length()>0) super.sendKeys(educatorTxt, educator);
		if (savedDate.length()>0) super.sendKeys(elementsPg.inputField("Saved Date"), savedDate);
		
		if(reason.length()>0) {
			elementsPg.dropDownBtn("Reason for switch").click();
			elementsPg.dropDownListItem(reason).click();
		}
		
		if(executed.length()>0) {
			elementsPg.dropDownBtn("How was the save executed?").click();
			elementsPg.dropDownListItem(executed).click();
		}
		
		if (details.length()>0) super.sendKeys(elementsPg.textArea("Other Details"), details);
	}
	
	@Step("Incoming Legacy Fields")
	public void inLegacyFields(String patId, String alertId, String actionBy, String actionStatus, String docId, String comments, String reason, String institution ) {
		homePage.moveToSectionEdit("Legacy Fields");
		if (patId.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC PatID"), patId);
		if (alertId.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC AlertID"), alertId);
		if (actionBy.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Action By"), actionBy);
		if (actionStatus.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Action Status"), actionStatus);
		if (docId.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC DocID"), docId);
		if (comments.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Comments"), comments);
		if (reason.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Override Reason"), reason);
		if (institution.length()>0) super.sendKeys(elementsPg.inputField("Institution (Text)"), institution);
	}
	
	@Step("Incoming System Information")
	public void inSystemInformation(String patient, String document) {
		homePage.moveToSectionEdit("System Information");
		if (patient.length()>0) super.sendKeys(elementsPg.inputField("NRDB Patient"), patient);
		if (document.length()>0) super.sendKeys(elementsPg.inputField("Document"), document);
	}
	
	@Step("Edit new Outgoing NRDB Request: Patient {0} Request Date {1}")
	public void editOutgoingInformation(String patient, String requestDate) {
		if (patient.length()>0) super.sendKeys(elementsPg.inputField("Patient"), patient);
		if (requestDate.length()>0) super.sendKeys(elementsPg.inputField("Outgoing NRDB Request Date"), requestDate);
	}
	
	@Step("Response Information")
	public void responseInfo(String apotex, String apotexDate, String gencan, String gencanDate) {
		if(apotex.length()>0) {
			elementsPg.dropDownBtn("Apotex Status").click();
			elementsPg.dropDownListItem(apotex).click();
		}
		if (apotexDate.length()>0) super.sendKeys(elementsPg.inputField("Apotex Response Date"), apotexDate);
		
		if(gencan.length()>0) {
			elementsPg.dropDownBtn("GenCAN Status").click();
			elementsPg.dropDownListItem(gencan).click();
		}
		if (gencanDate.length()>0) super.sendKeys(elementsPg.inputField("GenCAN Response Date"), gencanDate);
	}
	
	@Step("Outgoing Legacy Fields")
	public void outLegacyFields(String alertId, String actionBy, String actionStatus, String status, String docId, String comments, String reason) {
		homePage.moveToSectionEdit("Legacy Fields");
		if (alertId.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC AlertID"), alertId);
		if (actionBy.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Action By"), actionBy);
		if (actionStatus.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Action Status"), actionStatus);
		if(status.length()>0) {
			elementsPg.dropDownBtn("Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if (docId.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC DocID"), docId);
		if (comments.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Comments"), comments);
		if (reason.length()>0) super.sendKeys(elementsPg.inputField("Legacy EC NRDB Override Reason"), reason);
	}
	
	@Step("Outgoing System Information")
	public void outSystemInformation(String document) {
		homePage.moveToSectionEdit("System Information");
		if (document.length()>0) super.sendKeys(elementsPg.inputField("Document"), document);
	}
	
	@Step("Click on save button")
	public void clickSaveButton() {
		super.moveToElement(saveBtn);
		saveBtn.click();
		super.waitForSleep(3000);
	}
	
}
