package stepDefinations;



import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination {

	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	// Spring framework, EJB

	public OfferPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException, IOException {
		switchToOfferpage();

		// testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);

	
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		System.out.println(offerPageProductName + ": Product Name is extracted from the Top Deals page");

	}

	public void switchToOfferpage() throws InterruptedException {
		// testContextSetup.driver.findElement(By.linkText("Top Deals")).click();

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();

	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {

		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
