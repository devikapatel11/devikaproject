package Batch2;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo2 {
	@Test(groups="one")
	public void sample2() {
		Reporter.log("group three",true);
	}
	

}
