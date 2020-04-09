package com.echalan.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.echalan.base.Runner;

public class ChallanHistoryPage {
	
	
		
		 public WebDriver driver=Runner.driver;
		 public  ExtentReports ManageExtent=Runner.extent;
		 public  ExtentTest Managetest=Runner.logger;
		 Select role;
	    
		
		@FindBy(xpath="//i[ text()='add']")
		private WebElement add_icon;
		
		@FindBy(xpath="//a[@href='http://164.100.161.91/echallan/history']")
		private WebElement challanHisory_icon;
		
		@FindBy(xpath="//a[@title='Show/Hide Filter Panel']")
		private WebElement filter_icon;
		
		@FindBy(xpath="//select[@ng-model='newFilter']")
		private WebElement challanNO_filter;
		
		@FindBy(xpath="//input[@placeholder='Enter challan number']")
		private WebElement challan_tB;
		
		@FindBy(xpath="//a[@ng-click='searchByFilters()']")
		private WebElement search; 
		
		@FindBy(xpath="//input[@id='datepicker_start']")
		private WebElement start_date;
		
		@FindBy(xpath="//input[@id='datepicker_end']")
		private WebElement End_date;
		
		@FindBy(xpath="//button[@class='xdsoft_prev']")
		private WebElement Prev_button;
		
		@FindBy(xpath="//div[@data-hour='1']")
		private WebElement hour1;
		
		@FindBy(xpath="/html/body/div[5]/div[2]/div/div[1]/div[2]")
		private WebElement hour2;
		
		@FindBy(xpath="//input[@placeholder='Enter Vehicle Number']")
		private WebElement VehicleNO_TB;
		
		
		
		 public ChallanHistoryPage(){
			 
				
		        PageFactory.initElements(driver,this);
				
		 }
		
//		public static void main(String[] args) {
//			Challan_History a=new Challan_History();
//	    	a.loginn();
//	    	a.chalanPage();
//			
//		}
		
		
		
		
		
		public void chalanPage() throws InterruptedException, IOException{
		
		  Actions act=new Actions(driver);
		 act.moveToElement(add_icon).build().perform();
		 
		    Thread.sleep(1000);
		    System.out.println("challanpage method is calling in class app ");
			challanHisory_icon.click();
			 System.out.println("challanpage method is calling in class app ");
			Thread.sleep(2000);
			filter_icon.click();
			Thread.sleep(1000);
			 role=new Select(challanNO_filter);
	        Thread.sleep(1000);
	        role.selectByVisibleText("Challan No");
	        Thread.sleep(1000);
	        
	        String chalan1=getDataFromRegExcel("Challan1");
			challan_tB.sendKeys(chalan1);
	        search.click();
	        System.out.println("one challan data is showing");
	        Thread.sleep(2000);
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        String chalan2=getDataFromRegExcel("Challan2");
			challan_tB.sendKeys(chalan2);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("second challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan3=getDataFromRegExcel("Challan3");
			challan_tB.sendKeys(chalan3);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("third challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan4=getDataFromRegExcel("Challan4");
			challan_tB.sendKeys(chalan4);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("fourth challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
	        
	        String chalan5=getDataFromRegExcel("Challan5");
			challan_tB.sendKeys(chalan5);
	        search.click();
	        Thread.sleep(2000);
	        System.out.println("fifth challan data is showing");
	        filter_icon.click();
	        Thread.sleep(1000);
	        challan_tB.clear();
		}
	        public void challan_history_by_date() throws InterruptedException{
	   		 System.out.println("challan_history_by_date method is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	   		    role=new Select(challanNO_filter);
	            role.selectByVisibleText("Challan Date");
	            Thread.sleep(2000);
	            try{
	            start_date.click();
	            }catch(Exception e){
	            	start_date=driver.findElement(By.xpath("//input[@id='datepicker_start']"));
	            	start_date.click();
	            }
	            Thread.sleep(2000);
	            Prev_button.click();
	            Thread.sleep(2000);
	            hour1.click();
	            Thread.sleep(1000);
	            End_date.click();
	            Thread.sleep(2000);  
	            try{
	            	hour2.click();
	                }catch(Exception e){
	                	hour2=driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[1]/div[2]"));
	                	hour2.click();
	                }
	            search.click();
	        
	}
	        
	        public void challan_history_by_vehicleNO() throws InterruptedException, IOException{
	        	System.out.println("challan_history_by_vehicle number is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	   		    role=new Select(challanNO_filter);
	            role.selectByVisibleText("Vehicle Number");
	            Thread.sleep(2000);
	            String vehicleNO=getDataFromRegExcel("vehicle_no");
	            VehicleNO_TB.sendKeys(vehicleNO);
	            Thread.sleep(1000);
	            search.click();
	        }
	        
	        public void challan_history_by_userID() throws InterruptedException{
	        	System.out.println("challan_history_by_userid is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	   		    role=new Select(challanNO_filter);
	            role.selectByVisibleText("User Id");
	            Thread.sleep(2000);
	            search.click();

	        }
	        
	        public void challan_history_by_EmployeeID() throws InterruptedException{
	        	System.out.println("challan_history_by_Employee id is running ");
	        	driver.navigate().refresh();
	        	filter_icon.click();
	    		Thread.sleep(1000);
	   		    role=new Select(challanNO_filter);
	            role.selectByVisibleText("Employee Id");
	            Thread.sleep(2000);
	            search.click();
	            System.out.println("Employee-id  completed successfully");
	            Managetest = ManageExtent.createTest("ChallanHistory Page");
				Managetest.log(Status.INFO," ChallanHistory completed");
	        }
		
		public static Map<String,String> Read_RegExcel() throws IOException {
			
			Workbook bb=new XSSFWorkbook("F:\\NicProject\\Echalan\\ExcelData\\Chalan_History_data.xlsx");
			Sheet shet=bb.getSheet("Challan_History");
			Map<String,String> mp=new HashMap<String,String>();
			Row row=shet.getRow(0);
			int totalcell=row.getLastCellNum();
				for(int j=0;j<totalcell;j++) {
				String key=	shet.getRow(0).getCell(j).getStringCellValue();
				String value=shet.getRow(2).getCell(j).getStringCellValue();
				mp.put(key, value);
				}
				
			return mp;
		}
		public static String getDataFromRegExcel(String key) throws IOException {
			
			Map<String,String> data=Read_RegExcel();
			String value=data.get(key);
			return value;

		}
	}

	
	
	


