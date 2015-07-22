package ca.st.selenium.pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ca.st.selenium.util.PropertyLoader;
import ca.st.selenium.util.Browser;
import ca.st.selenium.webdriver.WebDriverFactory;


public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected WebDriver driver;

	protected String gridHubUrl;

	protected String baseUrl;

	protected Browser browser;
	
	protected String[] Credentials; 

	@BeforeClass
	public void init() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version")); 
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		Credentials = new String[2];
		Credentials[0] = PropertyLoader.loadProperty("user.username");
		Credentials[1] = PropertyLoader.loadProperty("user.password");
		
		driver = WebDriverFactory.getInstance(gridHubUrl, browser, Credentials[0],
				Credentials[1]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//	app = new ApplicationManager0();
			driver.get(baseUrl + "/php4dvd/");
		    WebElement usernameField = driver.findElement(By.id("username"));
			usernameField.clear();
		    usernameField.sendKeys(Credentials[0]);
		    WebElement passwordField = driver.findElement(By.name("password"));
			passwordField.clear();
		    passwordField.sendKeys(Credentials[1]);
		    driver.findElement(By.name("submit")).click();
		
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

//	@AfterMethod
//	public void setScreenshot(ITestResult result) {
//		if (!result.isSuccess()) {
//			try {
//				WebDriver returned = new Augmenter().augment(driver);
//				if (returned != null) {
//					File f = ((TakesScreenshot) returned)
//							.getScreenshotAs(OutputType.FILE);
//					try {
//						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
//								+ result.getName() + SCREENSHOT_FORMAT));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			} catch (ScreenshotException se) {
//				se.printStackTrace();
//			}
//		}
//	}
}
