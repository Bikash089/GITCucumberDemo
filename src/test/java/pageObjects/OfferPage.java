package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
public WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By searchProduct = By.xpath("//input[@id='search-field']");
	private By offerpageProductName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name) {
		driver.findElement(searchProduct).sendKeys(name);
		System.out.println("offer page1");
		System.out.println("offer page2");
		System.out.println("offer page3");
	}
	
	public String getProductName() {
		return driver.findElement(offerpageProductName).getText();
	}

}
