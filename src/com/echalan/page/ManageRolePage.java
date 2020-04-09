package com.echalan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ManageRolePage {
	public WebDriver driver;
	@Test
	public void IntialFunction() throws Exception {
	
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"fixed-btn\"]"))).build().perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[2]/ul/li[10]/a")).click();
	Thread.sleep(5000);
	//cross.click();
	driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[1]/section/div[1]/div/div[1]/div/div[1]/div/a/i")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("roleName")).sendKeys("Manager_5");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"newRoleForm\"]/div[1]/div[2]/div/div/div[4]/label/span")).click();
	Thread.sleep(1000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)");
	Thread.sleep(1000);
	driver.findElement(By.id("submitRole")).click();
}
	@Test

public void RoleName() throws Exception
{
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"fixed-btn\"]"))).build().perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[2]/ul/li[10]/a")).click();
	Thread.sleep(5000);
	//cross.click();
	driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[1]/section/div[1]/div/div[1]/div/div[1]/div/a/i")).click();
	Thread.sleep(1000);
	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	jse1.executeScript("window.scrollBy(0,250)");
	Thread.sleep(1000);
	driver.findElement(By.id("cancel")).click();
}

@Test
public void Edit() throws Exception
{
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"accordion3\"]/div[8]/div[1]/div/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-7\"]/div/div/div[1]/div[2]/div/a/i")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-7\"]/div/div/div[2]/div/div[1]/div[1]/input[1]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-7\"]/div/div/div[2]/div/div[1]/div[1]/input[1]")).sendKeys("manager_3");
	Thread.sleep(2000);
	
	
	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	//jse2.executeScript("window.scrollBy(0,2000)");
	//Thread.sleep(1000);
	try {
		driver.findElement(By.xpath("//*[@id=\"cancel\"]")).click();
	}
	catch(Exception e){
		//driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	
}

@Test
public void Edit_update() throws Exception
{
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"accordion3\"]/div[10]/div[1]/div/a/i")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-9\"]/div/div/div[1]/div[2]/div/a/i")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-9\"]/div/div/div[2]/div/div[1]/div[1]/input[1]")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"accordion3-9\"]/div/div/div[2]/div/div[1]/div[1]/input[1]")).sendKeys("manager_3");
	Thread.sleep(2000);
	try {
		driver.findElement(By.xpath("//*[@id=\"accordion3-9\"]/div/div/div[2]/div/div[2]/div/button")).click();
	}
	catch(Exception e){
		//driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	
}






	

}
