package TestScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class invocationCount {
	
	@Test(priority=1,invocationCount=2)
	public void sample() {
		Reporter.log("hello",true);
		
	}
	
	@Test(invocationCount=2)
	public void sample2() {
		Reporter.log("bye",true);
	}

}
