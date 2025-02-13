package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement txt_emailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	public void setEmail(String userName)
	{
		txt_emailAddress.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	

}
