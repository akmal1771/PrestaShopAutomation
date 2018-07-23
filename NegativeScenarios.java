package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeScenarios {
	
	WebDriver dr;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		dr=new ChromeDriver();
	}
	
	// ilike it
	@Test
	public void wrongCredentialsTest() {
		dr.get("http://automationpractice.com/index.php");	
		dr.findElement(By.className("login")).click();
		
	   String email="akmalomonov@yahoo.com";
		dr.findElement(By.id("email")).sendKeys(email);
	   String password="2145akmal";	
		dr.findElement(By.id("passwd")).sendKeys(password);
		WebElement signIn=dr.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signIn.click();
		String expectedNegativeMess="Authentication failed.";
		String error=dr.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		
	    Assert.assertEquals(expectedNegativeMess,error,"Authentication failed.");
	}
	@Test
	public void invalidEmailTest() {
		dr.get("http://automationpractice.com/index.php");	
		dr.findElement(By.className("login")).click();
		
		dr.findElement(By.id("email")).sendKeys("akmla");
		dr.findElement(By.id("passwd")).sendKeys("2145akmal");
		WebElement signIn=dr.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signIn.click();
		String expectedResult="Invalid email address.";
		String result=dr.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
	   // System.out.println(error);
		Assert.assertEquals(expectedResult, result);
	
	}
	@Test 
	public void blankEmailTest() {
		dr.get("http://automationpractice.com/index.php");	
		dr.findElement(By.className("login")).click();
		
		dr.findElement(By.id("passwd")).sendKeys("akmaliddin");
		WebElement signIn=dr.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signIn.click();
		String expectedMessage="An email address required.";
		String blankError=dr.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(expectedMessage, blankError);
	}

	@Test 
	public void blankPasswordTest() {
		dr.get("http://automationpractice.com/index.php");	
		dr.findElement(By.className("login")).click();
		
		dr.findElement(By.id("email")).sendKeys("akmalomonov@yahoo.com");
		dr.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		String message="Password is required.";
		String blankPssw=dr.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
		Assert.assertEquals(message, blankPssw);
		
	}
}
