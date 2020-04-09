package com.echalan.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.echalan.page.ChallanHistoryPage;
import com.echalan.page.HomePage;
import com.echalan.page.JobAllocationPage;
import com.echalan.page.LoginPage;
import com.echalan.page.ManageRolePage;
import com.echalan.page.ManageUserPage;
import com.echalan.page.OpenBrower;
import com.echalan.page.RtoPage;
import com.echalan.utility.Screenshot;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	public static WebDriver driver;
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlrepoter;

	@BeforeTest

	public static void Browser() throws InterruptedException, IOException {

		htmlrepoter = new ExtentHtmlReporter(".\\Report\\EchallanReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlrepoter);
		logger = extent.createTest("browser is launching");
		//fis = new FileInputStream("C:\\selenium\\Echalan\\src\\com\\echalan\\config.properties");
		//fis = new FileInputStream(".\\src\\com\\echalan\\config\\config.properties");
		config.load(fis);
		String browser = config.getProperty("browser");
		String url = config.getProperty("url");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			 
		}

		else if (browser.equals("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions options=new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);

		} else if (browser.equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No browser value is given");
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	@Test
	public void run() throws InterruptedException, IOException {

		try {
			LoginPage login = new LoginPage(driver);

		    login.loginFail_Method();
			login.vaildlogin();

			 HomePage home=new HomePage(driver);
			 home.homepage();
			/*
			 * ManageRolePage role = new ManageRolePage(); role.IntialFunction();
			 * role.RoleName(); role.Edit(); role.Edit_update();
			 */
			 ManageUserPage manage = new ManageUserPage(driver);
			 manage.userPage();

		 //JobAllocationPage job = new JobAllocationPage();
		 // job.Job_allocatemethod1();
			 
			 
			 ChallanHistoryPage challan = new ChallanHistoryPage();
			 challan .chalanPage();
			 challan.challan_history_by_date();
			 challan.challan_history_by_vehicleNO();
			 challan.challan_history_by_userID();
			 challan.challan_history_by_EmployeeID();
			 
			 OpenBrower brower = new OpenBrower(driver);
			 brower.User_Open_Browser();
			 
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Screenshot.getScreenshot();
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ",
			 ExtentColor.RED));
			//logger.fail("Invalid username or password", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			// test.fail(result.getThrowable());
			//extent.flush();
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ",
			 ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ",
			 ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void last() {
		extent.flush();
	}

}
