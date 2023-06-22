package vTiger.OrganizationsTests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;


@Listeners(GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrganizationWithIndustryTest extends BaseClass
{
	@Test(dataProvider="getData")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException
	{
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		WebDriver driver=null;


	 //Step3: click on Organization link
	  HomePage hp=new HomePage(driver);
	  hp.clickOnOrganizationsLink();


	 //Stpe4: click on create org lookup image
	  OrganizationsPage op=new OrganizationsPage(driver);
	   op.clickOnCreateOrgLookUpImg();

	// Step 5: Create Organization with mandatory fields
	   CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	   cnop.createNewOrganization(ORGNAME, INDUSTRY);
	   
	   
	// Step 8: Validate
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String orgHeader = oip.getOrgHeader();
	Assert.assertTrue(orgHeader.contains(ORGNAME));

	
		}
		
		@DataProvider
		public Object[][]getData() throws EncryptedDocumentException, IOException
		{
			return eUtil.readMultipleData("DataproviderOrg");
		}

		}

