package Scenario_Component;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.asserts.SoftAssert;
import Generic_Component.base_Class;
import PageObject_Component.pageObject_Login;

public class Primary_tests extends base_Class
  {
	SoftAssert sAssert= new SoftAssert();
    
	public void test_Case1() throws IOException, InterruptedException, SQLException
	{
	init_brower();
	pageObject_Login obj1=new pageObject_Login(driver);
	Explicit_wait(obj1.onload_check_img,10);
    System.out.println("Successfuly Landed to the login page");
	obj1.Enter_login();
	obj1.Enter_pass();
	obj1.Click_login();
	
	String title = driver.getTitle();
	System.out.println(title);
	sAssert.assertEquals(title, "Fortune Cloud");
	
	Explicit_wait(obj1.Home_screen_check, 20);
	String homescreen_text = obj1.Home_screen_check.getText();
	System.out.println(homescreen_text);
	if(homescreen_text.contains("Subscribed"))
	{
		System.out.println("successfully landed to home screen");
	
	}
	else
	{
		sAssert.fail("Failed");
		Capture_Screenshot1("tc");
	}
	obj1.Configurations();
	Explicit_wait(obj1.Check_point_configuation,10);
	String check_point = obj1.Check_point_configuation.getText();
	System.out.println(check_point);
	
	//close_browser();
	//sAssert.assertAll();
	
	
	}
  }
