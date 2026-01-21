package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderConfirmPage;
import pageObjects.PaymentPage;
import testBase.BaseClass;

public class TC_006_PaymentTest extends BaseClass {

	@Test(groups={"Regression"})
	public void verifPaymentTest()
	{
		logger.info("***** Starting TC_005_PaymentTest *****");
		
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
		
		//PaymentPage
		PaymentPage pp= new PaymentPage(driver);
		
		logger.info("Verifying payment page is displayed");
		pp.paymentPageAppeared();
		
		logger.info("Filling Card details");
		pp.fillCardDetails();
		
		logger.info("Clicking on pay and confirm order button");
		pp.ClickOnPayAndConfirmOrder();
		
		//OrderConfirmPage
		OrderConfirmPage ocp= new OrderConfirmPage(driver);
		
		logger.info("Verifying order has been placed successfully");
		ocp.checkOrderIsConfirmed();
		
		logger.info("Click on continue button to continue our shopping");
		ocp.clickOnContinueButton();
		
		logger.info("***** Ending TC_005_PaymentTest *****");
		
	}
}
