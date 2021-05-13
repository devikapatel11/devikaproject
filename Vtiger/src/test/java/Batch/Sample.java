package Batch;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	@Parameters("message")
	@Test
	public void batch1(String data) {
		Reporter.log(data);
		Reporter.log("test 1",true);
	}
}
