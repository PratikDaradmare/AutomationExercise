package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass{
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		HomePage hp=new HomePage(getDriver());
		hp.HomepageVisible();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.linkOfSignupLogin();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(getDriver());
		
		logger.info("Providing customer details...");
		
		regpage.setName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		
		regpage.clickSignupButton();
		regpage.accountInfoPageVisibility();
		regpage.selectGender();
			
		String password=randomAlphaNumeric();
			
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		//regpage.setPrivacyPolicy();
		regpage.setDOB();
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		
		regpage.setCompany(randomString().toUpperCase());
		regpage.setAddress(randomString().toUpperCase());
		regpage.setAddress2(randomString().toUpperCase());
		
		regpage.selectCountry();
		regpage.setState(randomString());
		regpage.setCity(randomString());
		regpage.setZipcode(randomNumber());
		regpage.setMobileNo(randomNumber());
		
		regpage.clickCreateAccount();
		
		String confmsg = regpage.getConfirmationMsg();
		System.out.println("Actual message: '" + confmsg + "'"); // For debugging
		logger.info("Validating expected message..");
		
		Assert.assertEquals(confmsg, "ACCOUNT CREATED!", "Confirmation message mismatch");

		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
	}
	
	
}

