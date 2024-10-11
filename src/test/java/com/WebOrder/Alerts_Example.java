package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts_Example {
	
	WebDriver driver;
	@Test
	public void JS_Alert() {
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		String Act_Text = driver.switchTo().alert().getText();
		String Exp_Text = "I am a JS Alert";
		Assert.assertEquals(Act_Text, Exp_Text);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void JS_Confirm() {
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		String Act_Text = driver.switchTo().alert().getText();
		String Exp_Text = "I am a JS Confirm";
		Assert.assertEquals(Act_Text, Exp_Text);
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void JS_Prompt() {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	
	@BeforeTest
	public void open_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	
	@AfterTest
	public void close_browser() {
		driver.close();
	}
}
