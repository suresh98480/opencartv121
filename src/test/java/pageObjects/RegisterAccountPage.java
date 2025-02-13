package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		
	}
	

@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName;
@FindBy(xpath="//input[@id='input-lastname']")  WebElement txt_lastName;
@FindBy(xpath="//input[@id='input-email']") WebElement txt_eMail;
@FindBy(xpath="//input[@id='input-telephone']")  WebElement txt_telephone;
@FindBy(xpath="//input[@id='input-password']")  WebElement txt_password;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_passwordConfirm;
@FindBy(xpath="//input[@name='agree']") WebElement agree;
@FindBy(xpath="//input[@value='Continue']")  WebElement btn_continue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement txt_confirmMsg;

public void setFirstName(String fName)
{
	txt_firstName.sendKeys(fName);
}

public void setlastName(String lName)
{
	txt_lastName.sendKeys(lName);
}

public void setEmail(String email)
{
	txt_eMail.sendKeys(email);
}

public void setPhoneNumber(String number)
{
	txt_telephone.sendKeys(number);
}

public void setPassword(String pwd)
{
	txt_password.sendKeys(pwd);
}

public void setConfirmPassword(String pwd)
{
	txt_passwordConfirm.sendKeys(pwd);
}

public void setchkdpolicy()
{
	agree.click();
}

public void setbtnContinue()
{
	btn_continue.click();
}

//Your Account Has Been Created!

public String setconfirmMessage()
{
	try
	{
		return (txt_confirmMsg.getText());
	}
	catch(Exception e)
	{
		return (e.getMessage());
	}
	
	
}
	

}
