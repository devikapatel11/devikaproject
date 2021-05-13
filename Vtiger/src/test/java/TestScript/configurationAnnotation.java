package TestScript;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class configurationAnnotation {

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("beforemethod",true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("beforeclass",true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforetest",true);
	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforesuite",true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("aftermethod",true);
	}


	@AfterClass
	public void afterClass() {
		Reporter.log("afterclass",true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("aftertest",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("aftersuite",true);
	}
    
	@Test
	public void confTest() {
		Reporter.log("test is running",true);
	}

}
