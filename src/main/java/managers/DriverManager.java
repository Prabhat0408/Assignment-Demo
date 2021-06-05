package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import enums.DriverType;
import helpers.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	    private static DriverType driverType;
	 
	   

	    public DriverManager() throws IOException {
	        driverType = ConfigFileReader.getBrowserType();
	        System.out.println(driverType);
	    }

	    public WebDriver getDriver() throws IOException {
	        if (driver.get() == null) {
	        	intializeDriver();
	        }
	        return driver.get();
	    }

	    
	    private void intializeDriver() throws IOException {
	        switch (driverType) {
	            case CHROME:
	                WebDriverManager.chromedriver().setup();
	                ChromeOptions chromeOptions = new ChromeOptions();
	               // chromeOptions.addArguments("diable-infobard");
	                //chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	                driver.set(new ChromeDriver(chromeOptions));
	                break;
	            case FIREFOX:
	                WebDriverManager.firefoxdriver().setup();
	                FirefoxOptions firefoxOptions = new FirefoxOptions();
	                driver.set(new FirefoxDriver(firefoxOptions));
	                driver.get().manage().window().maximize();
	                break;
	        }
	    }

	  
	public void quit() {
		WebDriver currentDriver = driver.get();
		if (currentDriver != null) {
			currentDriver.quit();
			driver.set(null);
		}
	}

}
