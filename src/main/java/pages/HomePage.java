package pages;

import helpers.ConfigFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePO{

	public HomePage(WebDriver driver) {
		super(driver);
		initialise(this);
	}
	

	
	@FindBy(xpath="//main[@class= 'EggTimer-start-main']//button[text()='Start']")
	private WebElement startButton;
	
	@FindBy(xpath="//main[@class= 'EggTimer-start-main']//input[@placeholder='Enter a time']")
	private WebElement inputBox;
	

	
	public void launchEggHomePage() {
		try {
			String url = ConfigFileReader.getHomePageURL();
			driver.get(url);
			waitForPageToLoad();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 

   public boolean isEggTimerHomePageLoaded() {
		/*
		 * boolean flag = false; if(waitForPageToLoad()) { flag=
		 * waitForElementtobePresent(By.
		 * xpath("//main[@class= 'EggTimer-start-main']//button[text()='Start']")); }
		 * return flag;
		 */
	   
	   return  elem.waitForElementtobePresent(By.xpath("//main[@class= 'EggTimer-start-main']//button[text()='Start']"));
  
   }
    public void startTimer(String time) {

    	inputBox.clear();
    	inputBox.click();
    	inputBox.sendKeys(time);
    	startButton.click();
    	
    	
    }
    


  
	
	
	

	
	

	
	  

}
