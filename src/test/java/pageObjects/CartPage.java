package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
	WebElement headerCartButton;
	
	@FindBy(xpath="//a[normalize-space()='Blue Top']")
	WebElement productAddedToCart;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement removeFromCartButton;

	public void clickAddToCart()
	{
		addToCartButton.click();
	}
	
	public void viewCart()
	{

		headerCartButton.click();
	}
	
	public String verifyProductIsAddedToCart()
	{
		try {
			return (productAddedToCart.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}

}
