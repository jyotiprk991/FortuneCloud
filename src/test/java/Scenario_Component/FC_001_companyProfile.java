package Scenario_Component;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject_Component.pageObject_Companyprofile;

public class FC_001_companyProfile extends Primary_tests

{
    
	@BeforeTest
	public void primary_check() throws IOException, InterruptedException, SQLException
	{
		test_Case1();
	}
	@Test(priority=1)
	public void Onload_Load_Check() throws IOException, InterruptedException
	{ 
		pageObject_Companyprofile obj2	 = new pageObject_Companyprofile(driver);
		obj2.search_menu_entry();
		Explicit_wait(obj2.Company_profile_checkPoint,10);
		WebElement group = obj2.Group;
		boolean enabled = group.isEnabled();
		sAssert.assertEquals(enabled, true);
		WebElement property = obj2.Property;
		boolean selected = property.isSelected();
		sAssert.assertEquals(selected, true);
		WebElement create_Button = obj2.Create_Button;
		boolean displayed = create_Button.isDisplayed();
		sAssert.assertEquals(displayed, true);
	
	}
	
	public void create_company_profile() throws InterruptedException
	{
        
		pageObject_Companyprofile obj3	 = new pageObject_Companyprofile(driver);
		obj3.Company_profile_checkPoint();
		Explicit_wait(obj3.Create_Button, 7);
		Thread.sleep(7000);
		obj3.create_company_profile();
		Thread.sleep(7000);
		WebElement company_profile_checkPoint = obj3.Company_profile_checkPoint;
		System.out.println(company_profile_checkPoint);
		Explicit_wait(obj3.Create_company_profile_checkpoint, 5);
	}
	@AfterTest
	public void stop_process() throws InterruptedException
	{
		close_browser();
		sAssert.assertAll();
	}

}
