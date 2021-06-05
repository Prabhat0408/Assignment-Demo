package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.ConfigFileReader;
import helpers.ElementUtil;

public class BasePO {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String pageLoadTimeout=ConfigFileReader.get("pageLoadTimeout");
	protected String defaultTimeout=ConfigFileReader.get("defaultTimeout");
	protected String maxTimeout=ConfigFileReader.get("maxTimeout");
	protected ElementUtil elem;

	public BasePO(WebDriver driver) {
		this.driver = driver;
		this.elem = new ElementUtil(this.driver);
	
	}
	

	public void initialise(Object obj) {
		try {
			PageFactory.initElements(driver, obj);
			
		} catch (Exception e) {
			// StaleElementReferenceException
			e.printStackTrace();
		}
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

	
	
	
	
	}

