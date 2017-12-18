package Generic_Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class base_Class {
    public static WebDriver driver; 
	public Properties prop;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;
	
	public void call_property_file() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Prakash\\MyWorkspace\\FortuneCloud\\sr"
				+ "c\\test\\java\\DataProvider_Component\\dataDriven.properties");
		prop.load(fis);
	}
	public void init_brower() throws IOException
	{
		call_property_file();
		if(prop.getProperty("browser").contains("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.ie.driver.", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		//driver.get("http://productsdev.idsnext.com/#/login");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	public static void Explicit_wait(WebElement ele,long T1)
	{
			WebDriverWait wait= new WebDriverWait(driver, T1);
			wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}
	
	@BeforeSuite
	public static void Report_extent()
	{
		extentreport= new ExtentReports("D:\\outputs\\reports\\"+"FortuneCloud"+".html");
	}
	public static void close_browser()
	{
		driver.close();
	}
	//screenshot
	
		public static void Capture_Screenshot1(String tc) throws IOException
		{
			Date date= new Date();
			SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
			File file= new File(df.format(date)+".jpg");
		
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("D:\\outputs\\screenshots\\"+tc+"-"+"-"+file));
			
//			String path="D:\\outputs\\screenshots\\"+"TC"+"-"+"-"+file;
//			return path;
		}
	
}
