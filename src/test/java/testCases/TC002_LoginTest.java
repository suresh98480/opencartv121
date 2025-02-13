package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(dataProvider="dpd")
	public void verifyLogin(String email,String password) throws InterruptedException
	{
		
		//homepage
		try
		{
		logger.info("**login test started*");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//lloginpage
		loginPage lp=new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(3000);
		
		//myaccount
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.chkMyAccountPage();
		
	    Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**finished teting**"); 
		
	
	}
	@DataProvider(name="dpd")
    Object[][] loginData()
    {
    	Object data[][]=
    		{
    				{"sureshpower546546546@gmail.com","r3hzd5w@zbhVHC"},
    				{"laxmi@yahoo.com","laxmi"},
    				{"laks@yahoo.com","laxmi"},
    				{"laks@yaho.com" ,"xyz"},
    				{"pawanoltraining@gmail.com","test@123"},
    		};
    	return data;
    }
	
}
