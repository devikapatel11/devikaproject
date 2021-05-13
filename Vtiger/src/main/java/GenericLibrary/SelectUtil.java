package GenericLibrary;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SelectUtil {
	public void selectOption(WebElement ele,String input){
		Select select=new Select(ele);
		List<WebElement> elements=select.getOptions();
		String val="0";
		if(input.equals(val)){
			select.selectByIndex(0);
		}
		for(WebElement ele1:elements){
			try{
				if(input.equals(ele1.getText())){
					select.selectByVisibleText(input);
					break;
				}if(input.equals(ele1.getAttribute("value"))){
					select.selectByValue(input);
					break;
				}
			}catch(Exception e){
				int num=Integer.parseInt(input);
				select.selectByIndex(num);
				break;
			}
		}
	}
}
