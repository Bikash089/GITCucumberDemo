package stepDefinations;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;
	// Spring framework, EJB

	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart landing page")
	public void User_is_on_GreenCart_landing_page() throws IOException {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^user searched with Shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_Shortname_and_extracted_actual_name_of_the_product(String shortName)
			throws InterruptedException {

		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.extractActualText();
		System.out.println(testContextSetup.landingPageProductName + ": Product Name is extracted from the Home Page");

	}
	 
	 @When("Added {string} items of the selected product to cart")
	 public void Added_items_product(String quantity)
	 {
		 landingPage.incrementQuantity(Integer.parseInt(quantity));
		 landingPage.addToCart();
	 }
}
