package helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ElementUtil {
	
	WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    List<WebElement> elementList;
    
    public String pageLoadTimeout=ConfigFileReader.get("pageLoadTimeout");
    public String defaultTimeout=ConfigFileReader.get("defaultTimeout");
    public String maxTimeout=ConfigFileReader.get("maxTimeout");

   

   

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad() {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean domReady = js.executeScript("return document.readyState").equals("complete");
		if (!domReady) {
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return (Boolean) js.executeScript("return document.readyState").equals("complete");
				}
			});

		}
	}

    public boolean waitForElementVisible(WebElement element) {
        try {
        	wait = new WebDriverWait(driver, Integer.parseInt(defaultTimeout));
        	wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception t) {
            throw t;
        }
    }
	
	public boolean waitForElementtobePresent(By locator) {
        try {
        	wait = new WebDriverWait(driver, Integer.parseInt(defaultTimeout));
        	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception t) {
            throw t;
        }
    }

    public void click(WebElement element) {
        try {
            waitForElementVisible(element);
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    


    



}
