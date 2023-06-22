package vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactsPage;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleContactsWithLeadSource

{
	

	
	//Create all the objects of All objects

	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	
	@Test(dataProvider="getData")
	public void createContactTest(String LASTNAME,String LeadSourceDropdown) throws IOException
	{

		String Lastname=LASTNAME+jUtil.getRandomNumber();
		
		WebDriver driver=null;

	 /*Read all the required data*/
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");


	// Step 1: launch the browser - Run Time Polymorphism
	if (BROWSER.equalsIgnoreCase("chrome")) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(BROWSER + " --- Launched");
	} 
	else if (BROWSER.equalsIgnoreCase("firefox")) 
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println(BROWSER + " --- Launched");
	} 
	else 
	{
		System.out.println("Invalid Browser Name");
	}

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);

	// Step 2: Login to Application
	LoginPage lp=new LoginPage(driver);
	 lp.loginToApp(USERNAME, PASSWORD);
	 System.out.println("Login successfull");
	 
	 
	 HomePage hp=new HomePage(driver);
	 hp.clickOnContactsLink();
	 
	 
	 ContactsPage cp=new ContactsPage(driver);
	 cp.clickOnCreateContactsLookUpImg();
	 
	 CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
	 cncp.CreateNewContact(Lastname, LeadSourceDropdown);
	 
	 hp.logOutOfApp(driver);
}


@DataProvider
public Object[][]getData() throws EncryptedDocumentException, IOException
{
	return eUtil.readMultipleData("MulDataContacts");
}
}
