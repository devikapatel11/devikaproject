package Batch;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(GenericLibrary.ListenerImplementation.class)
public class Sample3 {
	@Test
	public void batch3() {
		Reporter.log("test 3",true);
		Assert.fail();
	}

}
