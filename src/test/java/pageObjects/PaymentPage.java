package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Payment']")
	WebElement paymentHeading;
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement nameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardNumber;
	
	@FindBy(xpath="//input[@placeholder='ex. 311']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement expirationMonth;
	
	@FindBy(xpath="//input[@placeholder='YYYY']")
	WebElement expirationYear;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement payButton;
	
	public String paymentPageAppeared()
	{
		try
		{
			return paymentHeading.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public void fillCardDetails()
	{
		nameOnCard.sendKeys("abc xyz");
		cardNumber.sendKeys("123456789");
		cvc.sendKeys("987");
		expirationMonth.sendKeys("10");
		expirationYear.sendKeys("2027");
	}
	
	public void ClickOnPayAndConfirmOrder()
	{
		payButton.click();
	}

}
