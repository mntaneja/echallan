package com.echalan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class OpenBrower {

	public  WebDriver openbrowerdriver;
	

	public OpenBrower(WebDriver driver)
	{
		openbrowerdriver=driver;
		PageFactory.initElements(openbrowerdriver, this);
	}
	
	
							
		  public void User_Open_Browser()
		  {
			
			
			openbrowerdriver.get("F:\\NicProject\\Echalan\\Report\\EchallanReport.html");
		  }
		
		
		
	
}
