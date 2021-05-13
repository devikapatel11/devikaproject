package TestScript;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.Excel;
import PomRepository.ContactPage;
import PomRepository.CreateNewContactPage;
import PomRepository.HomePage;

public class TC_2Test extends BaseTest{
	Excel excel=new Excel();
	CreateNewContactPage createnewcontactpage;
	HomePage homepage;
	ContactPage contactpage;
	
	@Test
	public void TC_2() throws Exception {

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
		//================================================================================================================================
		//Step 5: Enter mandatory values and click on "Organization name" look-up image

		createnewcontactpage=new CreateNewContactPage(driver);
		createnewcontactpage.getLastname().sendKeys(excel.reader("./Resources/lastname.xlsx","Sheet1",0,0));
		createnewcontactpage.getPlusbutton().click();
		if(createnewcontactpage.getOrganization().isDisplayed()){
			Reporter.log("orgnaization page is displayed successfully",true);
		}else {
			Reporter.log("organization page is not displayed",true);
		}

		//================================================================================================================================
		//Step 6: select the existing "organization name" from the organization list page

		String parent = driver.getWindowHandle();
		createnewcontactpage.getPlusbutton().click();
		Set<String> allWid = driver.getWindowHandles();
		allWid.remove(parent);
		for(String s:allWid) {
			driver.switchTo().window(s);
			driver.findElement(By.xpath("//a[text()='vtiger']")).click();
		}
		driver.switchTo().window(parent);
		boolean value=driver.findElement(By.xpath("//input[@name='account_name']")).isDisplayed();
		if(value==true) {
			Reporter.log("organization name is displayed successfully",true);
		}else {
			Reporter.log("organization name is not displayed successfully",true);
		}

		//========================================================================================================================================
		//Step 6: Click on save button

		createnewcontactpage.getButton().click();
		if(createnewcontactpage.getCreatedContact().isEnabled()) {
			Reporter.log("Contact is created successfully",true);
		}else {
			Reporter.log("Contact is not created succcessfully",true);
		}


	}
}
