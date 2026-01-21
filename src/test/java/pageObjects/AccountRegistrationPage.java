package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@type='text']")
	WebElement textName;
	
	@FindBy(xpath="//input[@data-qa='signup-email' and @placeholder='Email Address']")
	WebElement textEmail;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement clk_signup;
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement newAccountInfopage;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement radiogender;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement textpassword;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement selectdate;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement selectmonth;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement selectyear;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement textFirstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement textLastname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement textcompany;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement textaddress;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement textaddress2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement drpdwncountry;
	
	@FindBy(xpath="//option[@value='India']")
	WebElement selectIndia;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement textstate;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement textcity;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement textzipcode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement textmobno;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement buttonCreateAccount;
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	WebElement msgConfirmation;
	
	
	public void setName(String name)
	{
		textName.sendKeys(name);
	}
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void clickSignupButton()
	{
		clk_signup.click();
	}
	
	public void accountInfoPageVisibility()
	{
		System.out.println("Enter Account Information page is displayed: "+ newAccountInfopage.getText());
	}
	
	public void selectGender()
	{
		radiogender.click();
	}
	
	public void setPassword(String pwd)
	{
		textpassword.sendKeys(pwd);
	}
	
	public void setDOB()
	{
		WebElement selectDateinDOB=driver.findElement(By.xpath("//select[@id='days']"));
		Select selectDateOnly=new Select(selectDateinDOB);
		
		selectDateOnly.selectByVisibleText("9");
		
		WebElement selectMonthinDOB=driver.findElement(By.xpath("//select[@id='months']"));
		Select selectMonthOnly=new Select(selectMonthinDOB);
		
		selectMonthOnly.selectByVisibleText("January");
		
		WebElement selectYearinDOB=driver.findElement(By.xpath("//select[@id='years']"));
		Select selectYearOnly=new Select(selectYearinDOB);
		
		selectYearOnly.selectByVisibleText("1997");
	}
	
	public void setFirstName(String fname)
	{
		textFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		textLastname.sendKeys(lname);
	}
	
	public void setCompany(String company)
	{
		textcompany.sendKeys(company);
	}
	
	public void setAddress(String address)
	{
		textaddress.sendKeys(address);
	}
	
	public void setAddress2(String address2)
	{
		textaddress2.sendKeys(address2);
	}
	
	public void selectCountry()
	{
		WebElement drpdwnCountrysel=driver.findElement(By.xpath("//select[@id='country']"));
		Select drpdwncountry= new Select(drpdwnCountrysel);
		drpdwncountry.selectByVisibleText("India");
	}
	
	public void setState(String state)
	{
		textstate.sendKeys(state);
	}
	
	public void setCity(String city)
	{
		textcity.sendKeys(city);
	}
	
	public void setZipcode(String zipcode)
	{
		textzipcode.sendKeys(zipcode);
	}
	
	public void setMobileNo(String mobno)
	{
		textmobno.sendKeys(mobno);
	}
	
	public void clickCreateAccount()
	{
		buttonCreateAccount.click();
	}
	
	public String getConfirmationMsg() {
		try 
		{
			return (msgConfirmation.getText());
		} catch (Exception e) 
		{
			return (e.getMessage());
		}

	}
	
}
