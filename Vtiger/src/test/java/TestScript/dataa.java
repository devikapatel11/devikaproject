package TestScript;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataa {
@DataProvider
public String[] sam() {
	String arr[]= {"hi","hello","bye","yuuo"};
	return arr;
}
@Test(dataProvider="sam")
public void samm(String dataaa) {
	Reporter.log(dataaa);
}

}
