package ListenerPractice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestScript.BaseTest;


public class Demo extends BaseTest{
	
	@Test
	public void TC_1Test() {
		Reporter.log("case one is running",true);
		Assert.fail();
	}

}
