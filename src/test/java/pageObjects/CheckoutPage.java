package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement proceedToCheckoutButton;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement placeOrderButton;
	
	public void clickOnproceedToCheckout()
	{
		proceedToCheckoutButton.click();
	}
	
	public void clickOnPlaceOrder()
	{
		placeOrderButton.click();
	}
}
