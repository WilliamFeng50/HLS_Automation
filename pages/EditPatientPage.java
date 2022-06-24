package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class EditPatientPage extends BaseTest{
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
	
	public EditPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Change the patient status to {0}")
	public void changePatientStatus(String status) {
		elementsPg.dropDownBtn("Patient Status").click();
		elementsPg.dropDownListItem(status).click();
	}
	
	@Step("Edit the patient Information")
	public void editPatientInformation(String patient, String initials, String firstName, String lastName, String birthday, String status, String special, String faxDoc, String offLabel, String indication, String gender, String race, String location, String aux, String healthCard, String province, String mrn, String epicId, String stiCard) {
		if (patient.length()> 0) super.sendKeys(elementsPg.inputField("Patient"), patient);
		if (initials.length()> 0) super.sendKeys(elementsPg.inputField("Initials"), initials);
		if (firstName.length()> 0) super.sendKeys(elementsPg.inputField("First Name"), firstName);
		if (lastName.length()> 0) super.sendKeys(elementsPg.inputField("Last Name"), lastName);
		if (birthday.length()> 0) super.sendKeys(elementsPg.inputField("DOB"), birthday);
		
		if(status.length()>0) {
			elementsPg.dropDownBtn("Patient Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if (special.equalsIgnoreCase("Yes")) elementsPg.inputField("Special Case").click();
		if (faxDoc.length()> 0) super.sendKeys(elementsPg.inputField("Fax / Document"), faxDoc);
		
		if(offLabel.length()>0) {
			elementsPg.dropDownBtn("Off Label Use").click();
			elementsPg.dropDownListItem(offLabel).click();
		}
		
		if (indication.length()> 0) super.sendKeys(elementsPg.textArea("Indication"), indication);
		
		if(gender.length()>0) {
			elementsPg.dropDownBtn("Gender").click();
			elementsPg.dropDownListItem(gender).click();
		}
		
		if(race.length()>0) {
			elementsPg.dropDownBtn("Race").click();
			elementsPg.dropDownListItem(race).click();
		}
		
		if(location.length()>0) {
			elementsPg.dropDownBtn("Location").click();
			elementsPg.dropDownListItem(location).click();
		}
		
		if (aux.length()> 0) super.sendKeys(elementsPg.textArea("Aux Number"), aux);
		
		if (healthCard.length()> 0) super.sendKeys(elementsPg.textArea("Health Card Number"), healthCard);
		
		if(province.length()>0) {
			elementsPg.dropDownBtn("HCN Province").click();
			elementsPg.dropDownListItem(province).click();
		}
		
		if (mrn.length()> 0) super.sendKeys(elementsPg.textArea("MRN"), mrn);
		if (epicId.length()> 0) super.sendKeys(elementsPg.textArea("EPIC ID"), epicId);
		if (stiCard.length()> 0) super.sendKeys(elementsPg.textArea("STI Card Number"), stiCard);
	}
	
	@Step("Edit the patient Special Case information")
	public void editSpecialCase(String type, String startDate, String guideline) {
		homePage.moveToSectionEdit("Special Case");
		if(type.length()>0) {
			elementsPg.dropDownBtn("Special Case Type").click();
			elementsPg.dropDownListItem(type).click();
		}
		
		if (startDate.length()> 0) super.sendKeys(elementsPg.inputField("Special Case Start Date"), startDate);
		
		if (guideline.length()> 0) super.sendKeys(elementsPg.textArea("Special Case Guidelines"), guideline);
	}
	
	@Step("Edit the patient Protocol information")
	public void editProtocol(String type) {
		homePage.moveToSectionEdit("Special Case");
		elementsPg.dropDownBtn("Protocol").click();
		elementsPg.dropDownListItem(type).click();
	}
	
	public void editParticipants() {
		
	}
	
	@Step("Edit the patient Additional Information")
	public void editAdditionalInformation(String information) {
		homePage.moveToSectionEdit("Additional Information");
		super.sendKeys(elementsPg.textArea("Additional Information"), information);
	}
	
	@Step("Edit the patient Switched from Generic to Brand information")
	public void editSwitchedFromGenericToBrand(String gSwitch, String switchDate, String company) {
		homePage.moveToSectionEdit("Additional Information");
		if (gSwitch.length()> 0) elementsPg.inputField("Generic Switch").click();
		if (switchDate.length()> 0) super.sendKeys(elementsPg.inputField("Generic Switch Date"), switchDate);
		
		if(company.length()>0) {
			elementsPg.dropDownBtn("Generic Switch Company").click();
			elementsPg.dropDownListItem(company).click();
		}
	}
	
	@Step("Edit the patient Results Contact information")
	public void editResultsContact(String call, String name, String phone) {
		homePage.moveToSectionEdit("Results Contact");
		if (call.length()> 0) elementsPg.inputField("Call for Results?").click();
		if (name.length()> 0) super.sendKeys(elementsPg.inputField("Contact Name to Call for Results"), name);
		if (phone.length()> 0) super.sendKeys(elementsPg.inputField("Contact Number to Call for Results"), phone);
	}
	
	@Step("Edit the patient treatment informations:"
			+ "Confirmed Red Alert Date {0} "
			+ "Withdrawn Date {1} "
			+ "Withdrawn Reason {2} "
			+ "Send Discontinuation eLetter {3} "
			+ "NRDB Status {4} "
			+ "NRDB Patient {5} "
			+ "NRDB Created Date {6}")
	public void editTreatment(String alertDate, String withdrwanDate, String reason, String eleter, String nrdbStatus, String nrdbPatient, String nrdbDate) {
		homePage.moveToSectionEdit("Treatment");
		if (alertDate.length()>0) super.sendKeys(elementsPg.inputField("Confirmed Red Alert Date"), alertDate);
		
		if (withdrwanDate.length()>0) {
			super.sendKeys(elementsPg.inputField("Withdrawn Date"), alertDate);
			elementsPg.dropDownBtn("Withdrawn Reason").click();
			elementsPg.dropDownListItem(reason).click();
		}
		
		if(eleter.length()>0) {
			elementsPg.dropDownBtn("Send Discontinuation eLetter").click();
			elementsPg.dropDownListItem(eleter).click();
		}
		
		if(nrdbStatus.length()>0) {
			elementsPg.dropDownBtn("NRDB Status").click();
			elementsPg.dropDownListItem(nrdbStatus).click();
		}
		
		if (nrdbPatient.length()>0) super.sendKeys(elementsPg.inputField("NRDB Patient"), nrdbPatient);
		if (nrdbDate.length()>0) super.sendKeys(elementsPg.inputField("NRDB Created Date"), nrdbDate);
	}
	
	
	@Step("Edit the patient Monitoring information")
	public void editMonitoring(String days, String overrideDate) {
		homePage.moveToSectionEdit("Monitoring");
		if(days.length()>0) {
			elementsPg.dropDownBtn("Monitoring Frequency").click();
			elementsPg.dropDownListItem(days).click();
		}
		
		if (overrideDate.length()>0) super.sendKeys(elementsPg.inputField("Next Freq. Alert Override Date"), overrideDate);
	}
	
	@Step("Edit the patient System Information")
	public void editSystemInformation(String internal, String shared) {
		homePage.moveToSectionEdit("Monitoring");
		if (internal.length()>0) super.sendKeys(elementsPg.textArea("Internal Comment"), internal);
		if (shared.length()>0) super.sendKeys(elementsPg.textArea("Shared Comment"), shared);
	}
	
	@Step("Click on save button")
	public void clickOnSaveButton() {
		super.moveToElement(saveBtn);
		saveBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on cancel button")
	public void clickOnCancelButton() {
		super.moveToElement(cancelBtn);
		cancelBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on save&new button")
	public void clickOnSaveAndNewButton() {
		super.moveToElement(saveAndNewBtn);
		saveAndNewBtn.click();
		super.waitForSleep(2000);
	}
}
