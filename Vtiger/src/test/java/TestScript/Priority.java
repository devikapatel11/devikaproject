package TestScript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {

	@Test(priority=-1)
	public void prio() {
		Reporter.log("hi",true);
	}

	@Test(priority=1)
	public void prio1() {
		Reporter.log("hello",true);
	}

	@Test(priority=2)
	public void prio2() {
		Reporter.log("bye",true);
	}
}
