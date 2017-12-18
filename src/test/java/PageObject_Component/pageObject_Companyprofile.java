package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObject_Companyprofile {
	 
	@FindBy(xpath=".//*[@id='menusearch']/div/input")
	public WebElement MENU_SEARCH;
	
	
	@FindBy(xpath=".//*[@id='side-menu']/div[2]/main/section/app-company-profile/div/div[2]/div/h1")
	public WebElement Company_profile_checkPoint;
	
	public pageObject_Companyprofile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	public void search_menu_entry()
	{
		MENU_SEARCH.sendKeys("Company Profile");
	}

	public String Company_profile_checkPoint() {
		// TODO Auto-generated method stub
		 return Company_profile_checkPoint.getText();
		
	}
	
	

}
