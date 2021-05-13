package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.Excel;
import PomRepository.ContactPage;
import PomRepository.CreateNewContactPage;
import PomRepository.HomePage;

public class TC_6Test extends BaseTest {
	Excel excel=new Excel();
	CreateNewContactPage createnewcontactpage;
	HomePage homepage;
	ContactPage contactpage;
	@Test(groups="case6")
	public void TC_6() throws EncryptedDocumentException, IOException, InterruptedException {

		//============================================================================================================================
		//Step 3: Place the mouse cursor and click on "Contact" link

		homepage=new HomePage(driver);
		homepage.getContacts().click();
		String expectedContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedContactTitle)){
			Reporter.log("Contact list page is displayed",true);
		}else{
			Reporter.log("Contact list page is not displayed",true);
		}
		//================================================================================================================================
		//Step 4: navigate to "create new contact" page by click on "+" image

		contactpage=new ContactPage(driver);
		contactpage.getPlusImage().click();
		String expectedCreateNewContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedCreateNewContactTitle)){
			Reporter.log("create new contact page is displayed",true);
		}else{
			Reporter.log("create new contact page is not displayed",true);
		}
		//===============================================================================================================================
		//Step 5: Enter mandatory values and select assigned to "Group" as a "Support group" from dropdown and save

		createnewcontactpage=new CreateNewContactPage(driver);
		createnewcontactpage.getFirstname().sendKeys(excel.reader("./Resources/mandatory.xlsx","Sheet1",0,0));
		createnewcontactpage.getLastname().sendKeys(excel.reader("./Resources/mandatory.xlsx","Sheet1",1,0));
		createnewcontactpage.getAssigntyperadiobutton().click();
		createnewcontactpage.getDropdown().click();
		createnewcontactpage.getSupportgroup().click();
		createnewcontactpage.getButton().click();
		if(createnewcontactpage.getContactNewPageTitle().isDisplayed()) {
			Reporter.log("contact is created with below msg"+"[ CON** ] devika patel - Contact Information   Updated today Contact name should be display",true);
		}else{
			Reporter.log("contact is not created in Contact Information page",true);
		}
        
	}

}
