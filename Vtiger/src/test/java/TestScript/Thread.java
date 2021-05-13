package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Thread {
	@Test(invocationCount=2,threadPoolSize=3)
	public void sample() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
    	WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.close();
		
		
	}
}
