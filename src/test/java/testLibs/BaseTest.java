package testLibs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ElementsPage;
import pages.HomePage;

public class BaseTest implements AppConstants {

	public static WebDriver driver;
	public static ElementsPage ElementsPg;
	public static HomePage homePage;
	public static String suiteName = "HLS Test Suite";
	public static String runENV;
	public static String runBrowser;
	public static String userName;
	public static String passWord;
	public static String qaUrl;
	public static String prodUrl;
	public static String uatUrl;
	
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
		homePage.login(userName, passWord);
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
	// waiting a specify time for the element is available 
	public void waitForTime(int t) {
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
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
		element.sendKeys(text);
	}
	
	// accept alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	//dismiss alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	//switch windows
	public void switchWindow() {
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    
		    waitForSleep(2000);
		}
	}
	
	//get today "MMDDYYYY"
	public String getToday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" M/d/yyyy");
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
		js.executeScript("arguments[0].scrollIntoView();", element);
    
	}
	
}

