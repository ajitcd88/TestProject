package com.practice.capturefail;

import org.testng.annotations.AfterClass;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CaptureFailTest{
	
	WebDriver driver;
//	@Test(dataProvider = "LogIn", priority = 1)
//	public void f(String userName, String passrord) {
//		driver.findElement(By.id("username")).clear();
//		driver.findElement(By.id("username")).sendKeys(userName);
//		
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("password")).sendKeys(passrord);
//		
//		driver.findElement(By.xpath("/html/body/section/section/div/div/div/form/fieldset/div[4]/button")).click();
//		Assert.assertTrue("Welcome to SkillsHub", driver.getPageSource().contains("Welcome to SkillsHub"));
//		Assert.assertEquals("Welcome to SkillsHub", driver.getPageSource().contains("Welcome to SkillsHub"));
//	}
	@Test(priority = 2, retryAnalyzer=com.practice.util.ITestResult.class)
	@Parameters({"Name","Password"})
	public void login(@Optional("ajit@mobiuso.com")String Name,@Optional("tester123") String Password) throws InterruptedException{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(Name);
			
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(Password);
			
		driver.findElement(By.xpath("/html/body/section/section/div/div/div/form/fieldset/div[4]/button")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/section/header/div/nav/ul[2]/li/a")).click();
		driver.findElement(By.xpath("/html/body/section/header/div/nav/ul[2]/li/ul/li/a[5]")).click();
		driver.findElement(By.xpath("fafagaagag")).click();
//		Assert.assertEquals("Welcome to SkillsHub", driver.getPageSource().contains("Welcome to SkillsHub"));
	}

//	@DataProvider(name = "LogIn")
//	public Object[][] Login() {
//		return new Object[][] {
//				{ " ", " " },
//				{ "ajit@mobiuso.com", " " },
//				{ " ", "tester123" }
//		};
//	}

	@BeforeTest
	public void beforeTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:/Selenium_Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://skillshub.skyscape.com/authentication/signin");
		Thread.sleep(5000);	
		
	}
	@AfterMethod
	public void afterTest(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
				
			}catch(Exception e){
				System.out.println("Exception while taking screenshot"+e.getMessage());
			}
		}
		
	}
	@AfterClass
	public void afterClass(){
		System.out.println("Pass");
	}
}
