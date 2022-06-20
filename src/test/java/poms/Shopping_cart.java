package poms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Shopping_cart extends base.Baseclass_amazon {

	
	@FindBy (xpath="//h2//a//span[contains(text(),'Philips Multigroom Series 1000, MG1100/16')]") WebElement Trimmer;
    @FindBy (xpath="//input[@name='submit.add-to-cart']") WebElement add_to_cart;
    @FindBy (xpath="//select[@name='quantity']" ) WebElement quantity;
    @FindBy (xpath="//span[@id='sc-subtotal-amount-activecart']" ) WebElement price;
    @FindBy (xpath="//span[@id='nav-cart-count']" ) WebElement cart;
    @FindBy (xpath="//span[@id='sc-subtotal-label-activecart']" ) WebElement Zero_item;
    @FindBy (xpath="//h1[contains(text(),'Your Amazon Cart is empty.')]" ) WebElement empty_cart;
    @FindBy (xpath="//img[@id='landingImage']") WebElement item_img;
    @FindBy (xpath="//span[@class='a-truncate-cut' and contains(text(),'Philips Multigroom Series 1000, MG1100/16')]" ) WebElement item_in_cart;
    @FindBy (xpath="//div[@id='averageCustomerReviews_feature_div']/descendant::span[@id='acrCustomerReviewText']" ) WebElement Cx_rating;
    @FindBy (xpath="//div[@id='featurebullets_feature_div']" ) WebElement product_info;
    
    
  
	SRP_POM SRP=new SRP_POM();
    
	public Shopping_cart() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void quanity_price_relation() throws InterruptedException{
	
		
			
		SRP.searching(prop.getProperty("item"));
		Thread.sleep(2000);
		SRP.search_button_click();
		Thread.sleep(2000);
		Trimmer.click();
		Thread.sleep(2000);
		add_to_cart.click();
		Thread.sleep(2000);
		cart.click();
		Thread.sleep(2000);
	   int number= Integer.valueOf(quantity.getAttribute("value"));
      System.out.println(number);	
       double price_initially = Double.valueOf(price.getText().replace("$", ""));
      driver.navigate().back();
      driver.navigate().back();
		Thread.sleep(2000);
		add_to_cart.click();
		Thread.sleep(2000);
		cart.click();
		Thread.sleep(2000);
	 int number1= Integer.valueOf(quantity.getAttribute("value"));
     
	 Assert.assertTrue(number1>number, "Quantity is not increasing");
	 
     double price_after = Double.valueOf(price.getText().replace("$", ""));   
     System.out.println(number1);
     System.out.println(price_initially);
     System.out.println(price_after);
    
  Assert.assertTrue((price_after != price_initially || price_after > price_initially) , "Price did not change");
    	
    	
	} 	

		
	public void zero_item(String value) throws InterruptedException {
		SRP.searching(prop.getProperty("item"));
		Thread.sleep(2000);
		SRP.search_button_click();
		Thread.sleep(2000);
		Trimmer.click();
		Thread.sleep(2000);
		add_to_cart.click();
		Thread.sleep(2000);
		cart.click();
		Thread.sleep(2000);
    	Select slct=new Select(quantity);	
		slct.selectByValue(value);
		boolean result     = price.isDisplayed();
		Assert.assertFalse(result, "Price should be zero");
		System.out.println(result+ "---> No price displayed:Cart is empty");
		
		boolean Result1 = empty_cart.isDisplayed();
		
		Assert.assertTrue(Result1, "Cart is not empty");
	}

	
	public String items_info() throws InterruptedException {
		
		SRP.searching(prop.getProperty("item"));
		Thread.sleep(2000);
		SRP.search_button_click();
		Thread.sleep(2000);
		Trimmer.click();
		Thread.sleep(2000);
		add_to_cart.click();
		Thread.sleep(2000);
		cart.click();
		Thread.sleep(2000);
		item_in_cart.click();
		Thread.sleep(2000);
	
		
		
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	
		
		driver.switchTo().window(tabs.get(1));
		
        String title= driver.getTitle();
		return title;
	}
	
		
		
		
	
	
		
		
}			
		

	

	

	
	
	

	
	
	
	

