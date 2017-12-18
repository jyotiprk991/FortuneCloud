package PageObject_Component;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic_Component.base_Class;

public class pageObject_Login extends base_Class {

//	By onload_check_img = By.xpath(".//*[@id='side-menu']/div/main/section/app-login/div/div[2]/div/div/img");
//	By log_in = By.xpath(".//*[@id='md-input-0-input']");
//	By password = By.xpath(".//*[@id='md-input-1-input']");
//	By Login_button = By.xpath(".//*[@id='side-menu']/div/main/section/app-login/div/div[2]/div/form/div/div[3]/button");
	
	@FindBy(xpath=".//*[@id='side-menu']/div/main/section/app-login/div/div[2]/div/div/img")
	public WebElement onload_check_img;
	
	@FindBy(xpath=".//*[@id='md-input-0-input']") 
	@CacheLookup
	public WebElement log_in;
	
	@FindBy(xpath=".//*[@id='md-input-1-input']")
	public WebElement password;
	
	@FindBy(xpath=".//*[@id='side-menu']/div/main/section/app-login/div/div[2]/div/form/div/div[3]/button")
	public WebElement Login_button;
	
	@FindBy(className="subscribed-products-h1")
	public WebElement Home_screen_check;
	
	@FindBy(xpath=".//*[@id='Fortune Cloud']/div[2]/h4")
	public WebElement Fortune_Cloud;
	
	@FindBy(xpath="html/body/app-root/div/div[1]/div[1]/aside/div/ul[1]/li/button[1]")
	public WebElement Front_office_mouse;
	
	@FindBy(xpath="html/body/app-root/div/div[1]/div[1]/aside/div/ul[2]/li[4]/a/label")
	public WebElement Front_office;
	
	@FindBy(xpath="html/body/app-root/div/div[1]/div[1]/aside/div/ul[2]/li[4]/ul/li[3]/a/label/span")
	public WebElement configuration;
	
	@FindBy(xpath=".//*[@id='side-menu']/div[1]/div[2]/header/div[1]/div[2]/div[1]")
	public WebElement Check_point_configuation;
	
	
	
//	public pageObject_Login(WebDriver driver)
//	{
//		this.driver = driver;
//	}
	       //first section
			public pageObject_Login(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}	
	public void Enter_login() throws IOException
	{
		call_property_file();
		log_in.click();
		log_in.sendKeys(prop.getProperty("login"));
		
	}
	public void Enter_pass() throws IOException
	{
		call_property_file();
		password.clear();
		password.sendKeys(prop.getProperty("password"));
	}
	
	public void Click_login() throws IOException
	{
		call_property_file();
		Login_button.click();
	}
	public void Configurations() throws InterruptedException
	{	
		Fortune_Cloud.click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(Front_office_mouse).build().perform();
		Thread.sleep(1000);
		Front_office.click();
		configuration.click();
	}
	


}
