package testLibs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import pages.AdverseEevntsPage;
import pages.AlertPage;
import pages.BloodTestEntryPage;
import pages.ELetterPage;
import pages.NRDBPage;
import pages.EditNRDBPatientPage;
import pages.EditParticipantsPage;
import pages.EditPatientPage;
import pages.ElementsPage;
import pages.FaxDocumentPage;
import pages.HomePage;
import pages.LocationPage;
import pages.LookupPage;
import pages.ManagePortalUserPage;
import pages.ParticipantsPage;
import pages.PatientPage;
import pages.TestResultPage;

public class BaseTest implements AppConstants {
	public static WebDriver driver;
	public static ElementsPage elementsPg;
	public static HomePage homePage;
	public static PatientPage patientPage;
	public static ELetterPage eLetterPage;
	public static ParticipantsPage participantsPage;
	public static BloodTestEntryPage bloodTestEntryPage;
	public static NRDBPage nrdbPage;
	public static EditNRDBPatientPage editNRDBPatientPage;
	public static EditParticipantsPage editParticipantsPage;
	public static EditPatientPage editPatientPage;
	public static FaxDocumentPage faxDocumentPage;
	public static AdverseEevntsPage adverseEevntsPage;
	public static LookupPage lookupPage;
	public static TestResultPage testResultPage;
	public static AlertPage alertPage;
	public static ManagePortalUserPage managePortalUserPage;
	public static LocationPage locationPage;

	
	public static String suiteName = "HLS Test Suite";
	public static String runENV;
	public static String runBrowser;
	public static String userName;
	public static String passWord;
	public static String qaUrl;
	public static String prodUrl;
	public static String uatUrl;
	public static String parentWindowHandler;
	
	Date now = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
	static String time;

	
	public String getSuiteName(final ITestContext context) {
		suiteName = context.getCurrentXmlTest().getSuite().getName();
		return suiteName;
	}
	
	@BeforeSuite
	public void getEnvParameters(final ITestContext context) {
		runBrowser = context.getCurrentXmlTest().getParameter("browser");
		if(runBrowser == null) runBrowser = "Chrome";
		userName = context.getCurrentXmlTest().getParameter("username");
		if(userName == null) userName = "w.feng@hlstherapeutics.com";
		passWord = context.getCurrentXmlTest().getParameter("password");
		if(passWord == null) passWord = "Cloud@2022";
		runENV = context.getCurrentXmlTest().getParameter("runENV");
		if(runENV == null) runENV = "UAT";
		prodUrl = context.getCurrentXmlTest().getParameter("PRODurl");
		qaUrl = context.getCurrentXmlTest().getParameter("QAurl");
		uatUrl = context.getCurrentXmlTest().getParameter("UATGurl");
		
		setUpBrowser();
		launchApplication();
		homePage = new HomePage();
		elementsPg = new ElementsPage();
		homePage.login(userName, passWord);
		parentWindowHandler = driver.getWindowHandle();
	}
	
	
	 // @AfterSuite public void afterSuite() { driver.quit(); }
	 
	
	// setup the browser driver for selenium
	public void setUpBrowser() {
		switch (baseBrowser.toUpperCase()) {

		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// open the application url
	public void launchApplication() {
		switch (runENV.toUpperCase()) {
		case "QA":
			Reporter.log("Launching url: "+ qaUrl, true);
			driver.get(qaUrl);
			break;
			
		case "PROD":
			Reporter.log("Launching url: "+ prodUrl, true);
			driver.get(prodUrl);
			break;
			
		case "UAT":
			Reporter.log("Launching url: "+ uatUrl, true);
			driver.get(uatUrl);
			break;
			
		default:
			Reporter.log("Launching url: "+ url, true);
			driver.get(url);
			
		}
	}

	
	public void tearDown() {
		//getExtentReports(BaseTest.suiteName).flush();
		driver.quit();
	}
	
	//using to check the text is showing on the page
	public boolean isTextShowing(String text) {
		if (driver.getPageSource().contains(text)) {
			return true;
		}else {
			return false;
		}
	}
	// Drop down list by Visual Text
	public void selectByVisualText(WebElement element, String text) {
		Select mySelect = new Select(element);
		mySelect.selectByVisibleText(text);
	}
	
	// Drop down list by Visual Text
	public String getDropDownListText(WebElement element) {
		Select mySelect = new Select(element);
		return mySelect.getFirstSelectedOption().getText();
	}
		
	
	// waiting a specify time for the element is available 
	@SuppressWarnings("deprecation")
	public void waitForTime(int t) {
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}
	
	// waiting for the element is clickable
	@SuppressWarnings("deprecation")
	public void waitEx(WebElement element, long t) {
		WebDriverWait wait = new WebDriverWait(driver,t);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	//sleep for waiting time
	public void waitForSleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// send text to field
	public void sendKeys(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	// accept alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	// get alert text
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}
	
	//dismiss alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	//switch to sub windows
	public void switchToSubWindow() {
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		System.out.println(subWindowHandler);
		driver.switchTo().window(subWindowHandler); // switch to popup window
	}
	
	//switch to sub windows
	public void switchToParentWindow() {
		driver.switchTo().window(parentWindowHandler);  
	}
	
	//Convert today to String with format "yyyyMMdd", "M/d/yyyy"
	public String getToday(String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String today = LocalDate.now().format(formatter);
		return today;
	}
	
	// scroll screen by pixel
	public void moveSreenDown(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String jstring = "window.scrollBy(0," + pixel +")";
		js.executeScript(jstring, "");
		waitForSleep(2000);  
	}
	
	// Scrolling down the page till the element is found	
	public void moveToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
    
	}
	
	//Click button or link in the page
	public void clickBtn(WebElement element) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(element);
		 actions.perform();
	}
	
	@Step("Check the Madantory Fields")
	public boolean madantoryFieldCheck(String labelText) {
		try {
			if (elementsPg.mandatoryField(labelText).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@Step("Click on {0} dropdown list")
	public void clickOnDropDownListBtn(String label) {
		moveToElement(elementsPg.dropDownBtn(label));
		waitForSleep(2000);
		elementsPg.dropDownBtn(label).click();
	}
	
	//click element by mouse
	public void mouseClick(WebElement element) {
		Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        mouseOverHome.perform();
	}
	
	//page down
	public void pageDown() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		waitForSleep(2000);
	}
	
	//page up
	public void pageUp() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	//mouse hover over
	public void hover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
		
	}
	
	@Step("Click on the browser's back button")
	public void browserBack() {
		driver.navigate().back();
		waitForSleep(2000);
	}
	
	//click element by JavaScript
	public void clickElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
}

