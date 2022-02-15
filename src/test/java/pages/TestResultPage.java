package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class TestResultPage extends BaseTest{
	
	private @FindBy(xpath = "//div/a/slot/span[contains(text(),'Test Results')]")
	WebElement testResultLink;
	
	private @FindBy(xpath = "//div/table/tbody/tr[1]/th/span/a[contains(text(), 'TR')]")
	WebElement firstTestResultLink;
	
	private @FindBy(xpath = "//a/div[@title='New Test Result']")
	WebElement newTestResultLink;
	
	private @FindBy(xpath = "//div/input[@name=\"WBC__c\"]")
	WebElement wbcTxt;
	
	private @FindBy(xpath = "//div/input[@name=\"ANC__c\"]")
	WebElement ancTxt;
	
	private @FindBy(xpath = "//div/input[@name='ANC_P__c']")
	WebElement ancPercentTxt;
	
	private @FindBy(xpath = "//div/input[@name=\"ANC__c\"]")
	WebElement grcPercentTxt;
	
	private @FindBy(xpath = "//div/input[@name='GRC_P__c']")
	WebElement grcTxt;
	
	private @FindBy(xpath = "//div/textarea[@name='Blood_Test_Comments__c']")
	WebElement testCommentTxt;
	
	private @FindBy(xpath = "//input[@name='Duplicate_Exception__c']")
	WebElement exceptionCkb;
	
	private @FindBy(xpath = "//slot/div[1]/div[2]/lightning-layout-item[2]/slot/lightning-input[1]/div[1]/input")
	WebElement testDateTxt;
	
	private @FindBy(xpath = "//button[@name='save']")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//button[@name='cancel']")
	WebElement cancelBtn;
	
	private @FindBy(xpath = "//button[text()='OK']")
	WebElement okBtn;
	
	private @FindBy(xpath = "//div/a[@href=\"/lightning/r/a0T0A000000FWrEUAW/view\"]")
	WebElement csanNumberLink;
	
	public TestResultPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public void clickOnTestResultLink() {
		testResultLink.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnFirstResultLink() {
		firstTestResultLink.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnNewTestResultLink() {
		newTestResultLink.click();
		super.waitForSleep(2000);
	}
	
	//input the test result information
	public void newTestResult(String testDate, String wbc, String anc, String grc) {
		super.sendKeys(testDateTxt, testDate);
		if(wbc.length()>0) 
		super.sendKeys(wbcTxt, wbc);
		if(anc.length()>0)
		super.sendKeys(ancTxt, anc);
		if(grc.length()>0)
		super.sendKeys(grcTxt, grc);
	}
	
	//save the test result
	public void clickOnSaveBtn() {
		saveBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnOkBtn() {
		okBtn.click();
		super.waitForSleep(2000);
	}
	
	public void clickOnCsanNumberLink() {
		csanNumberLink.click();
		super.waitForSleep(2000);
	}
}
