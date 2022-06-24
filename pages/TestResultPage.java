package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class TestResultPage extends BaseTest{
	
	private @FindBy(xpath = "//h3[text()='Patient Information']//parent::div//following-sibling::div//child::tr[1]/td[1]/div/span/input")
	WebElement patientTxt;
	
	private @FindBy(xpath = "//th[text()='Patient Status']//following::td[1]/span")
	WebElement patientStatusTxt;
	
	private @FindBy(xpath = "//th[text()='Initials']//following::td[1]/span")
	WebElement initialsTxt;
	
	private @FindBy(xpath = "//span[text()='DOB']//following::td[1]/span")
	WebElement dobTxt;
		
	private @FindBy(xpath = "//label[text()='WBC']//following::td[1]/input")
	WebElement wbcTxt;
	
	private @FindBy(xpath = "//label[text()='ANC']//following::td[1]/input")
	WebElement ancTxt;
	
	private @FindBy(xpath = "//label[text()='GRC']//following::td[1]/input")
	WebElement grcTxt;
	
	private @FindBy(xpath = "//label[text()='Blood Test Comments']//following::td[1]/textarea")
	WebElement testCommentTxt;
	
	private @FindBy(xpath = "//label[text()='Exception']//following::td[1]/input")
	WebElement exceptionCkb;
	
	private @FindBy(xpath = "//label[text()='Test Date']//following::td[1]/div/input")
	WebElement testDateTxt;
	
	private @FindBy(xpath = "//div/span[text()='Test Result Alert']/parent::div//following::div/span//child::span/img")
	WebElement testResultImg;
	
	private @FindBy(xpath = "//div[@class=\"message errorM3\"]/table/tbody/tr/td[2]/div/span")
	WebElement errorMessageTxt;
	
	private @FindBy(xpath = "//div/span[text()='Test Result Alert']/parent::div//following::div/span//child::img[@src=\"/img/msg_icons/confirm24.png\"]")
	WebElement redResultImg;
	
	private @FindBy(xpath = "//label[text()='ANC %']//following::td[1]/input")
	WebElement ancPercentTxt;
	
	private @FindBy(xpath = "//label[text()='GRC %']//following::td[1]/input")
	WebElement grcPercentTxt;
	
	private @FindBy(xpath = "//div/h1[text()='Test Result']//following-sibling::h2")
	WebElement testResultIdTxt;
	
	private @FindBy(xpath = "//label[text()='Type']//ancestor::th[1]//following-sibling::td//select")
	WebElement typeList;
	
	private @FindBy(xpath = "//TR[2]/th/a")
	WebElement resultIdLink;
	
	public TestResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Get the patient information")
	public Map<String, String> getpatientInformation() {
		Map<String, String> details = new HashMap<String, String>();
		details.put("Patient", patientTxt.getAttribute("value"));
		details.put("Initials", initialsTxt.getText());
		details.put("DOB", dobTxt.getText());
		details.put("Patient Status", patientStatusTxt.getText());
		details.put("Type", super.getDropDownListText(elementsPg.dropDownBtn("Type")));
		return details;
	}
	
	@Step("Input new test result information WBC {0}, ANC {1} GRC {2}")	
	public void newTestResult(String wbc, String anc, String ancP, String grc, String grcP, String type, String testDate, String exception, String comment) {
		wbcTxt.clear();
		if(wbc.length()>0) 
			super.sendKeys(wbcTxt, wbc);
		
		ancTxt.clear();
		if(anc.length()>0)
			super.sendKeys(ancTxt, anc);
		
		ancPercentTxt.clear();
		if(ancP.length()>0)
			super.sendKeys(ancPercentTxt, anc);
		
		grcTxt.clear();
		if(grc.length()>0)
			super.sendKeys(grcTxt, anc);
		
		grcPercentTxt.clear();
		if(grcP.length()>0)
			super.sendKeys(grcPercentTxt, grc);
		
		if(type.length()>0) {
			elementsPg.dropDownBtn("Type").click();
			elementsPg.dropDownListItem(type).click();
		}
		
		if(testDate.length()>0)
			super.sendKeys(testDateTxt, testDate);
		
		if(exception.length()>0) 
			elementsPg.inputField("Exception").click();
		
		if(comment.length()>0)
			super.sendKeys(elementsPg.textArea("Blood Test Comments"), comment);
			
		super.waitForSleep(2000);
	}
	
	
	@Step("Click On Save button")	
	public void clickOnSaveBtn() {
		elementsPg.button("Save").click();	
		super.waitForSleep(2000);
	}
	
	@Step("Click On OK button")	
	public void clickOnOKButton() {
		elementsPg.button("OK").click();	
		super.waitForSleep(2000);
	}
	
	@Step("Click On eLetter button")	
	public void clickOnELetterButton() {
		elementsPg.button("eLetter").click();	
		super.waitForSleep(2000);
	}
	
	@Step("Click On Edit button")	
	public void clickOnEditButton() {
		elementsPg.button(" Edit ").click();	
		super.waitForSleep(2000);
	}
	
	@Step("Click On Cancel button")	
	public void clickOnCancelBtn() {
		elementsPg.button("Cancel").click();		
	}
	
	@Step("Get error message on new test result page")
	public String getErroeMessage() {
		return errorMessageTxt.getText();
	}

	
	@Step("Catch the Test Result Alert image")	
	public String getTestResultImg() {
		return testResultImg.getAttribute("src");
	}
	
	@Step("Get the Test Result Alert Status")	
	public String getTestResultAlertStatus() {
		return elementsPg.testResultFormText("Test Result Alert Status").getText();
	}
	
	@Step("Get the ANC % value")	
	public String getANCPercentValue() {
		return elementsPg.testResultFormText("ANC %").getText();
	}
	
	@Step("Get the GRC % value")	
	public String getGRCPercentValue() {
		return elementsPg.testResultFormText("GRC %").getText();
	}
	
	@Step("Get the Test Result ID")	
	public String getTestResultID() {
		return testResultIdTxt.getText();
	}
	
	@Step("Click on Patient number link")	
	public void clickOnPatientLink(String patient) {
		String xp = "//tr/td[4]/a[text()='" + patient + "']";
		WebElement element = driver.findElement(By.xpath(xp));
		super.moveToElement(element);
		element.click();
		super.waitForSleep(3000);
	}
	
	public String getTestResultId() {
		return elementsPg.testResultFormText("Test Result ID").getText();
	}
	
	@Step("Get the test result values from the data table by test result id")
	public List<String> getTestResultDetails(String id) {
		List<String>  trDetails = new ArrayList<String>();
		for(int i=1; i<5; i++){
			String tr = "";
			trDetails.add(tr);
		}
		return trDetails;
	}
	
	@Step("Click on View drop down list, and select {0}")
	public void selectViewDropDownItem(String item) {
		elementsPg.dropDownBtn("View:").click();
		elementsPg.dropDownListItem(item).click();
		
	}
	
	@Step("Click on the test result id link")
	public void clickOnResultId(String id) {
	   if (id.length()>0) {
		   super.moveToElement( elementsPg.tableLink(id));
		   elementsPg.tableLink(id).click();
	   }else {
		   resultIdLink.click();
	   }
	   super.waitForSleep(2000);
   }
	
	@Step("Get the {0} from the test result details")
	public String getTestResultInformation(String label) {
		return elementsPg.testResultFormText(label).getText();
	}
	
	public String getAlertNumber() {
		String alertNumber = "";
		try {
			alertNumber = elementsPg.getTableList("Alert Number").get(0).getText();
		}catch (Exception NoSuchElementExpection) {
			alertNumber = "";
		}
		return alertNumber;
	}
}
