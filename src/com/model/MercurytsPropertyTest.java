package com.model;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;


import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;

import java.util.Set;


import org.openqa.selenium.By;

import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;


public class MercurytsPropertyTest 

{
	
 
 public WebDriver driver;

 Properties prop1= new Properties();

  Properties prop=new Properties();

   @BeforeSuite

  public void openBrowser() throws IOException
 
  {
	  
   FileInputStream fis1= new FileInputStream("F:\\Suvidya_data\\Java_Selenium_Practice\\MercurytsPropertiesDemo\\config.properties");
	  prop1.load(fis1);
	  
	  FileInputStream fis= new FileInputStream("F:\\Suvidya_data\\Java_Selenium_Practice\\MercurytsPropertiesDemo\\parameter.properties");
	  prop.load(fis);
	  
	  System.out.println("Chrome exefile path:"+prop1.getProperty("chromeexepath"));
	  System.out.println("IE exe file path:"+prop1.getProperty("ieexepath"));
	  System.out.println("Firefox exe file path:"+prop1.getProperty("firefoxexepath"));

	  
	  System.out.println("Browser:"+prop.getProperty("browser"));
           
	  System.out.println("URL:"+prop.getProperty("url"));

         	  System.out.println("username1:"+prop.getProperty("username"));

	          System.out.println("password1:"+prop.getProperty("password"));
         
	  System.out.println("username2:"+prop.getProperty("username2"));

         	  System.out.println("password2:"+prop.getProperty("password2"));

         	  System.out.println("invalidusername:"+prop.getProperty("invalidusernm"));
         
	  System.out.println("invalidpassword:"+prop.getProperty("invalipasswd"));


	  
	  if(prop.getProperty("browser").equalsIgnoreCase("chrome"))

         	  {
		  
                   System.out.println("Chrome browser");

             	   System.setProperty("webdriver.chrome.driver", prop1.getProperty("chromeexepath"));

		  driver = new ChromeDriver();

		  System.out.println(prop.getProperty("browser")+" "+"is successfully opened");

	          }
 
                  }
  
  
@BeforeTest

  public void enterApplicationURL()

  {

	  driver.get(prop.getProperty("url"));

  }

 
 @Test(priority=1)

  public void loginwithvalidds()
 
  {

	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));

        driver.findElement(By.xpath("//input[@name='login']")).click();

	driver.findElement(By.linkText("SIGN-OFF")).click();
        System.out.println("User1 has login into Mercury Tours application successfully");

  }
  
  
@Test(priority=2)

  public void loginwithvalidds2()
 
  {

	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("username2"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password2"));

	  driver.findElement(By.xpath("//input[@name='login']")).click();

	  driver.findElement(By.linkText("SIGN-OFF")).click();

	  System.out.println("User2 has login into Mercury Tours application successfully");

  }
  
  

@Test(priority=3)

  public void loginwithinvalidds() 

  {

	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prop.getProperty("invalidusernm"));

	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("invalipasswd"));

	  driver.findElement(By.xpath("//input[@name='login']")).click();

	  System.out.println("User3 has tried to login into Mercury Tours application");

  }
  
  
  

@BeforeMethod

  public void getAllCookies()
 
  {

	 Set<Cookie> cookies=driver.manage().getCookies();

	 for(Cookie cookie:cookies)

	 {

		 System.out.println(cookie.getName());

	 }

  }

 

 @AfterMethod
 
 public void captureScreenshot() 

  {
	 
 System.out.println("In captureScreenshot method ");

  }


 
 @BeforeClass

  public void maximizeBrowser() 

  {

	  driver.manage().window().maximize();
 
 }

  

@AfterClass

  public void deleteAllcookies()
 
 {
	
  driver.manage().deleteAllCookies();
 
 }

 
 

 @AfterTest

  public void dbConnectionclosed() 

  {
	 
 System.out.println("In dbConnectionclosed method");

  }

 

 
 @AfterSuite

  public void closeBrowser() 

  {
	  
driver.close();
  
}


}
