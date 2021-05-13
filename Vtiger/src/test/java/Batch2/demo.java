package Batch2;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo {
	
	@Parameters("message")
	@Test(groups="one")
	public void sample(String data) {
		Reporter.log(data);
		Reporter.log("group one",true);
	}
	

}
