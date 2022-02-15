package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testLibs.BaseTest;

public class ElementsPage extends BaseTest{

	private WebDriver driver;
	private WebElement element;

	public static List<WebElement> elementList;

	public ElementsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement inputField(final String id) {

		final String prefix = "//input[contains(@id,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + id + suffix));

		return element;
	}

	public WebElement button(final String text) {

		final String prefix = "//button[text()='";
		final String suffix = "']";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public WebElement headerTitle(final String classVal) {

		final String prefix = "//h1[contains(@class,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + classVal + suffix));

		return element;
	}

	public WebElement popUpMessage(final String classVal) {

		final String prefix = "//div[contains(@class,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + classVal + suffix));

		return element;
	}

	public WebElement errorMessage(final String id) {

		final String prefix = "//span[contains(@id,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + id + suffix));

		return element;
	}

	public List<WebElement> regesteredPremisesDetails(final String text) {

		// div[div[text()='My Registered Premises']]//div[contains(@id,'pr_id')]
		// div[contains(@class,'carousel-item-active')]//div[contains(@class,'p-col')]"

		final String prefix = "//div[div[text()='";
		final String suffix = "']]//div[contains(@id,'pr_id')]//div[contains(@class,'carousel-item-active')]//div[contains(@class,'p-col')]";
		System.out.println(prefix + text + suffix);
		elementList = driver.findElements(By.xpath(prefix + text + suffix));

		return elementList;
	}

	public WebElement registeredPremiseIndividualDetail(final String id, final String item) {

		final String prefix = "//div[div[text()='";
		final String middle = "']]//div[contains(@id,'pr_id')]//div[contains(@class,'carousel-item-active')]//div[@class='";
		final String suffix = "']";
		element = driver.findElement(By.xpath(prefix + id + middle + item + suffix));

		return element;
	}

	public WebElement spanText(final String text) {

		final String prefix = "//span[text()='";
		final String suffix = "']";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public WebElement myPremiseComponentsStatus(final String text) {

		final String prefix = "//span[text()='";
		final String suffix = "']/parent::a";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public List<WebElement> myPremiseBarnInfo(final String classValue) {

		final String prefix = "//div[contains(@class,'";
		final String suffix = "')]/div[contains(@class,'header')]";

		elementList = driver.findElements(By.xpath(prefix + classValue + suffix));

		return elementList;
	}

	public WebElement barnDetails(final String text) {

		final String prefix = "//span[label[text()='";
		final String suffix = "']]/following-sibling::span";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public WebElement housingInformation(final String classValue, final String rowType, final String column) {

		if (rowType.equalsIgnoreCase("values")) {
			final String prefix = "//div[contains(@class,'";
			final String middle = "')]/div[";
			final String suffix = "]";
			System.out.println(prefix + classValue + middle + column + suffix);
			element = driver.findElement(By.xpath(prefix + classValue + middle + column + suffix));
		} else {
			final String prefix = "//div[contains(@class,'";
			final String middle = "')]/preceding-sibling::div/div[";
			final String suffix = "]";
			System.out.println(prefix + classValue + middle + column + suffix);
			element = driver.findElement(By.xpath(prefix + classValue + middle + column + suffix));

		}

		return element;

	}

	public List<WebElement> housingInfocolumnElements(final String classVal) {

		final String prefix = "//div[contains(@class,'";
		final String suffix = "')]/div";

		elementList = driver.findElements(By.xpath(prefix + classVal + suffix));

		return elementList;
	}

	public WebElement totalCapacity(final String text) {

		final String prefix = "//span[label[contains(text(),'";
		final String suffix = "')]]/following-sibling::span";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public WebElement myPremiseButtons(final String text) {

		final String prefix = "//button[span[text()='";
		final String suffix = "']]";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public WebElement dataTableCloumns(final String text) {

		final String prefix = "//thead[contains(@class,'datatable')]/tr/th[text()='";
		final String suffix = "']";

		element = driver.findElement(By.xpath(prefix + text + suffix));

		return element;
	}

	public List<WebElement> dataTableRows(final String text) {

		String prefix = "//th[text()='";
		String suffix = "']/parent::tr/parent::thead/following-sibling::tbody//tr";

		elementList = driver.findElements(By.xpath(prefix + text + suffix));

		return elementList;

	}

	public List<WebElement> dataTableRowValues(final String text, final String row) {

		String prefix = "//th[text()='";
		String middle = "']/parent::tr/parent::thead/following-sibling::tbody//tr[";
		String suffix = "]/td";

		elementList = driver.findElements(By.xpath(prefix + text + middle + row + suffix));

		return elementList;

	}

	public List<WebElement> myPremisesEntriesSpan(final String text) {

		final String prefix = "//span[contains(@class,'";
		final String suffix = "')]";

		elementList = driver.findElements(By.xpath(prefix + text + suffix));

		return elementList;
	}

	public WebElement notificationsButton(final String classVal) {

		final String prefix = "//a[contains(@class,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + classVal + suffix));

		return element;
	}

	public List<WebElement> listBoxDropDownElements(final String aria) {

		final String prefix = "//div[@aria-haspopup='";
		final String suffix = "']";

		elementList = driver.findElements(By.xpath(prefix + aria + suffix));

		return elementList;
	}
	
	public WebElement listBoxDropDown(final String aria) {

		final String prefix = "//div[@aria-haspopup='";
		final String suffix = "']";

		element = driver.findElement(By.xpath(prefix + aria + suffix));

		return element;
	}

	public WebElement listBoxDropDownItem(final String ariaLabel) {

		final String prefix = "//p-dropdownitem/li[@aria-label='";
		final String suffix = "']";

		element = driver.findElement(By.xpath(prefix + ariaLabel + suffix));

		return element;
	}
	
	public WebElement notificationTray(final String ariaLabel) {

		final String prefix = "//div[contains(@class,'";
		final String suffix = "')]";

		element = driver.findElement(By.xpath(prefix + ariaLabel + suffix));

		return element;
	}

}
