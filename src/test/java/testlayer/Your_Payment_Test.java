package testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.Your_Payments_POM;

public class Your_Payment_Test extends base.Baseclass_amazon {
	static Your_Payments_POM payment;
	public Your_Payment_Test() {
		super();
	}
	
@BeforeMethod
	public void openbrowser() throws InterruptedException {
	    payment= new Your_Payments_POM();
		base.Baseclass_amazon.initiation();
		base.Baseclass_amazon.logged_in_base(prop.getProperty("username"), prop.getProperty("password"));
		base.Baseclass_amazon.mousehover_login_base();
		Thread.sleep(2000);

	}
	
@Test
public void YourPayment_Module_Test() throws InterruptedException {
	
	payment.your_account();
	Thread.sleep(2000);
	payment.your_payment_click();
	Thread.sleep(2000);
	payment.add_payment();
	Thread.sleep(2000);
	payment.add_debit_credit();
	Thread.sleep(2000);
	
	driver.switchTo().frame(0);
	payment.card_number("12345678");
	payment.card_name("Methu vir");
	payment.month_drop("12");
	payment.year_drop("2024");
	payment.add_your_card_icon();
}
	
@AfterMethod
public void close() {
	driver.quit();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
