package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GuestPOM extends base.Baseclass_amazon{

//@FindBy (xpath="//span[contains(text(),'Mens Advantage Cross Trainer')]") WebElement item_over;
	@FindBy (xpath="//span[text()='Prada Sport 56MS 5AV3M1 Sunglasses']") WebElement item_select;
	@FindBy (xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']//a") WebElement item_less_select;
	@FindBy  (xpath="//select[@name='dropdown_selected_size_name']") WebElement size;
	@FindBy  (xpath="//input[@name='submit.add-to-cart']") WebElement Add_cart;
	@FindBy  (xpath="//input[@name='proceedToRetailCheckout']") WebElement Proceed;
	@FindBy  (xpath="//a[contains(text(),'Deliver to this address')]") WebElement Address_select;
	@FindBy  (xpath="//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']") WebElement Continue;
	@FindBy  (xpath="//input[@title='FREE Shipping']") WebElement Free_shipping_radio;
	@FindBy  (xpath="//li//span[contains(text(),'FREE Shipping')]") WebElement free_ship_Qualify;
	@FindBy  (xpath="//span[contains(text(),'The Book of Unusual Knowledge')]") WebElement item_under;
	 
	
	
	
	//span[@class='a-size-base-plus a-color-base a-text-normal']
public GuestPOM() {
		PageFactory.initElements(driver, this);
	}
	
public void select_item_over() throws InterruptedException {
	item_select.click();
	Thread.sleep(2000);
}

public void select_item_less() throws InterruptedException {
	item_less_select.click();
	Thread.sleep(2000);
}


public void no_thanks() throws InterruptedException {
	driver.findElement(By.xpath("//span[@id='attachSiNoCoverage-announce']/preceding-sibling::input[@type='submit']")).click();
	Thread.sleep(2000);
}


public void Add_item(){
	Add_cart.click();
}

public void proceed_to_checkout() throws InterruptedException {
	Proceed.click();
	Thread.sleep(2000);
	

	try {
	Address_select.click();
	Thread.sleep(2000);
//	Continue.click();
	Thread.sleep(2000); }
	
	catch(Exception e){
		String text = driver.getTitle();
		
		if (text.contains("Place Your Order")) {
		System.out.println(text);	
		Address_select.click();
		Thread.sleep(2000);
		//Continue.click();
		Thread.sleep(2000);
		}
		else{
			System.out.println(text);
			Assert.assertTrue((text.contains("Place Your Order")), "GUEST USER SHOULD BE ABLE TO CHECKOUT WITHOUT SIGNUP");
		}
		
	}
}

   public void Free_ship() throws InterruptedException {
	    
	   boolean cond1  = Free_shipping_radio.isDisplayed();
	 	
	if (cond1) {
		Free_shipping_radio.click();
		Thread.sleep(2000);
	boolean actual=	free_ship_Qualify.isDisplayed();
	Assert.assertTrue(actual, "Item is Qualify for free shipping");	
	}
	else if(!cond1) {
	Assert.assertTrue(true, "free shipping not available");
	System.out.println("Free shipping is not available for item under $35");
	}
	   
}
  public void cheap_item() {
	item_under.click();
	
}
 public void continue_button() {
	Continue.click();
}

}
