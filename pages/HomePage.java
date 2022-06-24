package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import testLibs.BaseTest;

public class HomePage extends BaseTest{
	
	private @FindBy(id = "i0116")
	WebElement emailTxt;
	
	private @FindBy(id = "idSIButton9")
	WebElement nextBtn;
	
	private @FindBy(id = "i0118")
	WebElement pwddTxt;
	
	private @FindBy(id = "idSIButton9")
	WebElement signBtn;
	
	private @FindBy(id="idTxtBx_SAOTCC_OTC")
	WebElement codeTxt;
	
	private @FindBy(id = "idSubmit_SAOTCC_Continue")
	WebElement vfyBtn;
	
	private @FindBy(xpath = "//*[@id=\"idDiv_SAOTCS_Proofs\"]/div/div")
	WebElement cellCodeBtn;
	
	private @FindBy(id="username")
	WebElement userNameTxt;
	
	private @FindBy(id="password")
	WebElement passwordTxt;
	
	private @FindBy(id="Login")
	WebElement loginBtn;
	
	private @FindBy(id="smc")
	WebElement smcTxt;
	
	private @FindBy(id="save")
	WebElement verifyBtn;
	
	private @FindBy(id="home_Tab")
	WebElement homeTab;
	
	private @FindBy(xpath = "//a[@title='Patients Tab']")
	WebElement patientsTab;
	
	private @FindBy(xpath = "//a[@title='Participants Tab']")
	WebElement participantsTab;
	
	private @FindBy(xpath = "//a[@title='Alerts Tab']")
	WebElement alertTab;
	
	private @FindBy(xpath = "//a[@title='NRDB Tab']")
	WebElement nrdbTab;
	
	private @FindBy(xpath = "//a[@title='NRDB Patients Tab']")
	WebElement nrdbPTab;
	
	private @FindBy(xpath = "//a[@title='Faxes / Documents Tab - Selected']")
	WebElement faxDocTab;
	
	private @FindBy(xpath = "//a[@title='Blood Test Entry Tab']")
	WebElement bloodTestEntryTab;
	
	private @FindBy(xpath = "//a/img[@title = 'All Tabs']")
	WebElement allTab;
	
	private @FindBy(id="phSearchInput")
	WebElement searchTxt;
	
	private @FindBy(id="searchButtonContainer")
	WebElement searchBtn;
	
	private @FindBy(id="lksrch")
	WebElement lookupSearchTxt;
	
	private @FindBy(xpath = "//tr[2]/th/a")
	WebElement searchResultLink;

	private @FindBy(id="fcf")
	WebElement viewDropDownBtn;
	
	private @FindBy(name="go")
	WebElement goBtn;
	
	private @FindBy(xpath = "//h2[text()='Recent Items']")
	WebElement recentItemTitle;
	
	private @FindBy(id="pinIndicator")
	WebElement sidebarBtn;
	
	private @FindBy(xpath = "//input[@name='view']/following-sibling::input")
	WebElement hoverEditBtn;
	
	public @FindBy(xpath = "//input[@name='view']")
	WebElement hoverViewBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
	WebElement saveBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[2]")
	WebElement saveNewBtn;
	
	private @FindBy(xpath = "//td[@id='bottomButtonRow']/input[3]")
	WebElement cancelBtn;
	
	private @FindBy(xpath = "//td/a[text()='Edit']")
	WebElement searchResultEditBtn;
	
	private @FindBy(xpath = "/html/body/div[1]/div[3]/table/tbody/tr/td[1]/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/table/tbody/tr/td")
	List<WebElement> lccInformationList;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeTab() {
		driver.navigate().refresh();
		homeTab.click();
		super.waitForSleep(2000);
		clickOnSidebarBtn();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
		super.waitForSleep(3000);
	}
	
