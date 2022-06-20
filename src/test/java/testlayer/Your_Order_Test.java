package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.Login_pom;
import poms.YourAccount_Icon_pom;
import poms.YourOrder_POM;

public class Your_Order_Test extends base.Baseclass_amazon{
	static YourAccount_Icon_pom account;
	static YourOrder_POM order;
	public Your_Order_Test() {
		super();
	}
	
	@BeforeMethod
	public void open_browser() throws InterruptedException {
		base.Baseclass_amazon.initiation();
		order    = new YourOrder_POM();
		account  = new YourAccount_Icon_pom();
		account.logged_in_(prop.getProperty("username"), prop.getProperty("password"));
		account.mousehovering_login();
		Thread.sleep(2000);
		
	}
	
	
	
	@Test(dataProviderClass=datasheet.Datapro.class , dataProvider="Address_data")
	public void Your_Order_Testing(String data) throws InterruptedException {
		
		
		order.order_tab_click();
		
		
		order.drop_down(data);
		boolean Actual1  = order.order_list(data);
		
		
		
	    boolean Actual2 = order.yourorder_other_tabs("Buy Again");
        order.buy_again_click();
        Thread.sleep(2000);
	    boolean Actual3 = order.buy_again_rec();
		
		boolean Actual4 = order.yourorder_other_tabs("Not Yet Shipped");
		boolean Actual5 = order.yourorder_other_tabs("Cancelled Orders");
		
	  
		
		System.out.println(Actual1);
		System.out.println(Actual2);
		System.out.println(Actual3);
		System.out.println(Actual4);
		System.out.println(Actual5);
		
		
		Assert.assertTrue(Actual1, "Not Available");
		Assert.assertTrue(Actual2, "Not Available");
		Assert.assertTrue(Actual3, "Not Available");
		Assert.assertTrue(Actual4, "Not Available");
		Assert.assertTrue(Actual5, "Not Available");
		
		
	
			}

	
   @AfterMethod
   public void closebrowser() {
	driver.quit();
	
}
	
	
}
