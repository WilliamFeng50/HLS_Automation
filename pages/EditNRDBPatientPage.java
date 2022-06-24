package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class EditNRDBPatientPage extends BaseTest{
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
	
	public EditNRDBPatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Change the patient status to {0}")
	public void changePatientStatus(String status) {
		elementsPg.dropDownBtn("Patient Status").click();
		elementsPg.dropDownListItem(status).click();
	}
	
	@Step("Edit the NRDB patient Information")
	public void editinformation(String patient, String status, String initials, String birthday,  String sex, String company, String physician, String institution) {
		if (patient.length()> 0) super.sendKeys(elementsPg.inputField("NRDB Patients Name"), patient);
		
		if(status.length()>0) {
			elementsPg.dropDownBtn("NRDB Patient Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if (initials.length()> 0) super.sendKeys(elementsPg.inputField("Initials"), initials);
		if (birthday.length()> 0) super.sendKeys(elementsPg.inputField("DOB"), birthday);
		
		if(sex.length()>0) {
			elementsPg.dropDownBtn("Sex").click();
			elementsPg.dropDownListItem(sex).click();
		}
		
		if (company.length()> 0) super.sendKeys(elementsPg.inputField("Generic Company"), company);
		
				
		if (physician.length()> 0) super.sendKeys(elementsPg.inputField("Physician"), physician);
		
		if (institution.length()> 0) super.sendKeys(elementsPg.inputField("Institution"), institution);
		
	}
	
	
	@Step("Edit the patient System Information")
	public void editSystemInformation(String number) {
		if (number.length()>0) super.sendKeys(elementsPg.inputField("NRDB Patient Number"), number);
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
		cancelBtn.click();
		super.waitForSleep(2000);
	}
}
