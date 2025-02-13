package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class loginDDT extends BaseClass {
  
	
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String username,String password,String res) throws InterruptedException
	{
		
		
		logger.info("**login test started*");
		
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//lloginpage
		loginPage lp=new loginPage(driver);
		lp.setEmail(username);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		
		//myaccount
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.chkMyAccountPage();
		
	    if(res.equalsIgnoreCase("valid"))
	    {
	    	if(targetpage==true)
	    	{
	    		map.clickLogout();
	    		Assert.assertTrue(true);
	    		
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    if(res.equalsIgnoreCase("invalid"))
	    {
	    	if(targetpage==true)
	    	{
	    		map.clickLogout();
	    		Assert.assertTrue(false);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	
   
   
   
   }
	
}
