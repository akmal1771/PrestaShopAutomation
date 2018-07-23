package com.prestashop.tests;
//comment from Nargiza
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveScenarios {

	
		
		WebDriver dr;
		@BeforeClass
		public void setup() {
			WebDriverManager.chromedriver().setup();
			dr=new ChromeDriver();
			
		}
		
		@Test
		public void loginTest() throws InterruptedException {
			dr.get("http://automationpractice.com/index.php");	
			dr.findElement(By.className("login")).click();
			Random ran=new Random();
			int r=ran.nextInt(10);
			dr.findElement(By.id("email_create")).sendKeys("akmal"+r+"@yahoo.com");
			dr.findElement(By.id("SubmitCreate")).click();
			Thread.sleep(3000);
			dr.findElement(By.xpath("//input[@id='id_gender1']")).click();
			dr.findElement(By.xpath("//input[@id='id_gender1']")).click();
			//Personal info
			dr.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("akmal");
			dr.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("mabruka");
			dr.findElement(By.xpath("//input[@name='passwd']")).sendKeys("12365478");
			dr.findElement(By.xpath("//select[@id='days']")).sendKeys("14");
			dr.findElement(By.xpath("//select[@id='months']")).sendKeys("June");
			dr.findElement(By.xpath("//select[@id='years']")).sendKeys("2002");
		    // Address info 
			//dr.findElement(By.xpath("//input[@id='firstname']")).sendKeys("akmal");
			//dr.findElement(By.xpath("//input[@id='lastname']")).sendKeys("mabruka");
			dr.findElement(By.xpath("//input[@id='company']")).sendKeys("Cybertek");
			dr.findElement(By.xpath("//input[@id='address1']")).sendKeys("415 S Oxford ave");
			dr.findElement(By.xpath("//input[@id='city']")).sendKeys("San Francisco");
			dr.findElement(By.xpath("//select[@id='id_state']")).sendKeys("California");
			dr.findElement(By.xpath("//input[@id='postcode']")).sendKeys("90020");
			dr.findElement(By.xpath("//select[@id='id_country']")).sendKeys("USA");
			dr.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("444-555-8877");
			dr.findElement(By.id("submitAccount")).click();
			dr.findElement(By.xpath("//a[@class='logout']")).click();
			// login back
			
			dr.findElement(By.xpath("//input[@id='email']")).sendKeys("akmal"+r+"@yahoo.com");
			dr.findElement(By.xpath("//input[@name='passwd']")).sendKeys("12365478");
			dr.findElement(By.id("SubmitLogin")).click();
			
			String expectedName="akmal mabruka";
			String actualName=dr.findElement(By.xpath("(//a/span)[1]")).getText();
			Assert.assertEquals(expectedName, actualName); 
			
			
			
			
			
			
		}
		

	

}
