package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	//constructor
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")WebElement register;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement login;
	
	
//Action methods

 public void clickMyAccount()
	{
	 myAccount.click();
	}

 public void clickRegister()
	{
	 register.click();
	}
 
 public void clickLogin()
 {
	 login.click(); }


}
