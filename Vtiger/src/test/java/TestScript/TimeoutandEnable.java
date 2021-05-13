package TestScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TimeoutandEnable {
	@Test(timeOut=1)
	public void sample() {
		Reporter.log("hey",true);
	}
	
	@Test(enabled=false)
	public void sample1() {
		Reporter.log("hi",true);
	}

}