	@Step("Input the search condiction {0} and click on search button")
	public void clickOnSearch(String text) {
		super.sendKeys(searchTxt, text);
		searchBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the edit button in the search result list")
	public void clickOnSearchResultEdit() {
		searchResultEditBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Patient tab")
	public void clickPatientTab() {
		patientsTab.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the Patient tab")
	public void clickAlertsTab() {
		alertTab.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the All tabs")
	public void clickAllTab() {
		allTab.click();
		super.waitForSleep(3000);
	}
	
	@Step("Click on the {0} tab")
	public void clickMenuTab(String tabName) {
		elementsPg.tab(tabName).click();
		super.waitForSleep(3000);
	}
	
	@Step("Click on the Participants tab")
	public void clickParticipantsTab() {
		participantsTab.click();
		super.waitForSleep(3000);
	}
	
	@Step("Click on the Fax Documents tab")
	public void clickFaxDocumentTab() {
		faxDocTab.click();
		super.waitForSleep(3000);
	}
	
	@Step("Click on the Blood Test Entry tab")
	public void clickBloodTestEntryTab() {
		bloodTestEntryTab.click();
		super.waitForSleep(3000);
	}
	
	
	public void login(String userName, String password) {
		super.sendKeys(userNameTxt, userName);
		super.sendKeys(passwordTxt, password);
		loginBtn.click();
		smcTxt.click();
		super.waitForSleep(15000);
		verifyBtn.click();
		super.waitForSleep(5000);
	}
	
	@Step("Hover over the {0} field")
	public void hoverOverLink(String label) {
		super.moveToElement(elementsPg.formLink(label));
		super.hover(elementsPg.formLink(label));
		super.waitForSleep(3000);
	}
	
	@Step("Hover over the {0} field")
	public void hoverOverRecentItem(String item) {
		super.moveToElement(elementsPg.recentItem(item));
		super.hover(elementsPg.recentItem(item));
		super.waitForSleep(3000);
	}
	
	@Step("Click on Go button")
	public void clickOnGoButton() {
		elementsPg.button("Go!").click();
		super.waitForSleep(3000);
	}
	
	@Step("Lookup search {0}")
	public void lookupSearch(String name) {
		driver.switchTo().frame("searchFrame");
		super.sendKeys(lookupSearchTxt, name);
		elementsPg.button("Go!").click();
		super.waitForSleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
	}
	
	@Step("Select the lookup search result")
	public void selectSearchResult(String name) {
		elementsPg.searchListItemLink(name).click();
		super.switchToParentWindow();
		super.waitForSleep(2000);
	}
	
	@Step("Get the information for the form fields")
	public Map<String, String> getFormText(String[] labelArray) {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<labelArray.length;i++) {
			key = labelArray[i];
		    value = elementsPg.formText(key).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the information for the form field {0}")
	public String getFormText(String label) {
		return elementsPg.formText(label).getText();
	}
	
	@Step("Move to the {0} section")
	public void moveToSectionForm(String title) {
		super.moveToElement(elementsPg.headSectionForm(title));
		super.waitForSleep(1000);
	}
	
	@Step("Move to the {0} section")
	public void moveToSectionEdit(String head) {
		super.moveToElement(elementsPg.headSectionEdit(head));
		super.waitForSleep(1000);
	}
	
	@Step("Select the {0} from the View drop down list and click on go button")
	public void selectViewListItem(String item) {
		viewDropDownBtn.click();
		super.waitForSleep(1000);
		super.moveToElement(elementsPg.viewListItem(item));
		elementsPg.viewListItem(item).click();
		goBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the name {0} in the View's result list")
	public void clickOnViewResultItemLink(String item) {
		elementsPg.itemPad(item.substring(0, 1).toUpperCase()).click();
		super.waitForSleep(2000);
		elementsPg.viewListItemLink(item).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the link {0}")
	public void clickOnTableLink(String links) {
		elementsPg.tableLink(links).click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on the link {0}")
	public void clickOnViewResultLink(String links) {
		elementsPg.viewResultLink(links).click();
		super.waitForSleep(2000);
	}
	
	public void clickOnSidebarBtn() {
		if(!recentItemTitle.isDisplayed()) {
			sidebarBtn.click();
			super.waitForSleep(1000);
		}
	}
	
	@Step("Dropdown List Item validation {1}")
	public String getDropDownListItem(String label, String value) {
		String result;
		try {
			result = elementsPg.dropDownListItem(label, value).getText();
		}catch(NoSuchElementException e) {
			result = "No such element";
		}
		return result;
	}
	
	
	@Step("Get the LCC information")
	public Map<String, String> getLCCInformation() {
		Map<String, String> details = new HashMap<String, String>();
		String key, value;
		for(int i=0;i<lccInformationList.size();i=i+2) {
			key = lccInformationList.get(i).getText();
		    value =  lccInformationList.get(i+1).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the fields {0} information")
	public Map<String, String> getFormFieldsText(String [] fields) {
		Map<String, String> details = new HashMap<String, String>();
		String value;
		for(String key : fields) {
			value =  elementsPg.formText(key).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Get the fields {0} information")
	public Map<String, String> getEditFieldsText(String [] fields) {
		Map<String, String> details = new HashMap<String, String>();
		String value;
		for(String key : fields) {
			value =  elementsPg.formText(key).getText();
			details.put(key, value);
		}
		return details;
	}
	
	@Step("Edit the {0} with {1}")
	public void editField(String label, String value) {
		super.moveToElement(elementsPg.inputField(label));
		super.sendKeys(elementsPg.inputField(label), value);
	}
	
	@Step("Click on Save Button")
	public void clickOnSaveBtn() {
		super.moveToElement(saveBtn);
		saveBtn.click();
		super.waitForSleep(2000);
	}
	
	@Step("Click on Save and New Button")
	public void clickOnSaveNewBtn() {
		super.waitEx(saveNewBtn, 10);
		saveNewBtn.click();
	}
	
	@Step("Click on Cancel Button")
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
	
	@Step("Change the {0} dropdown List's item to {1}")
	public void changeDropDownListItem(String label, String item) {
		elementsPg.dropDownBtn(label).click();
		elementsPg.dropDownListItem(item).click();
	}	
	
	@Step("Click on the link of {0}")
	public void clickOnFormLink(String label) {
		elementsPg.formLink(label).click();
		super.waitForSleep(2000);
	}
		
}
