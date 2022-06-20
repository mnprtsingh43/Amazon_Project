package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.SRP_POM;

public class Sorting_feature extends base.Baseclass_amazon{

	static SRP_POM SRP;
	
	public Sorting_feature() {
		super();
	}
	
	@BeforeMethod
	public void testing() {
		base.Baseclass_amazon.initiation();
	    SRP	 = new SRP_POM();
		
		
	}
	
	@Test   (dataProviderClass=datasheet.Datapro.class , dataProvider="SRP_Sorting")
	public void testing12(String data) throws InterruptedException {
		
		SRP.searching("advil for men");
		SRP.search_button_click();
		Thread.sleep(2000);
		SRP.sorting_feature(data);
		
		
	}
	
	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
	
	
	
}
