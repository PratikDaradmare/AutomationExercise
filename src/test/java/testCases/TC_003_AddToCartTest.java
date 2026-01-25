package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_AddToCartTest extends BaseClass {
	
	@Test(groups={"Regression"})
	public void verifyProductAddedToCart()
	{
		logger.info("**** Starting TC_003_AddToCartTest  ****");
		logger.debug("capturing application debug logs....");
		 
		
		//Home page
		HomePage hp=new HomePage(getDriver());
		hp.HomepageVisible();
		logger.info("clicked on myaccount link on the home page..");
				
		//Login page
		LoginPage lp=new LoginPage(getDriver());
		hp.linkOfSignupLogin(); //Login link under MyAccount
		logger.info("clicked on login link under myaccount..");
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginButton(); //Login button
		logger.info("clicked on login button..");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(getDriver());
				
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		
		logger.info("Successfully Logged in");

		//CartPage
		CartPage cp= new CartPage(getDriver());
		
		logger.info("Product is adding to the cart");
		cp.clickAddToCart();
		
		logger.info("Clicking on View Cart");
		cp.viewCart();
		
		logger.info("Verifying product is Successfully present in Cart");
		cp.verifyProductIsAddedToCart();
		
		logger.info("Product is Successfylly added in the cart");
		logger.info("**** Finished TC_003_AddToCartTest  ****");
		
	}
}
