package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebActionUtil {
	WebDriver driver;
	public WebActionUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void movetoelementone(WebElement target){
		Actions action=new Actions(driver);
		action.moveToElement(target).perform();
	}
	public void movetoelementtwo(WebElement target,int x,int y){
		Actions action=new Actions(driver);
		action.moveToElement(target,x,y).perform();
	}
    public void movebyoffset(int x,int y){
    	Actions action=new Actions(driver);
    	action.moveByOffset(x,y).perform();
    }
    public void draganddrop(WebElement source,WebElement target){
    	Actions action=new Actions(driver);
    	action.dragAndDrop(source, target).perform();
    }
    public void draganddropby(WebElement target,int x,int y){
    	Actions action=new Actions(driver);
    	action.dragAndDropBy(target,x,y).perform();
    	
    }
}
