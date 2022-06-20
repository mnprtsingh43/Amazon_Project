package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.YourAccount_Icon_pom;
import poms.YourOrder_POM;
import poms.Your_Addresses_POM;

public class Your_Addresses extends base.Baseclass_amazon {
	

	static YourAccount_Icon_pom account;
	static YourOrder_POM order;
	static Your_Addresses_POM address;
	public Your_Addresses() {
		super();
	}
	
	@BeforeMethod
	public void open_browser() throws InterruptedException {
		base.Baseclass_amazon.initiation();
		address    = new Your_Addresses_POM();
		order    = new YourOrder_POM();
		account  = new YourAccount_Icon_pom();
		account.logged_in_(prop.getProperty("username"), prop.getProperty("password"));
		account.mousehovering_login();
		Thread.sleep(2000);
		address.Account_click();
		
	}
	
	@Test(dataProviderClass=datasheet.Datapro.class , dataProvider="Address_data")
	public void Address_Module_Test(String Cond, String name, String Phone , String Address , String city, String Province , String postal) throws InterruptedException {
		 
		boolean con1= Cond.equals("EMP_NA");
	    boolean con2= Cond.equals("EMP_PH");
	    boolean con3= Cond.equals("EMP_ADDRS");
	    boolean con4= Cond.equals("EMP_CITY");	
	    boolean con5= Cond.equals("EMP_POST");
	    boolean con6= Cond.equals("INVALID_POST");
	    boolean con7= Cond.equals("VALID");
	    
	    
	    address.addresses_tab();
	    Thread.sleep(2000);
		address.add_address();
		Thread.sleep(2000);
		String Actual1=address.default_Country();
		
		address.Fullname(name);
		address.phonenumber(Phone);
		Thread.sleep(2000);
		address.address(Address);
		Thread.sleep(2000);
		address.city(city);
		Thread.sleep(2000);
		address.province(Province);
		Thread.sleep(2000);
		address.postalcode(postal);
		Thread.sleep(2000);
		base.Baseclass_amazon.Javaexecutor(500);
		address.default_address_checkbox();
		Thread.sleep(2000);
		address.add_address_after_info();
		
		if(con1) {
		String Actual	= address.empty_fullname_error();
		Assert.assertEquals(Actual, "Please enter a name.", "Name field can no be empty");
		}
		else if(con2)
		{
		String Actual	 = address.empty_phone();
		Assert.assertEquals(Actual, "Please enter a phone number so we can call if there are any issues with delivery.", "Field can not be empty");
			
		}
		else if(con3) {
			 String Actual   = address.empty_address_error();
			 Assert.assertEquals(Actual, "Please enter an address.", "address field can not be empty");
		}
		else if (con4) {
			String Actual= address.empty_city();
			Assert.assertEquals(Actual, "Please enter a city name.", "City can not be empty");
		}
		else if(con5) {
			String Actual=address.empty_postalcode();
			Assert.assertEquals(Actual, "Please enter a postal code.", "Postal code field can not be empty");
		}
		else if(con6) {
			address.original_address();
			Thread.sleep(2000);
			address.save_addres_after_selection();
			  String Actual = address.invalid_postal();
			  Assert.assertEquals(Actual, "The province/territory and postal code that you provided do not match.", "Postal code should be valid");
		}
		else if (con7) {
			
			Thread.sleep(2000);
			address.suggested_address();
			Thread.sleep(2000);
			address.save_addres_after_selection();
		}
		
	boolean Actual2   =  address.Access_code();
	boolean Actual3    = 	address.weekend_del();
		
	Assert.assertEquals(Actual1, "Canada", "Deafult should be Canada");	
	Assert.assertTrue(Actual2, "User should have option for access code");
	Assert.assertTrue(Actual3, "User should have option for weekend delivery");	
		
		
	}
	
	
	
	/*
	 * @Test public void test() { driver.get(
	 * "https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button");
	 * address.add_address_after_info(); }
	 */
    @AfterMethod
     public void close() {
	 driver.quit();
}
	
	
}
