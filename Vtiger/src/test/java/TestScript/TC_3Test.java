package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.Excel;
import PomRepository.ContactPage;
import PomRepository.CreateNewContactPage;
import PomRepository.HomePage;

public class TC_3Test extends BaseTest{
	Excel excel=new Excel();
	CreateNewContactPage createnewcontactpage;
	HomePage homepage;
	ContactPage contactpage;
	@Test(groups="case3")
	public void TC_3() throws EncryptedDocumentException, IOException, InterruptedException {

		//============================================================================================================================
		//Step 3: Place the mouse cursor and click on "Contact" link
		homepage=new HomePage(driver);
		homepage.getContacts().click();
		Assert.assertEquals(driver.getTitle(),"Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM","Contact list page is not displayed");
		Reporter.log("Contact list page is displayed",true);
		
//		String expectedContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
//		if(driver.getTitle().equals(expectedContactTitle)){
//			Reporter.log("Contact list page is displayed",true);
//		}else{
//			Reporter.log("Contact list page is not displayed",true);
//		}
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
		//Step 5: Enter mandatory values and click on "Choose file"

		createnewcontactpage=new CreateNewContactPage(driver);
		createnewcontactpage.getFirstname().sendKeys(excel.reader("./Resources/mandatory.xlsx","Sheet1",0,0));
		createnewcontactpage.getLastname().sendKeys(excel.reader("./Resources/mandatory.xlsx","Sheet1",1,0));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//376,215
		//333
		//1139
		Actions action=new Actions(driver);
		action.moveByOffset(344,1150).click().perform();
		//action.click().perform();

		System.out.println(createnewcontactpage.getChoosefile().getRect().getX());
		System.out.println(createnewcontactpage.getChoosefile().getRect().getY());
		System.out.println(createnewcontactpage.getChoosefile().getRect().getHeight());
		System.out.println(createnewcontactpage.getChoosefile().getRect().getWidth());
	}
	   //================================================================================================================================
       //

}
