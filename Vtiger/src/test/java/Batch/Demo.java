package Batch;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo {
	@DataProvider(parallel=true)
	@Test(invocationCount=5)
	public void test1() {
		Reporter.log("hello",true);
	}
}
//    @Test
//    public void test() {
//    	Reporter.log("hi",true);
//    }
//    @Test
//    public void test2() {
//    	Reporter.log("bye",true);
//    }
//}
