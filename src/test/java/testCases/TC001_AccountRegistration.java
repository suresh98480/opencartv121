package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	
	
	@Test
	public void verifyAccountRegistration()
	{
		logger.info("****Starting  TC001_AccountRegistration *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		RegisterAccountPage rp=new RegisterAccountPage(driver);
		hp.clickMyAccount();
		logger.info("**clicked on my Account**");
		hp.clickRegister();
		logger.info("**clicked on register");
		
		
		rp.setFirstName(randomString().toUpperCase());
		rp.setlastName(randomString().toUpperCase());
		rp.setEmail(randomEmail());
		rp.setPhoneNumber(randomNumber());
		
		String givenPWd=randomPwd();
		rp.setPassword(givenPWd);
		rp.setConfirmPassword(givenPWd);
		rp.setchkdpolicy();
		logger.info("**entered all the details**");
		rp.setbtnContinue();
		logger.info("**confirming the details");
		String cnfmMsg=rp.setconfirmMessage();
		
		//Assert.assertEquals(cnfmMsg, "Your Account Has Been Created!");
		if(cnfmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
	
	
	
	

}
