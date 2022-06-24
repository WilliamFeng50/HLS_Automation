package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class FaxDocumentPage extends BaseTest{
	
	private @FindBy(xpath = "//input[@name='new']")
	WebElement newFaxBtn;
	
	private @FindBy(xpath = "//input[@value='Change Owner']")
	WebElement changeOwnerBtn;
	
	private @FindBy(xpath = "//input[@titlle='Refresh']")
	WebElement refreshBtn;
	
	private @FindBy(xpath = "//div/table/tbody/tr/td[4]")
	List <WebElement> documentList;
	
	private @FindBy(xpath = "//div/table/tbody/tr[1]/td[3]")
	WebElement viewBtn;
	
	private @FindBy(xpath = "//a/img[@title='Add']")
	WebElement addBtn;
	
	private @FindBy(xpath = "//a/img[@title='Remove']")
	WebElement removeBtn;
	
	private @FindBy(xpath = "//th[text()='Attachment']//following-sibling::td/a[1]")
	WebElement titleLink;
	
	public FaxDocumentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on view dropdown list, then select an item {0}")
	public void clickOnViewList(String item) {
		elementsPg.dropDownBtn("View:").click();
		elementsPg.dropDownListItem(item).click();
	}
	
	@Step("Click on continue button")
	public void clickOnContinueButton() {
		elementsPg.button("Continue").click();
	}
	
	@Step("Edit incoming information")
	public void editInformation(String status, String reason, String fromName, String fromNumber, String receivedTime) {
		if(status.length()>0) {
			elementsPg.dropDownBtn("Fax Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if(reason.length()>0) {
			elementsPg.dropDownBtn("Discard Reason").click();
			elementsPg.dropDownListItem(reason).click();
		}
		
		if (fromName.length()> 0) super.sendKeys(elementsPg.inputField("From Name"), fromName);
		if (fromNumber.length()> 0) super.sendKeys(elementsPg.inputField("From Fax Number"), fromNumber);
		if (receivedTime.length()> 0) super.sendKeys(elementsPg.inputField("Fax Received"), receivedTime);
	}
	
	@Step("Add fax category {0}")
	public void selectFaxCategory(String[] category) {
		String pre = "//label[text()='Fax Category']//following::select[2]/option[text()='";
		String xp = "";
		for(String type : category) {
			xp = pre + type + "']";
			driver.findElement(By.xpath(xp)).click();
			addBtn.click();
			xp = "";
		}
	}
	
	@Step("Remove fax category {0}")
	public void removeFaxCategory(String[] category) {
		String pre = "//label[text()='Fax Category']//following::select[3]/option[text()='";
		String xp = "";
		for(String type : category) {
			xp = pre + type + "']";
			driver.findElement(By.xpath(xp)).click();
			removeBtn.click();
			xp = "";
		}
	}
	
	@Step("Edit outbond information")
	public void editOutBoundInformation(String fromName, String fromNumber, String status, String toName, String toNumber, String id) {
		if (fromName.length()> 0) super.sendKeys(elementsPg.inputField("From Name"), fromName);
		if (fromNumber.length()> 0) super.sendKeys(elementsPg.inputField("From Fax Number"), fromNumber);
		if(status.length()>0) {
			elementsPg.dropDownBtn("Fax Status").click();
			elementsPg.dropDownListItem(status).click();
		}
		
		if (toName.length()> 0) super.sendKeys(elementsPg.inputField("To Name"), toName);
		if (toNumber.length()> 0) super.sendKeys(elementsPg.inputField("To Fax Number"), toNumber);
		if (id.length()> 0) super.sendKeys(elementsPg.inputField("Attachment Id"), id);
	}
	
	@Step("Edit transmission information")
	public void editTransmission(String sentTime, String pages, String failure) {
		if (sentTime.length()> 0) super.sendKeys(elementsPg.inputField("Fax Sent"), sentTime);
		if (pages.length()> 0) super.sendKeys(elementsPg.inputField("Number of Pages Sent"), pages);
		if (failure.length()> 0) super.sendKeys(elementsPg.inputField("Failure Count"), failure);
	}
	
	@Step("Edit system information")
	public void editSystemInformation(String error, String conga, String resent, String original) {
		if (error.length()> 0) super.sendKeys(elementsPg.inputField("Fax Error Handled"), error);
		if (conga.length()> 0) super.sendKeys(elementsPg.inputField("Generate Conga"), conga);
		if (resent.length()> 0) super.sendKeys(elementsPg.inputField("Resent Fax"), resent);
		if (original.length()> 0) super.sendKeys(elementsPg.inputField("Original Fax"), original);
	}
	
	@Step("Verify the attachments title")
	public String getAttachmentTitle() {
		homePage.moveToSectionForm("Notes & Attachments");
		return titleLink.getText();
	}
}
