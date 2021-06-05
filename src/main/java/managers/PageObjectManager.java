package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CountDownPage;
import pages.HomePage;



public class PageObjectManager {

	private WebDriver driver;
	private WebDriverWait wait;
	private HomePage homePage;
	private CountDownPage countPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	public CountDownPage getCountPage() {
		return (countPage == null) ? countPage = new CountDownPage(driver) : countPage;
	}
	
	
	
	

}
