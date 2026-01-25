package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try
		{
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
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
