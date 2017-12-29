package PageObject_Component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObject_Companyprofile {
	 
	@FindBy(xpath=".//*[@id='menusearch']/div/input")
	public WebElement MENU_SEARCH;
	
	@FindBy(xpath=".//*[@id='side-menu']/div[2]/main/section/app-company-profile/div/div[2]/div/h1")
	public WebElement Company_profile_checkPoint;
	
	@FindBy(xpath=".//*[@id='side-menu']/div[2]/main/section/app-company-profile/di"
			+ "v/div[4]/div/div[1]/md-card/div/div/div[1]/div[1]/label[1]")
	public WebElement Group;
	
	@FindBy(xpath=".//*[@id='side-menu']/div[2]/main/section/app-company-profile/di"
			+ "v/div[4]/div/div[1]/md-card/div/div/div[1]/div[1]/label[2]")
	public WebElement Property;
	
//	@FindBy(xpath=".//*[@id='floating-button']/p")
//	public WebElement Create_Button;
	
	@FindBy(css="p.plus")
	public WebElement Create_Button;
	
	
	@FindBy(xpath=".//*[@id='side-menu']/div[2]/main/section/app-company-profile/div/div[2]/div/h1")
	public WebElement Create_company_profile_checkpoint;
	
	
	

	public pageObject_Companyprofile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	public void search_menu_entry()
	{
		MENU_SEARCH.sendKeys("Company Profile"+Keys.ENTER);
	}	

	public String Company_profile_checkPoint() 
	{
		 return Company_profile_checkPoint.getText();
	}
	public void create_company_profile()
	{
		String create_button = Create_Button.getText();
		
		System.out.println("test"+create_button);
		
		Create_Button.click();
	}

	
	
	
	
}
