package vTiger.Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogOutPractice extends WebDriverUtility

{

	@Test
	public void loginlogout() throws IOException
	{
		
	JavaUtility jUtil=new JavaUtility();
	 PropertyFileUtility pUtil=new PropertyFileUtility();
	 ExcelFileUtility eUtil=new ExcelFileUtility();
	 WebDriverUtility wUtil=new WebDriverUtility();
	 WebDriver driver=null;

	 /*Read all the required data*/
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	
	//Step1: launch the browser
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 System.out.println(BROWSER + "----Launched");
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 System.out.println(BROWSER + "----Launched");
			}
			else
			{
				System.out.println("Invalid browser");
			}
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);

			 //Step2: login into the application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				
				
				
				
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationsLink();
				
				hp.clickOnContactsLink();
				hp.logOutOfApp(driver);
	           
				
				
				hp.logOutOfApp(driver);
}
}
