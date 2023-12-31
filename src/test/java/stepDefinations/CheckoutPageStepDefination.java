package stepDefinations;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	// Spring framework, EJB

	public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage= testContextSetup.pageObjectManager.getCheckoutPage();
	}


	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo()
	{	
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());	
	}
	
	@Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_Checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException
    {
		checkoutPage.checkOutItems();
		Thread.sleep(2000);
    }
}
