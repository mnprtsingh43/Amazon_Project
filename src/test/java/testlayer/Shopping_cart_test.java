package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.Shopping_cart;

public class Shopping_cart_test extends base.Baseclass_amazon {

	Shopping_cart shop;
public Shopping_cart_test() {
	super();
}

@BeforeMethod
public void open_browser() throws InterruptedException {
	base.Baseclass_amazon.initiation();
    shop=  new Shopping_cart();
    base.Baseclass_amazon.logged_in_base(prop.getProperty("username"), prop.getProperty("password"));
}

@Test
public void testing_shopping_cart() throws InterruptedException {
	
// Same product added multiple times should increase quantity and price of item
	shop.quanity_price_relation();
//deleting all the item should display Empty card and zero price
	 shop.zero_item("0");
	
}
	
@Test
public void item_information_test() throws Throwable {
	shop.items_info();
	
}
	
@Test
public void product_info_displayed() throws InterruptedException {
	String title  = shop.items_info();
	System.out.println(title);
	Assert.assertEquals("Philips Multigroom Series 1000, MG1100/16 : Amazon.ca: Health & Personal Care", title, "Product information should display");
}


@AfterMethod
public void close() {
	driver.quit();
}

}
