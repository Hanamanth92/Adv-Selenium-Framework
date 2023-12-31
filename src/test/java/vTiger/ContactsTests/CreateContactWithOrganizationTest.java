package vTiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactsPage;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrganizationsPage;

@Listeners(GenericUtilities.ListenersImplementation.class)

public class CreateContactWithOrganizationTest extends BaseClass


{
	@Test(groups="Regeessionsuite")
	public  void createContactWithOrgTest() throws IOException
	
	{
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		// Step 6: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));

		// Step 7: Navigate to Contacts link
		hp.clickOnContactsLink();

		// Step 8: click on create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLookUpImg();

		// Step 9: Create Contact
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.CreateNewContact(driver, LASTNAME, ORGNAME);

		// Step 10: Validate for Organization
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String ContactHeader = cip.getContactHeader();
	    Assert.assertTrue(ContactHeader.contains(LASTNAME));
		
	
		
	}
	
	@Test
    public void demo()
    {
    	System.out.println("This is demo");
    }

}
