package com.echalan.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;





public class RtoPage {

	WebDriver Rtodriver;
	public ExtentReports RtoExtent = Runner.extent;
	public ExtentTest RtoTest = Runner.logger;

	@FindBy(xpath = "//a/i[text()='add']")
	private WebElement MouseHover;

	@FindBy(xpath = "//a[@class='btn-floating red']/i[@class='fa fa-building']")
	private WebElement click_ManageRTO;

	@FindBy(xpath = "//strong[@class='ng-binding']")
	private WebElement total_RTO;

	@FindBy(xpath = "//a[@id='newUser']")
	private WebElement newRTO;

	public RtoPage(WebDriver driver) {

		this.Rtodriver = driver;
		PageFactory.initElements(Rtodriver, this);
	}

	@Test
	public void RTO_page() throws InterruptedException, IOException {

		Actions act = new Actions(Rtodriver);
		act.click(MouseHover).build().perform();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(Rtodriver, 5);
		wait.until(ExpectedConditions.visibilityOf(click_ManageRTO));
		click_ManageRTO.click();
		Thread.sleep(5000);

		RtoTest = RtoExtent.createTest("RTO Page");
		RtoTest.log(Status.INFO, "You clicked on RTO page");
		String totalRto = total_RTO.getText();

		RtoTest.log(Status.INFO, "no of Rto available ------" + totalRto);

		System.out.println("total no of RTO in UP-----" + totalRto);

		RtoTest.log(Status.INFO, "please create a new RTO");
		Thread.sleep(1000);
		newRTO.click();
		Thread.sleep(3000);
		Rtodriver.findElement(By.xpath("//input[@id='rto_name']")).sendKeys("Rohit");
		Rtodriver.findElement(By.xpath("//input[@id='rtoaddress']")).sendKeys("mumbai west");
		Rtodriver.findElement(By.xpath("//input[@id='officetype']")).sendKeys("office");
		Rtodriver.findElement(By.xpath("//input[@id='atc']")).sendKeys("ro");
		Rtodriver.findElement(By.xpath("//input[@id='dtc']")).sendKeys("ro");
		Rtodriver.findElement(By.xpath("//input[@id='authotype']")).sendKeys("ro");
		Rtodriver.findElement(By.xpath("//input[@id='rtocode']")).sendKeys("UP 15");
		Rtodriver.findElement(By.xpath("//input[@id='rtorange']")).sendKeys("60");
		Rtodriver.findElement(By.xpath("//button[@name='action']")).click();
		RtoTest.log(Status.INFO, "yes,you create a new RTO successfully");

	}

}
