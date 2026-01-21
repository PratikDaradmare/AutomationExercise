package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmPage extends BasePage {

	public OrderConfirmPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//b[normalize-space()='Order Placed!']")
	WebElement confirmMsg;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement continueButton;
	
	public void checkOrderIsConfirmed (){
		try
		{
			confirmMsg.isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("payment failed");
		}
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
}
