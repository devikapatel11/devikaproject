package Batch2;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo1 {
	@Test(groups="two")
	public void sample1() {
		Reporter.log("group two",true);
	}
	
}
