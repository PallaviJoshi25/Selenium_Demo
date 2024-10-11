package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WebOrder_Login {
	 WebDriver driver;
  @Test	(priority = 1)	//annotation (for executing without main function) with priority 
  public void login() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	  driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	  driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	  driver.findElement(By.linkText("Logout")).isDisplayed(); 
	  
	  Thread.sleep(5000); 
	  
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
