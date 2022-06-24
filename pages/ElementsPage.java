package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class ElementsPage extends BaseTest{

	private WebElement element;

	public static List<WebElement> elementList;

	public ElementsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//This method is working for menu tab
	public WebElement tab(final String text) {
		final String prefix = "//li/a[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + text + suffix));
		return element;
	}
	
	//This method is working for locating the patient
	public WebElement locatePatient(final String patient) {
		final String prefix = "//th/a[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + patient + suffix));
		return element;
	}
	
	//This method is working for locating the link in form
	public WebElement formLink(final String label) {
		final String prefix = "//td[text()=\"";
		final String suffix = "\"]//following-sibling::td[1]/div/a";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for locating the link in table
	public WebElement tableLink(final String link) {
		final String prefix = "//a[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + link + suffix));
		return element;
	}
	
	//This method is working for locating the link in the view results list
	public WebElement viewResultLink(final String link) {
		final String prefix = "//span[text()=\"";
		final String suffix = "\"]//parent::a";
		element = driver.findElement(By.xpath(prefix + link + suffix));
		return element;
	}
	
		
	//This method is working for locating the lookup button
	public WebElement lookupButton(final String label) {
		final String prefix = "//img[contains(@title, '";
		final String suffix = " Lookup')]";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	
	//This method is working for the inputting field 
	public WebElement inputField(final String label) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//following::input[1]";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for inputting the text area
	public WebElement textArea(final String label) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//following::textarea[1]";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for locating the text (Edit)
	public WebElement editText(final String label) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//following::td[1]";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for locating the text (Form)
	public WebElement formText(final String label) {
		final String prefix = "//td[text()=\"";
		final String suffix = "\"]//following-sibling::td[1]/div";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for locating the text (Form) with help button
	public WebElement helpFormText(final String label) {
		final String prefix = "//span[text()=\"";
		final String suffix = "\"]//following::td[1]/div";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
		
	//This method is working for clicking button
	public WebElement button(final String text) {
		final String prefix = "//input[@value='";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + text + suffix));
		return element;
	}

	//This method is working for clicking check box in the form
	public WebElement checkBox(final String label) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//parent::td//following-sibling::td[1]//input";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	//This method is working for selecting drop down list button
	public WebElement dropDownBtn(final String ariaLabel) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//following::select[1]";
		element = driver.findElement(By.xpath(prefix + ariaLabel + suffix));
		return element;
	}
	
	//This method is working for selecting drop down list item with label
	public WebElement dropDownListItem(final String ariaLabel, final String item) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//following::select[1]/option[text()=\"";
		final String endfix = "\"]";
		element = driver.findElement(By.xpath(prefix + ariaLabel + suffix + item + endfix));
		return element;
	}
	
	//This method is working for selecting drop down list item
	public WebElement dropDownListItem(final String item) {
		final String prefix = "//select/option[text()=\"";
		final String endfix = "\"]";
		element = driver.findElement(By.xpath(prefix + item + endfix));
		return element;
	}
	
	//This method is working for view drop down list items
	public WebElement viewListItem(final String item) {
		final String prefix = "//select/option[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + item + suffix));
		return element;
	}
	
	//This method is working for moving to the head section (form)
	public WebElement headSectionForm(final String head) {
		final String prefix = "//td/h3[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + head + suffix));
		return element;
	}
	
	//This method is working for moving to the head section (edit)
	public WebElement headSectionEdit(final String head) {
		final String prefix = "//div/h3[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + head + suffix));
		return element;
	}

	//This method is working for locate the element in the searched result's list item as a link
	public WebElement searchListItemLink(final String linkText) {
		final String prefix = "//th/a[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + linkText + suffix));
		return element;
	}
	
	//This method is working for locate the element in the view result's list item as a link
	public WebElement viewListItemLink(final String linkText) {
		final String prefix = "//td/div/a/span[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + linkText + suffix));
		return element;
	}

	//This method is working for locate the element in Recent Items list 
	//the parameter is the item in Recent Items list
	public WebElement recentItem(final String item) {
		final String prefix = "//span[@class=\"mruText\" and text()=\"";
		final String endfix = "\"]";
		element = driver.findElement(By.xpath(prefix + item + endfix));
		return element;
	}
		
	//This method is working for locate the subsection button hiding or not style value
	//the parameters is the title of this subsection
	public WebElement styleValue(final String title) {
		final String prefix = "//h3[text()=\"";
		final String suffix = "\"]/parent::div/following-sibling::div[1]";
		element = driver.findElement(By.xpath(prefix + title + suffix));
		return element;
	}
	
	//This method is working for locate the subsection hiding button
	//the parameter is the head title of this subsection
	public WebElement hidingSubsectionBtn(final String title) {
		final String prefix = "//h3[text()=\"";
		final String suffix = "\"]//preceding::img[1]";
		element = driver.findElement(By.xpath(prefix + title + suffix));
		return element;
	}
	
	//This method is working for locate the element in list Item Pad as button
	public WebElement itemPad(final String letter) {
		final String prefix = "//span[text()=\"";
		final String suffix = "\"]";
		element = driver.findElement(By.xpath(prefix + letter + suffix));
		return element;
	}
	
	//This method is working for locate the elements in Participants and LCCs section for getting the information
	// the parameters are Type and Participant name, return the list of elements
	public List<WebElement> participantsAndLCC(final String type, final String name) {
		final String prefix = "//th[text()=\"";
		final String midfix = "\"]//parent::tr/td[text()=\"";
		final String endfix = "\"]//following-sibling::td";
		elementList = driver.findElements(By.xpath(prefix + type + midfix + name + endfix));

		return elementList;
	}
	
	//This method is working for locating the Edit element in Participants and LCCs section
	// the parameters are Type and Participant name
	public WebElement participantsAndLCCEdit(final String type, final String name) {
		final String prefix = "//th[text()=\"";
		final String midfix = "\"]//preceding-sibling::th[text()=\"";
		final String endfix = "\"]//preceding-sibling::td";
		element = driver.findElement(By.xpath(prefix + type + midfix + name + endfix));

		return element;
	}
	
	//This method is working for locating the element on test result detail form
	//the parameter is label of the field
	public WebElement testResultFormText(final String label) {
		final String prefix = "//td[text()=\"";
		final String suffix = "\"]//following-sibling::td[1]";
		element = driver.findElement(By.xpath(prefix + label + suffix));
		return element;
	}
	
	
	//This method is working for locating the mandatory fields
	public WebElement mandatoryField(String labelTxt) {
		final String prefix = "//label[text()=\"";
		final String suffix = "\"]//ancestor::td[1]//following-sibling::td/div/div";
		element = driver.findElement(By.xpath(prefix + labelTxt + suffix));
		return element;
	}

	//This method is working for locating the table list rows
	public List<WebElement> getTableList(String title) {
		final String prefix = "//th[text()=\"";
		final String suffix = "\"]//parent::tr//following-sibling::tr";
		List<WebElement> myList = driver.findElements(By.xpath(prefix + title + suffix));
		return myList;
	}
	
	//This method is working for locating the table list rows
		public List<WebElement> getIDFromTable(String title) {
			final String prefix = "//th[text()=\"";
			final String suffix = "\"]//parent::tr//following-sibling::tr/th/a";
			List<WebElement> myList = driver.findElements(By.xpath(prefix + title + suffix));
			return myList;
		}
	
}
