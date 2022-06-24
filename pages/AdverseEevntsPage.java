package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class AdverseEevntsPage extends BaseTest{
	
	private @FindBy(xpath = "//td/input[@title='New']")
	WebElement newBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save_new']")
	WebElement saveAndNewBtn;
	
	private @FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='cancel']")
	WebElement cancelBtn;
	
	public AdverseEevntsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click On downward arrow")
	public void clickOnNewButton() {
		newBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Edit Adverse Event information")
	public void editInformation(String patient, String age, String subject, String pca, String eventDate, String stopDate, String manufacturerDate, String hospitalization, String reportName, String type, String hcpName, String hcpType, String physician, String hcpPhone) {
		if( patient.length()>0) 
			super.sendKeys(elementsPg.inputField("Patient"), patient);
		if( age.length()>0) 
			super.sendKeys(elementsPg.inputField("Age at Onset of Event"), age);
		if( subject.length()>0) 
			super.sendKeys(elementsPg.inputField("Subject"), subject);
		if( pca.length()>0) 
			super.sendKeys(elementsPg.inputField("PCA Number"), pca);
		if( eventDate.length()>0) 
			super.sendKeys(elementsPg.inputField("Event Onset Date"), eventDate);
		if( stopDate.length()>0) 
			super.sendKeys(elementsPg.inputField("Treatment Stop Date"), stopDate);
		if( manufacturerDate.length()>0) 
			super.sendKeys(elementsPg.inputField("Date Received By Manufacturer"), manufacturerDate);
		if( hospitalization.length()>0) 
			super.sendKeys(elementsPg.inputField("Hospitalization Date"), hospitalization);
		if( stopDate.length()>0) 
			super.sendKeys(elementsPg.inputField("Reporter's Name"), stopDate);
		if(type.length()>0) {
			elementsPg.dropDownBtn("Type").click();
			elementsPg.dropDownListItem(type).click();
		}
		if( hcpName.length()>0) 
			super.sendKeys(elementsPg.inputField("HCP Name"), hcpName);
		if(hcpType.length()>0) {
			elementsPg.dropDownBtn("HCP Type").click();
			elementsPg.dropDownListItem(hcpType).click();
		}
		if(physician.length()>0) {
			elementsPg.dropDownBtn("Authorized to contact Physician?").click();
			elementsPg.dropDownListItem(physician).click();
		}
		if( hcpPhone.length()>0) 
			super.sendKeys(elementsPg.inputField("HCP Phone"), hcpPhone);
			
	}
	
	public void descriptionOfEvent(String description, String forReturn, String quality, String causality, String seriousness, String outcome, String cause, String deathDate) {
		if( description.length()>0) 
			super.sendKeys(elementsPg.textArea("Description"), description);
		if(forReturn.length()>0) {
			elementsPg.dropDownBtn("Is there a sample available for return?").click();
			elementsPg.dropDownListItem(forReturn).click();
		}
		if( quality.length()>0) 
			super.sendKeys(elementsPg.inputField("Is adverse event a quality complaint?"), quality);
		if(causality.length()>0) {
			elementsPg.dropDownBtn("Causality").click();
			elementsPg.dropDownListItem(causality).click();
		}
		if(seriousness.length()>0) {
			elementsPg.dropDownBtn("Seriousness").click();
			elementsPg.dropDownListItem(seriousness).click();
		}
		if(outcome.length()>0) {
			elementsPg.dropDownBtn("Outcome").click();
			elementsPg.dropDownListItem(outcome).click();
		}
		if( cause.length()>0) 
			super.sendKeys(elementsPg.inputField("Cause of Death"), cause);
		if( deathDate.length()>0) 
			super.sendKeys(elementsPg.inputField("Death Date"), deathDate);
	}
	
	@Step("Input Fax / Document")
	public void systemInformation(String fax) {
		super.sendKeys(elementsPg.inputField("Fax / Document"), fax);
	}
	
	@Step("Click on the Adverse ID {0} link")
	public void clickOnEventID(String id) {
		String xp = "//td/div/a/span[text()='" + id + "']";
		driver.findElement(By.xpath(xp)).click();
		super.waitForSleep(2000);
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
