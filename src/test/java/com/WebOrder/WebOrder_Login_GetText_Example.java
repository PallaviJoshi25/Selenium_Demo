package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WebOrder_Login_GetText_Example {
	 WebDriver driver;
  @Test	(priority = 1)	//annotation (for executing without main function) with priority 
  public void login() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	  driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	  driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	  
	  String actVal = driver.findElement(By.tagName("h2")).getText();
	  String expVal = "List of All Orders";
	  Assert.assertEquals(actVal, expVal);
	  
	  String expTitle = "Web Orders";
	  String actTitle = driver.getTitle(); //applicable on the browser
	  Assert.assertEquals(actVal, expVal);
	  driver.findElement(By.linkText("Logout")).isDisplayed(); 
	  
	  Thread.sleep(5000); 
	  // getText() is applicable on the elements
  }
  
  @Test(priority = 2)	//setting priority for execution
  public void logout() throws InterruptedException {
	  driver.findElement(By.linkText("Logout")).click(); 
	  driver.findElement(By.name("ctl00$MainContent$login_button")).isDisplayed();
	  Thread.sleep(5000); 
  }
  
  @AfterTest
  public void closebrowser() {
	  driver.quit(); //close -> current browser
		             //quit -> all the browsers
  }
  	//default time in Selenium -> 30 seconds
}
