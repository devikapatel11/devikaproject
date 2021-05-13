package TestScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test(priority=1)
	public void sample() {
		Reporter.log("hi",true);
	}
	
	@Test(priority=0,dependsOnMethods="sample")
	public void sample1() {
		Reporter.log("hello",true);
	}
	
	@Test(priority=1,dependsOnMethods="sample1")
	public void sample2() {
		Reporter.log("bye",true);
	}

}
