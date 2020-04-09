package com.echalan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.echalan.base.Runner;

public class JobAllocationPage {

	public static WebDriver Joballocationdriver=Runner.driver;
	
	
	
	
	// public static   WebDriver driver;
	@FindBy(xpath = "//*[text()='Job allocate']")
	private WebElement job_allocate;
	
	
	
	
	
	
	/*
	 * public static void Job_allocatemethod() throws InterruptedException {
	 * 
	 * Thread.sleep(4000);
	 * 
	 * Actions action = new Actions(driver); WebElement btn =
	 * driver.findElement(By.xpath("//a/i[text()='add']"));
	 * 
	 * action.moveToElement(btn).build().perform(); Thread.sleep(2000); btn.click();
	 * 
	 * Thread.sleep(1000); WebElement btn1 = driver.findElement(By.xpath (
	 * "//*[text()='Job allocate']")); btn1.click();
	 * 
	 * 
	 * 
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.id("teamName")).sendKeys("shubham");
	 * 
	 * Thread.sleep(2000);
	 * 
	 * Actions action2 =new Actions (driver); WebElement btn2=driver.findElement(By.
	 * xpath("//button[@class='dropdown-toggle ng-binding btn btn-default'] "));
	 * action2.moveToElement(btn2).build().perform(); btn2.click();
	 * Thread.sleep(2000);
	 * 
	 * Actions action3 =new Actions (driver);
	 * 
	 * WebElement
	 * btn3=driver.findElement(By.xpath("//a[contains(text(),'A R PATEL')] "));
	 * action3.moveToElement(btn3).build().perform(); btn3.click();
	 * 
	 * Thread.sleep(2000); Actions action4 =new Actions (driver); WebElement
	 * btn4=driver.findElement(By.
	 * xpath("//form[@class='ng-pristine ng-invalid ng-invalid-required']//button[@name='action'][contains(text(),'Submit')]"
	 * )); action4.moveToElement(btn4).build().perform(); btn4.click();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * 
	 * Actions action5 =new Actions (driver); WebElement
	 * btn5=driver.findElement(By.xpath("//i[@class='fa fa-paperclip']"));
	 * action5.moveToElement(btn5).build().perform(); btn5.click();
	 * 
	 * 
	 * Thread.sleep(2000);
	 * 
	 * Actions action6 =new Actions (driver); WebElement
	 * btn6=driver.findElement(By.xpath("//i[@class='fa fa-calendar-plus-o']"));
	 * action6.moveToElement(btn5).build().perform(); btn6.click();
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.id("autocomplete")).sendKeys("NOIDA");
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.id("dateTime")).sendKeys("2020/04/01 17:48");
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.id("dateTime")).sendKeys("2020/04/02 17:48");
	 * Thread.sleep(2000);
	 * 
	 * Actions action7 =new Actions (driver); WebElement
	 * btn7=driver.findElement(By.xpath("//button[@id='submit']"));
	 * action7.moveToElement(btn5).build().perform(); btn7.click();
	 * 
	 * 
	 * }
	 */
	
public static void  Job_allocatemethod1() throws InterruptedException {
		
System.out.println("helllllllll");
		Thread.sleep(2000);
		Actions action = new Actions(Joballocationdriver);
		WebElement btn = Joballocationdriver.findElement(By.xpath(" //i[contains(text(),'add')]"));
		action.moveToElement(btn).build().perform();
		Thread.sleep(1000);
		WebElement btn_0 = Joballocationdriver.findElement(By.xpath("//a[@class='btn-floating blue darken-1']/i"));
			btn_0.click();
		
		Thread.sleep(2000);

		Actions action1 = new Actions(Joballocationdriver);
		WebElement btn1 = Joballocationdriver.findElement(By.xpath(" //i[@class='fa fa-plus']"));
		action.click(btn1).build().perform();
		Thread.sleep(4000);
		btn1.click();

		Thread.sleep(2000);

		Joballocationdriver.findElement(By.id("teamName")).sendKeys("shubham");

		Thread.sleep(2000);

		Actions action2 =new Actions (Joballocationdriver);
		WebElement btn2=Joballocationdriver.findElement(By.xpath("//button[@class='dropdown-toggle ng-binding btn btn-default'] "));
		action2.moveToElement(btn2).build().perform();
		btn2.click();
		Thread.sleep(2000);


		Actions action3 =new Actions (Joballocationdriver);	 

		WebElement btn3=Joballocationdriver.findElement(By.xpath("//a[contains(text(),'A R PATEL')] "));
		action3.moveToElement(btn3).build().perform();
		btn3.click();

		Thread.sleep(2000);
		Actions action4 =new Actions (Joballocationdriver);
		WebElement btn4=Joballocationdriver.findElement(By.xpath("//form[@class='ng-pristine ng-invalid ng-invalid-required']//button[@name='action'][contains(text(),'Submit')]"));
		action4.moveToElement(btn4).build().perform();
		btn4.click();

		Thread.sleep(2000);


		Actions action5 =new Actions (Joballocationdriver);
		WebElement btn5=Joballocationdriver.findElement(By.xpath("//i[@class='fa fa-paperclip']"));
		action5.moveToElement(btn5).build().perform();
		btn5.click();


		Thread.sleep(2000);

		Actions action6 =new Actions (Joballocationdriver);
		WebElement btn6=Joballocationdriver.findElement(By.xpath("//i[@class='fa fa-calendar-plus-o']"));
		action6.moveToElement(btn5).build().perform();
		btn6.click();
		Thread.sleep(2000);

		Joballocationdriver.findElement(By.id("autocomplete")).sendKeys("NOIDA");
		Thread.sleep(2000);

		Joballocationdriver.findElement(By.id("dateTime")).sendKeys("2020/04/01 17:48");
		Thread.sleep(2000);

		Joballocationdriver.findElement(By.id("dateTime")).sendKeys("2020/04/02 17:48");
		Thread.sleep(2000);

		Actions action7 =new Actions (Joballocationdriver);
		WebElement btn7=Joballocationdriver.findElement(By.xpath("//button[@id='submit']"));
		action7.moveToElement(btn5).build().perform();
		btn7.click();


	}

	
	
	
	
	
	
	
	
	
	

}

