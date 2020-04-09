package com.echalan.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;
import com.echalan.utility.Screenshot;

public class LoginPage {

	public WebDriver logindriver;

	public ExtentReports loginextent = Runner.extent;
	public ExtentTest logintest = Runner.logger;

	
	  @FindBy(xpath = "//*[@id=\"popup\"]/div[2]/button") private WebElement
	  Popclose;
	  
	  @FindBy(xpath = "//*[text()='Cancel']") private WebElement Close;
	 

	@FindBy(xpath = "//input[@id='userName']")
	private WebElement Username;

	@FindBy(id = "next")
	private WebElement Next;

	@FindBy(id = "password")
	private WebElement Password;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement login;

	public LoginPage(WebDriver driver) {
		logindriver = driver;
		PageFactory.initElements(logindriver, this);
	}

	public void vaildlogin() throws InterruptedException {

		logintest = loginextent.createTest("login Method");
		logintest.log(Status.INFO, "please enter username");

		try {
			Username.clear();
			Username.sendKeys("rtorajkot03@yahoo.in");
		} catch (Exception e) {

		}

		Next.click();
		Thread.sleep(2000);
		logintest.log(Status.INFO, "please enter password");
		Thread.sleep(1000);
		Password.sendKeys("*7Blackbird");
		Thread.sleep(2000);
		login.click();
		Thread.sleep(8000);
		logintest.log(Status.INFO, "yes,you login successfully");
		

	}

	public void loginFail_Method() throws InterruptedException, IOException {

		try {
			Thread.sleep(2000);
			Popclose.click();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Close.click();

		System.out.println("login start");
		logintest = loginextent.createTest("login fail Method");
		logintest.log(Status.INFO, "please enter username");
		System.out.println("login enter user");
		Actions act = new Actions(logindriver);
		try {
			act.sendKeys(Username, "mpstate@nic.in").build().perform();
			;

		} catch (NullPointerException e) {
			Username = logindriver.findElement(By.xpath("//input[@id='userName']"));
			act.sendKeys(Username, "mpstate@nic.in").build().perform();
			;
		}
		System.out.println("login enter next");
		Next.click();
		Thread.sleep(1000);

		logintest.log(Status.FAIL, "you have enter invalid username");
		String temp = Screenshot.getScreenshot();
		logintest.fail("Invalid username or password", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		Thread.sleep(1000);

	}

}
