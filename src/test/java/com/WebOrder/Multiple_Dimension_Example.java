package com.WebOrder;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Multiple_Dimension_Example {
	ChromeDriver driver;
 // @Test
  public void SignOn() {
	  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();

  }
  @BeforeTest
  public void LaunchBrowser() {
	    //WebDriverManager.chromedriver().setup();
	    //ChromeOptions iPhoneOption = new ChromeOptions();
        driver = new ChromeDriver();
        Dimension d = new Dimension(430, 932);
        driver.manage().window().setSize(d);

  }

  @AfterTest
  public void CloseBrowser() {
	//	driver.quit();
  }

}
