package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txt_MyAccountPage;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;
	
	public boolean chkMyAccountPage()
	{
		try 
		{
		return(txt_MyAccountPage.isDisplayed());
		}
		catch(Exception e)
		{
		return false;
		}
     
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
	
	

}
