package TestScript;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import PomRepository.ContactPage;
import PomRepository.CreateNewContactPage;
import PomRepository.HomePage;

public class TC_1Test extends BaseTest{
	CreateNewContactPage createnewcontactpage;
	HomePage homepage;
	ContactPage contactpage;

	@Test

	public void TC_1() {

		//=====================================================================================================================
		//Step3 : Place the mouse cursor and click on "contact" link
		homepage=new HomePage(driver);
		homepage.getContacts().click();
		String expectedContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedContactTitle)){
			System.out.println("Contact list page is displayed");
		}else{
			System.out.println("Contact list page is not displayed");
		}


		//=====================================================================================================================
		//Step4 : navigate to "create new contact" page by click on "+" image
		contactpage=new ContactPage(driver);
		contactpage.getPlusImage().click();
		String expectedCreateNewContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedCreateNewContactTitle)){
			System.out.println("create new contact page is displayed");
		}else{
			System.out.println("create new contact page is not displayed");
		}

		//=======================================================================================================================
		//Step5 : Create new contact without mandatory fields and save
		createnewcontactpage=new CreateNewContactPage(driver);
		createnewcontactpage.getButton().click();
		Alert alert=driver.switchTo().alert();
		String expectedErrorMessage="Last Name cannot be empty";
		if(alert.getText().equalsIgnoreCase(expectedErrorMessage)){
			System.out.println("Alert Popup is displayed with proper Error message ");
		}else{
			System.out.println("Alert Popup is not displayed with proper Error message");
		}
		alert.accept();

	}


}
