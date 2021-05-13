package TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import GenericLibrary.Excel;
import PomRepository.ContactPage;
import PomRepository.HomePage;
import PomRepository.LoginPage;

public class BaseTest {
public static WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	ContactPage createnewcontactpage;
	Excel excel;
	@Parameters("browse")
	@BeforeClass()
	public void openApplication(@Optional("chromebrowser")String browser) throws Exception {
		//=====================================================================================================================
		// pre-condition : Launching the browser
		if(browser.equalsIgnoreCase("chromebrowser")) {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefoxbrowser")){
			System.setProperty("webdriver.chrome.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		Reporter.log("Chrome is launching successfully",true);
		driver.manage().window().maximize();
		Reporter.log("Window is maximized successfully",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//======================================================================================================================
		//Step1 : navigate to CRM application
		excel=new Excel();
		String url = excel.reader("./Resources/vtiger.xlsx","sheet1",0,0);
		driver.get(url);
		String expectedLoginTitle="vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedLoginTitle)){
			Reporter.log("Login page is displayed successfully",true);
		}else{
			Reporter.log("Login page is not displayed successfully",true);
		}

	}

	@BeforeMethod()
	public void loginToApplication() throws Exception {
		String username=excel.reader("./Resources/vtiger.xlsx","sheet1",1,0);
		String password=excel.reader("./Resources/vtiger.xlsx","sheet1",2,0);
		System.out.println(username);
		System.out.println(password);
		loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String expectedHomeTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedHomeTitle)){
			Reporter.log("Homepage is displayed successfully",true);
		}else{
			Reporter.log("Homepage is not displayed successfully",true);

		}
	}
	//===========================================================================================================================
	@AfterMethod()
	public void logoutFromApplication() {
		HomePage homepage=new HomePage(driver);
		homepage.logout();
		String expectedResult="vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedResult)){
			Reporter.log("user is logged out successfully",true);
		}else{
			Reporter.log("user is not logged out",true);
		}
	}
	
	@AfterClass()
	public void CloseApp() {
		driver.quit();
	}
}


