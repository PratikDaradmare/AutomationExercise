package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_005_CheckOutTest extends BaseClass{
	
	@Test(groups= {"Regression"})
	public void verifyCheckOut()
	{
		logger.info("***** Starting TC_004_CheckOutTest *****");
		
		//Home page
		HomePage hp=new HomePage(driver);
		hp.HomepageVisible();
		logger.info("clicked on myaccount link on the home page..");
				
		//Login page
		LoginPage lp=new LoginPage(driver);
		hp.linkOfSignupLogin(); //Login link under MyAccount
		logger.info("clicked on login link under myaccount..");
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginButton(); //Login button
		logger.info("clicked on login button..");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		
		logger.info("Successfully Logged in");

		//CartPage
		CartPage cp= new CartPage(driver);
		
		logger.info("Product is adding to the cart");
		cp.clickAddToCart();
		
		logger.info("Clicking on View Cart");
		cp.viewCart();
		
		logger.info("Verifying product is Successfully present in Cart");
		cp.verifyProductIsAddedToCart();
		
		//checkout page
		CheckoutPage cop= new CheckoutPage(driver);
		
		logger.info("Product id proceeding for checkout");	
		cop.clickOnproceedToCheckout();
		
		logger.info("Clicking on place order button");
		cop.clickOnPlaceOrder();
		
		logger.info("***** Ending TC_004_CheckOutTest *****");
	}
	
}
