package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndudtryUsingPOM extends BaseClass
{
	@Test(groups="Smokesuite")
	public void createOrgWithIndsTest() throws IOException
	{
		String ORGNAME=eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.readDataFromExcel("Organization", 4, 3);

		 
		 //Step3: click on Organization link
		  HomePage hp=new HomePage(driver);
		  hp.clickOnOrganizationsLink();
		  Reporter.log("Clicked on Organization link",true);


		 //Stpe4: click on create org lookup image
		  OrganizationsPage op=new OrganizationsPage(driver);
		   op.clickOnCreateOrgLookUpImg();
		   Reporter.log("Click on Create Org Looj Up Image",true);

		 //Step5: Create Organization with mandatory fields
		   
		   CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		   cnop.createNewOrganization(ORGNAME, INDUSTRY);
		   Reporter.log("Organization Created with industry",true);

	    //Step6: validate
	     OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	    String  OrgHeader=oip.getOrgHeader();
	     Assert.assertTrue(OrgHeader.contains(ORGNAME));

	     //Step9: LogOut of application
	     hp.logOutOfApp(driver);


	}
}
