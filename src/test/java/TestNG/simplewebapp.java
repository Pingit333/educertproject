package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class simplewebapp {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);		
		driver.get("http://ec2-18-223-102-128.us-east-2.compute.amazonaws.com:8001/index.php");
		driver.manage().window().maximize();
		
	}
  @Test
  public void verifyAboutUs() throws InterruptedException {
	// TODO Auto-generated method stub
		wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.ElementToBeClickable(By.id("About Us")));	
		driver.findElement(By.id("About Us")).click();		
		if(driver.getPageSource().contains("PID-ab2-pg")) {
			String y = driver.findElement(By.id("PID-ab2-pg")).getText();
			System.out.println(y);
			Assert.assertEquals(y, "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}		
				
		Thread.sleep(2000);
		//driver.close();
  }	 
  @AfterMethod
	public void close() {
	  driver.close();
  }
}
