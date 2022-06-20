package testlayer;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.YourAccount_Icon_pom;

public class YourAccountModule extends base.Baseclass_amazon {
	static YourAccount_Icon_pom yourac;
	
	public YourAccountModule() {
		super();
			
	}

	@BeforeMethod
	public void open_browser() {
	
		base.Baseclass_amazon.initiation();
		
	}
	
	
	@Test
	public void Account_module() throws InterruptedException {
		
		yourac= new YourAccount_Icon_pom();
	
	yourac.logged_in_(prop.getProperty("username"),prop.getProperty("password"));	
	Thread.sleep(2000);
	// Precondition
		
	 String Actual  = 	yourac.msg();
	 System.out.println(Actual);
   // User should be able to see their name in icon
		
		yourac.mousehovering_login();
	boolean	 Actual1    = yourac.element_displayed();
	System.out.println(Actual1);
	
	// User should be to see sublist after mouse hovering
	
	
	boolean Actual2  =  yourac.element_in_sublist_after_click();
	System.out.println(Actual2);
	
	//User should be able to click on elements after mouse hovering
	
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	yourac.click_on_icon();
	Thread.sleep(2000);
	 
	 //User should be able to click on icon and see sublist element
	
	boolean Actual3 =  yourac.your_order_title();
	System.out.println(Actual3);
	
 Assert.assertEquals(Actual, "Hello, Aman", "No title displayed");   
 Assert.assertTrue(Actual1, "Subtitle are not displaying");
 Assert.assertTrue(Actual2, "element are not intracable");
 Assert.assertTrue(Actual3, "After click sublist displayed"); 
    
    
    
   
		
		
	}
	
	
@AfterMethod
public void close() {
	driver.quit();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
