package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement homepageDisplayed;
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement link_signuplogin;
	
	
	public void HomepageVisible()
	{
		homepageDisplayed.getText();
	}
	
	public void linkOfSignupLogin()
	{
		link_signuplogin.click();
	}
}
