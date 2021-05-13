package ListenerPractice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.IRetryAnalyserImplementation;
import TestScript.BaseTest;

public class Democlass extends BaseTest{
	
	@Test(retryAnalyzer=IRetryAnalyserImplementation.class)
	public void TC_1Test() {
		Reporter.log("TC_1 is running",true);
		Assert.fail();
	}
	

}
