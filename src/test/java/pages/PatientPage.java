package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class PatientPage extends BaseTest{
	
	private @FindBy(xpath = "//a/div[@title='New Patient']")
	WebElement newPatientBtn;
	
	private @FindBy(xpath = "//div/div[2]/div/button[@title='Select a List View']")
	WebElement listViewBtn;
	
	private @FindBy(xpath = "//div/input[@role = 'combobox']")
	WebElement viewTxt;
	
	private @FindBy(xpath = "//li[1]/a/span/mark")
	WebElement clozarilAllBtn;
	
	private @FindBy(xpath = "//div/input[@name=\"Patient__c-search-input\"]")
	WebElement searchCondictionTxt;
	
	private @FindBy(xpath = "//tr/th/span/a[@title = '2018041601 IM']")
	WebElement firstRecordLink;
		
	private @FindBy(xpath = "//div/a[@href=\"/lightning/r/a0T0A000000FWrEUAW/view\"]")
	WebElement csanNumberLink;
	
	public PatientPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewPatientBtn() {
		newPatientBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnListViewBtn() {
		listViewBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clozarilAllView() {
		super.sendKeys(viewTxt, "Clozaril (All)");
		clozarilAllBtn.click();
		super.waitForSleep(4000);
	}
	
	public void search(String condiction) {
		super.sendKeys(searchCondictionTxt, condiction);
		searchCondictionTxt.sendKeys(Keys.RETURN);
	}
	
	public void clickOnRecordLink() {
		firstRecordLink.click();
		super.waitForSleep(4000);
	}
	
		
	public void clickOnCsanNumberLink() {
		csanNumberLink.click();
		super.waitForSleep(2000);
	}
}
