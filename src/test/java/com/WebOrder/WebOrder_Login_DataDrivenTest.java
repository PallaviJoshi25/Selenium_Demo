package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebOrder_Login_DataDrivenTest extends WebOrder_TestData { //inheritance
	 WebDriver driver;
  @Test	(dataProvider = "Login",priority = 1)	//annotation (for executing without main function) with priority 
  public void login_to_app(String uname,String pass) throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	  driver.manage().window().maximize(); //OPENS BROWSER 4 TIMES, SO USE SEPARATE METHOD TO OPEN A SINGLE BROWSER WITH ANNOTATION @BEFORE TEST
	  
	  Thread.sleep(4000); 
	  
	  driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(uname);
	  driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(pass);
	  driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	  Thread.sleep(2000); 
	  driver.findElement(By.linkText("Logout")).isDisplayed(); 
	  
	  driver.findElement(By.linkText("Logout")).click();
	  
	  
  }
  
  // @Test(priority = 2)	//setting priority for execution
//  public void logout() throws InterruptedException {
//	  driver.findElement(By.linkText("Logout")).click(); 
//	  driver.findElement(By.name("ctl00$MainContent$login_button")).isDisplayed();
//	  Thread.sleep(2000); 
//  }
  
  @AfterTest
  public void closebrowser() {
	  driver.quit(); //close -> current browser
		             //quit -> all the browsers
  }
  	//default time in Selenium -> 30 seconds
  
//  @BeforeTest
//  public void launch(){
//	  driver = new ChromeDriver();
//	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
//	  driver.manage().window().maximize();
 // }
  
}
