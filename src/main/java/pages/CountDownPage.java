package pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CountDownPage extends BasePO {

	

	public CountDownPage(WebDriver driver) {
		super(driver);
		initialise(this);
	}
	
	@FindBy(xpath="//*[@class='ClassicTimer']//p[@class='ClassicTimer-time']//span") private WebElement countTimer;

	public boolean isCountdownTimerPageLoaded(){

        return elem.waitForElementVisible(countTimer);

    }
	
	public String getCountDownTime() {
		return new WebDriverWait(driver,Integer.parseInt(defaultTimeout)).until(ExpectedConditions.visibilityOf(countTimer))
				.getAttribute("innerHTML");
		//System.out.println(countTimer.getAttribute("innerHTML"));
	}
	
	public int validationCounter() throws InterruptedException,UnhandledAlertException{
		Set<String> list= new HashSet<String>();
		boolean flag = false;
		String countValue=null;
		try {
		while(flag==false) {
			countValue=new WebDriverWait(driver,Integer.parseInt(defaultTimeout)).until(ExpectedConditions.visibilityOf(countTimer))
					.getAttribute("innerHTML");
			//System.out.println(countValue);
			list.add(countValue );
			  if(countValue.startsWith("Time Expired!")) { break; }
			Thread.sleep(400);
				
			}
		return list.size();
		}catch(Exception e) {
			return list.size();	
		}
		
		
			
		}
	

}


