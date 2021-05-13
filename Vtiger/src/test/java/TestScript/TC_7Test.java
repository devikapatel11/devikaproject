package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PomRepository.ContactPage;
import PomRepository.HomePage;

public class TC_7Test  extends BaseTest {
	HomePage homepage;
	ContactPage contactpage;
	@Test(groups="casetwo")
	
	public void TC_7() throws EncryptedDocumentException, IOException, InterruptedException {
		
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
		
		//==============================================================================================================================
		//Step 4: Select multiple contacts and go for mass delete
		
		contactpage=new ContactPage(driver);
		contactpage.getContactone().click();
		contactpage.getContacttwo().click();
		contactpage.getContactthree().click();
		contactpage.getContactfour().click();
		contactpage.getDeletebutton().click();
		driver.switchTo().alert().accept();
		if(contactpage.getContactone().isDisplayed()) {
			System.out.println("contact is deleted successfully");
		}else {
			System.out.println("contact is not deleted successfully");
		}
		
		
		
		
		
	}

}
