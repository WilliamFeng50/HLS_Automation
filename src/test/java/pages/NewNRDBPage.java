package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class NewNRDBPage extends BaseTest{
	private @FindBy(xpath = "//*[@id=\"combobox-button-103\"]")
	WebElement genericCompanyList;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-103-1-103\"]")
	WebElement apotexBtn;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-114\"]")
	WebElement nrdbStatusList;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-114-4-114\"]")
	WebElement releasedNotInDBBtn;
	
	
	private @FindBy(xpath = "//*[@id=\"input-120\"]")
	WebElement requestDateTxt;
	
	private @FindBy(xpath = "//*[@id=\"input-125\"]")
	WebElement responseDateTxt;
	
	private @FindBy(xpath = "//*[@id=\"input-135\"]")
	WebElement initialsTxt;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-145\"]")
	WebElement sexList;
	
	private @FindBy(xpath = "//*[@id=\"combobox-button-145-2-145\"]")
	WebElement sexM;
	
	
	private @FindBy(xpath = "//*[@id=\"input-151\"]")
	WebElement dobTxt;
	
	private @FindBy(xpath = "//button[@name = 'SaveEdit']")
	WebElement saveBtn;
	
	public NewNRDBPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void newNRDBInformation(String company, String status, String requestDate, String responseDate) {
		genericCompanyList.click();
		apotexBtn.click();
		super.waitForSleep(2000);
		
		nrdbStatusList.click();
		releasedNotInDBBtn.click();
		super.waitForSleep(2000);
		
		super.sendKeys(requestDateTxt, requestDate);
		super.sendKeys(responseDateTxt, responseDate);
		super.waitForSleep(2000);
	}
	
	public void notInDBInformation(String initials, String sex, String dob) {
		super.sendKeys(initialsTxt, initials);
		sexList.click();
		sexM.click();
		super.sendKeys(dobTxt, dob);
	}
	
	public void clickSaveButton() {
		saveBtn.click();
		super.waitForSleep(4000);
	}
	
}
