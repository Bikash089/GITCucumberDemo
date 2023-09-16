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
	}
	
	public String getProductName() {
		return driver.findElement(offerpageProductName).getText();
	}

}
