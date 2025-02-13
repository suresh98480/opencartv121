package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	
public WebDriver driver;
public Logger logger;
public Properties p;
	
	//@SuppressWarnings({ "deprecation", "deprecation", "deprecation", "deprecation" })
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os , String br) throws IOException
	{
		
		//loading config file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
	/*	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("no matching browser");return;
			}
			
			driver=new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"),capabilities);
			System.setProperty("webdriver.selenium.opentelemetry.disable", "true");
		}*/
		
		
			switch(br)
			{
			case "chrome" : driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			default:System.out.println("invalid browser"); return;
			
			}
		
		
		
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));  //reading url from properties
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomEmail()
	{
		String generatedEmail=RandomStringUtils.randomAlphabetic(7);
		return (generatedEmail+"@gmail.com");
	}
	
	public String randomPwd()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return (generatedString+"@"+generatedNumber);
		
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);
	    
	    sourceFile.renameTo(targetFile);
	    
	    return targetFilePath;
	}

}
