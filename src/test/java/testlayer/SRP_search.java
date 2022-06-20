package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.SRP_POM;

public class SRP_search extends base.Baseclass_amazon {
	
	static SRP_POM   SRP;
	
	public  SRP_search() {
		super();
	}
	
	@BeforeMethod
	public void opnbrwsr() {
	SRP   =   new SRP_POM();
		
    base.Baseclass_amazon.initiation();
	//base.Baseclass_amazon.logged_in_base(null, null);
		
		
	}
	
	@Test
	public void SRP_Test() throws InterruptedException {
	
		
		SRP.searching("adidas");
		Thread.sleep(2000);
		SRP.search_button_click();
		Thread.sleep(5000);
		String Actual  = SRP.universal_xpath();
		System.out.println(Actual);
		Assert.assertEquals(Actual, "adidas", "SRP is no showing items");		
	    int Actual1  = SRP.number_of_items();
	    System.out.println(Actual1);
	    
	    Assert.assertEquals(Actual1, 60, "each page should have 60 elements by default");
				
	}
	  @Test
	  public void pagination_test() throws InterruptedException{
		  SRP.searching("adidas shoes");
		  Thread.sleep(2000);
		  SRP.search_button_click();
		  SRP.pagination();
	  }
	    
	


	@AfterMethod
	public void close() {
		driver.quit();
	}
	

}
