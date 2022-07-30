package step_definations;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mindtree.pageobject.LogOutObject;
import com.mindtree.pageobject.LoginPageObject;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.ConfigureData;
import com.mindtree.utilities.ExcelDataProvider;
import com.mindtree.utilities.ScreenCapture;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	public WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ConfigureData config;
	public ExcelDataProvider ex;
	BaseClass baseObject;
	public static Logger log = LogManager.getLogger(StepDefination.class);
	
	@Before
	public void setup() throws IOException {
		ex = new ExcelDataProvider();
		config = new ConfigureData();
		baseObject = new BaseClass();
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/FirstReport"+ScreenCapture.getCurrentDataTime()+".html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Mindtree");
		log.info("Initilizing all the methods");
	}

	@Given("browser is open")
	public void browser_is_open() throws IOException {

		driver = baseObject.initializeDriver( config.getUrl());
		log.info("Setting Up Browser");
	}
	
	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		test = extent.createTest("Login Page Test ", "This is test to validate login page ");
		test.log(Status.INFO, "Starting Test case");
		Thread.sleep(3000);
		LoginPageObject lo=new LoginPageObject(driver);
		lo.enterUsername( ex.getStringData("Sheet1", 0, 0));
		test.pass("Entered username");
		lo.enterPassword(ex.getStringData("Sheet1", 0, 1));
		test.pass("Entered password");
		lo.clickButton();
		test.pass("Login Successful");
		log.info("Test Executed login successful");
	}
	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		test = extent.createTest("Logout Test ", "This is test to validate logout ");
		test.log(Status.INFO, "Starting Teat case");
		Thread.sleep(2000);
		LogOutObject loo=new LogOutObject(driver);
		if(loo.clickButton(driver)) {
			test.pass("Logout Successful");
		}else {
		test.fail("Logout failed");
		}
		
		log.info("Test Executed logout successful");
	}
	
	@After(order = 1)
	public void tearDownMethod(Scenario result) throws IOException {
			if (result.isFailed()) {
				test.fail("Test failed",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.captureScreenShot(driver)).build());
				log.warn("This Test Failed captured ScreenShot");
			} else {
				test.pass("Test Passed",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.captureScreenShot(driver)).build());
				log.info("Test Passed captured ScreenShot");
			}
			baseObject.quitBrowser();
		}     
	@After(order = 0)
	public void tearD() {
		extent.flush();
	}
}
