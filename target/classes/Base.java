package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public String url;

	
	public WebDriver initializeDriver() throws 
IOException
	{
		Properties p=new Properties();//We will define browser to be invoked in property file and based on that we will write syntax to create browser object
		FileInputStream fis=new FileInputStream("C:\\Users\\Kiran\\FrameworkLearning\\src\\main\\java\\resources\\Data.properties");//To give the property file location
		p.load(fis);
		String browserName=p.getProperty("browser");
		  url=p.getProperty("URL");
		 
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kiran\\Work\\chromedriver.exe");
			 driver=new ChromeDriver();
			 
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kiran\\Work\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Kiran\\Work\\IEDriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Implicit wait
		
		return driver;
		
	}
	
	public void screenShot(String className) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("F://"+className+"Screenshot.png"));
		
		
		
	}

}
