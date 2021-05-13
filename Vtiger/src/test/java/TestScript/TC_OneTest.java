package TestScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import GenericLibrary.Excel;
import GenericLibrary.TakeScreenShot;
import PomRepository.ContactPage;
import PomRepository.CreateNewContactPage;
import PomRepository.HomePage;
import PomRepository.LoginPage;

public class TC_OneTest extends BaseTest{
	public static void main(String[] args) throws EncryptedDocumentException, IOException{

		//pre-condition : Launching the browser
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Chrome is launching successfully");
		driver.manage().window().maximize();
		System.out.println("Window is maximized successfully");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Excel excel=new Excel();
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		ContactPage contactpage=new ContactPage(driver);
		CreateNewContactPage createnewcontactpage=new CreateNewContactPage(driver);



		//====================================================================================================================
		//Step1 : navigate to CRM application

		String url = excel.reader("./Resources/vtiger.xlsx","sheet1",0,0);
		driver.get(url);
		String expectedLoginTitle="vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedLoginTitle)){
			System.out.println("Login page is displayed successfully");
		}else{
			System.out.println("Login page is not displayed successfully");
		}

		//=====================================================================================================================
		//Step2 : Login to application

		String username=excel.reader("./Resources/vtiger.xlsx","sheet1",1,0);
		String password=excel.reader("./Resources/vtiger.xlsx","sheet1",2,0);
		loginpage.login(username,password);
		String expectedHomeTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedHomeTitle)){
			System.out.println("Homepage is displayed successfully");
		}else{
			System.out.println("Homepage is not displayed successfully");
		}
		TakeScreenShot takescreenshot=new TakeScreenShot();
	//	takescreenshot.getscreenshotofpage(driver);


		//=====================================================================================================================
		//Step3 : Place the mouse cursor and click on "contact" link

		homepage.getContacts().click();
		String expectedContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedContactTitle)){
			System.out.println("Contact list page is displayed");
		}else{
			System.out.println("Contact list page is not displayed");
		}


		//=====================================================================================================================
		//Step4 : navigate to "create new contact" page by click on "+" image

		contactpage.getPlusImage().click();
		String expectedCreateNewContactTitle="Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedCreateNewContactTitle)){
			System.out.println("create new contact page is displayed");
		}else{
			System.out.println("create new contact page is not displayed");
		}

		//=======================================================================================================================
		//Step5 : Create new contact without mandatory fields and save

		createnewcontactpage.getButton().click();
		Alert alert=driver.switchTo().alert();
		String expectedErrorMessage="Last Name cannot be empty";
		if(alert.getText().equals(expectedErrorMessage)){
			System.out.println("Alert Popup is displayed with proper Error message ");
		}else{
			System.out.println("Alert Popup is displayed with proper Error message");
		}
		alert.accept();
		//=======================================================================================================================
		//Step5 : Logout from the Application

		//  homepage.logout(driver);
		String expectedResult="vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedResult)){
			System.out.println("user is logged out successfully");
		}else{
			System.out.println("user is not logged out");
		}

	}

}
