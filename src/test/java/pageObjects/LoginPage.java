package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement textPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement clkLoginButton;
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		clkLoginButton.click();
	}
}
