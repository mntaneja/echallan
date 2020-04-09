package com.echalan.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;

public class HomePage

{
     
	 public WebDriver driver;
	 public  ExtentReports homeExtent=Runner.extent;
	 public  ExtentTest hometest=Runner.logger;
	
		
		
		@FindBy(id = "vehicle_number_new")
		private WebElement enter_vehicleNo;
		
		@FindBy(id = "challan_number")
		private WebElement Enter_Challan_No;
		@FindBy (xpath= "//*[@id=\"filterPanel\"]/div[1]/div/div/div/div[2]/div[4]/div[1]/a/i")
		private WebElement Click_search;
		
		@FindBy(xpath="//i[ text()='add']")
		private WebElement add_icon;
	
		@FindBy(id="voilator_name")
		private WebElement voilator;
		
		@FindBy(id="dl_number")
		private WebElement dlno;
		@FindBy (xpath= "//*[@id=\"row0\"]/div/div[1]/div[2]")
		private WebElement Click_result;
		
		
		
		public HomePage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@Test
		public void homepage() throws InterruptedException, IOException {
			
				       
			hometest = homeExtent.createTest("Home Page");
			hometest.log(Status.INFO,"please enter vehicle no and challan no");
			try {
				 enter_vehicleNo.sendKeys("GJ36T4880");
				}
				catch(Exception e) {
					
				}
			
			Click_search.click();
			ScrollDown();
			enter_vehicleNo.clear();
			Thread.sleep(4000);
			
			ScrollUp();
			enter_vehicleNo.clear();
	        Enter_Challan_No.sendKeys("GJ5383200202122111");
	        Thread.sleep(2000);
	       
	        Click_search.click();
	        Thread.sleep(2000);
	        ScrollDown();
	        Enter_Challan_No.clear();
	        
	        ScrollUp();
	        
	        Thread.sleep(2000);
	        ScrollUp();
	        dlno.sendKeys("GJ10 20060041044");
	        Thread.sleep(2000);
		       
	        Click_search.click();
	        Thread.sleep(1000);
	        ScrollDown();
	        Thread.sleep(3000);
	        Click_result.click();
	        Thread.sleep(10000);
	       // ScrollDown();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");
	        Thread.sleep(10000);
	        
	        
	        
	        hometest.log(Status.INFO,"You got challan summary successfully");
	        Thread.sleep(2000);
		
		  Actions act=new Actions(driver);
		  act.moveToElement(add_icon).build().perform(); Thread.sleep(1000);
		 
		}
		
		
		
		
		 public  void ScrollDown() {
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0,350)", "");
			 
			 
			 
		 }
		
		
		 
		 public void ScrollUp() {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("window.scrollBy(0,-350)", "");
		}
}
		
	
	
	
	
	

