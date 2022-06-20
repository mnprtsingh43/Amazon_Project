package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.GuestPOM;
import poms.SRP_POM;

public class Guest_User extends base.Baseclass_amazon {
	SRP_POM search;
	GuestPOM guest;
	public Guest_User() {
		super();
	}
	
	@BeforeMethod
	public void open_browser() {
	base.Baseclass_amazon.initiation();
	search =new SRP_POM();
	guest=new GuestPOM();
	}
	
	@Test(priority=1)
	public void Guest_User_Test() throws InterruptedException {
		search.searching(prop.getProperty("Guest_item"));
		search.search_button_click();
		guest.select_item_over();
		guest.Add_item();
		guest.no_thanks();
		guest.proceed_to_checkout();
		
	}
	
	 @Test (priority=2)
	 public void Shipping_charges_underprice() throws InterruptedException {
		 base.Baseclass_amazon.logged_in_base(prop.getProperty("username"), prop.getProperty("password"));
		 search.searching(prop.getProperty("Item_less_than_35"));
		 search.search_button_click();
		 //Select item less than $35 dollar
		 guest.select_item_less();
		 guest.Add_item();
		 guest.proceed_to_checkout();
		 guest.continue_button();
		 guest.Free_ship();
		 
	 }
	 @Test(priority=3)
	 public void Shipping_charges_overprice() throws InterruptedException {
		 base.Baseclass_amazon.logged_in_base(prop.getProperty("username"), prop.getProperty("password"));
		 search.searching(prop.getProperty("item_more_than_35"));
		 search.search_button_click();
	 //Select item more than $35 dollar
		 guest.select_item_less();
		 guest.Add_item();
		 guest.proceed_to_checkout();
		 guest.continue_button();
		 guest.Free_ship();
		 
	 }
	
     @AfterMethod
     public void close_browser() {
	driver.quit();
     }

     
}
