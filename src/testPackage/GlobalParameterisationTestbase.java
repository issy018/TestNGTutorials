package testPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class GlobalParameterisationTestbase {

	            public WebDriver driver = null;
	
	@Test
	public void Login() throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bamisho\\eclipse-workspace\\TestNGTutorial\\src\\testPackage\\dataDriving.properties");
		
		prop.load(fis);
		
		
		System.setProperty("Webdriver.chrome.driver","C:\\chromedriver.exe");
		
		if(prop.getProperty("browser").equals("chrome"))
			
		{
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			
			driver  = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void software()
	
	{
		System.out.println("I am the Test");
	}
	
	@AfterSuite
	public void DeInstallSoftware()
	
	{
		System.out.println("I am the Last");
	}
	
	
}
