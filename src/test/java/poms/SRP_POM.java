package poms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SRP_POM extends base.Baseclass_amazon {
    
   static Select select;
	@FindBy (id="twotabsearchtextbox") WebElement Search_bar;
    @FindBy (id="nav-search-submit-button") WebElement Search_button;
    @FindBy (xpath="//input[@id='signInSubmit']" ) WebElement Sign_in;

    
  
	
	
	
	
	public SRP_POM() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void searching(String text) {
	  
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
	}
	
	public void search_button_click() {
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	}
	
	public String universal_xpath() {
	String text=driver.findElement(By.xpath("//h5//span[contains(text(),'adidas')]")).getText();
	return text;
	}
	
    public int number_of_items() {
  List<WebElement> list = 	driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']"));
	int numbers=list.size();
	return numbers;
}
    
    
    

	public void pagination() throws InterruptedException {
   WebElement Nextbutton = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));

   /*
	 * Thread.sleep(3000); base.Baseclass_amazon.Javaexecutor(9000);
	 * Thread.sleep(3000); Nextbutton.click();
	 */
		
	
	
	List<WebElement> list = 	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
    List<String> Totalitems= new ArrayList<String>();
     
	  
      for( WebElement item:list) {    
      Totalitems.add(item.getText());
	  System.out.println(item.getText());
	  
 }
	 
System.out.println("------------------>");

while(true) {
	         base.Baseclass_amazon.Javaexecutor(10000);
	         Nextbutton.click();
	         Thread.sleep(3000);
	         list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

   
	         for( WebElement item:list) {
	        		
	        	 String Actual= item.getText();
	             Totalitems.add(Actual);
	     	
	     	
	   
	     
	     	if(!(Actual.equals("Men's Stan Smith Sneaker"))) {
	     		System.out.println(Actual);
	     		continue;
	     }
	     	else {
	     		
	     Assert.assertNotSame(Actual, "Men's Stan Smith Sneaker", "Items can not be repeated");
	    	 
	     }
	     	
	     }

	         System.out.println("------------->");
	         try {
	        	 Nextbutton= driver.findElement(By.xpath("//a[contains(text(),'Next')]")); 
	        
	         }
	         catch(Exception e) {
	        	 System.out.println("No more product left"); 
	        	 break;
}
	 
	         
	         
	         
	         
   System.out.println(Totalitems.size());	         
	         
	         
	         
	         
	         
           
	}





	}

	
public void sorting_feature(String text) throws InterruptedException
{     
	
	
	
	if (text.contains("Price: Low to High"))
	{
	select= new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
    select.selectByVisibleText(text);  
    driver.findElement(By.linkText(text)).click();
    
    Thread.sleep(5000);
    base.Baseclass_amazon.Javaexecutor(6000);
    Thread.sleep(2000);
    List<WebElement> beforelist= driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']//span[@class='a-offscreen']"));  
    List<Double> item_price_before= new ArrayList<Double>();
    
   
    

    System.out.println(beforelist.size());
    
    for(WebElement elements: beforelist)  {
   	
	  item_price_before.add(Double.valueOf(elements.getAttribute("textContent").replace("$","")));
	  
    }
    System.out.println(item_price_before);
    
    base.Baseclass_amazon.Javaexecutor(-6000);
    Thread.sleep(5000);
    select= new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
    select.selectByVisibleText("Price: High to Low");
    driver.findElement(By.linkText("Price: High to Low")).click();
    
    
    Thread.sleep(4000);
    List<WebElement> list=driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']//span[@class='a-offscreen']"));
    List<Double> item_price_after= new ArrayList<Double>();
    
    System.out.println(list.size());;
    
    for(WebElement element:list) {
    	
   
    item_price_after.add(Double.valueOf(element.getAttribute("textContent").replace("$","")));

   
  }
    
    Collections.sort(item_price_after);
    System.out.println(item_price_after); 

    Assert.assertTrue(item_price_before.containsAll(item_price_after), "List does not match");     
    
    

	}

  else if(text.contains("Price: High to Low"))
{
	  select= new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
	    select.selectByVisibleText(text);  
	    driver.findElement(By.linkText(text)).click();
	    
	    Thread.sleep(5000);
	    base.Baseclass_amazon.Javaexecutor(6000);
	    Thread.sleep(2000);
	    List<WebElement> beforelist= driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']//span[@class='a-offscreen']"));  
	    List<Double> item_price_before= new ArrayList<Double>();
	    
	   
	    

	    System.out.println(beforelist.size());
	    
	    for(WebElement elements: beforelist)  {
	   	
		  item_price_before.add(Double.valueOf(elements.getAttribute("textContent").replace("$","")));
		  
	    }
	    System.out.println(item_price_before);
	    
	    base.Baseclass_amazon.Javaexecutor(-6000);
	    Thread.sleep(5000);
	    select= new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
	    select.selectByVisibleText("Price: Low to High");
	    driver.findElement(By.linkText("Price: Low to High")).click();
	    
	    
	    Thread.sleep(4000);
	    List<WebElement> list=driver.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']//span[@class='a-offscreen']"));
	    List<Double> item_price_after= new ArrayList<Double>();
	    
	    System.out.println(list.size());;
	    
	    for(WebElement element:list) {
	    	
	   
	    item_price_after.add(Double.valueOf(element.getAttribute("textContent").replace("$","")));

	   
	  }
	    
	    Collections.reverse(item_price_after);
	    System.out.println(item_price_after); 

	    Assert.assertTrue(item_price_before.containsAll(item_price_after), "List does not match");     
	    
	    	
	
	
	
	
	
	
	
}	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
	
	





















/*
 * List<WebElement> allElements= new ArrayList<WebElement>();
 * 
 * for( int i=1; i<=7 ;i++) {
 * //span[@class='s-pagination-strip']//a[contains(text(),'6')]
 * driver.findElement(By.xpath(
 * "//span[@class='s-pagination-strip']//a[contains(text(),'"+i+"')]")).click();
 * 
 * allElements = (driver.findElements(By.xpath(
 * "//span[@class='s-pagination-strip']//a[contains(text(),'6')]"))); }
 * 
 * System.out.println(allElements.size()); for (int k=0; k<= allElements.size();
 * k++) {
 * 
 * String text= allElements.get(k).getText();
 * 
 * if (!(text.equals(null))) {
 * 
 * System.out.println(text); continue;
 * 
 * } else if(k==allElements.size()) { Assert.assertEquals(text,
 * "Mens Eh2367 Baseball Shoe", "Duplicate item should not display"); break; }
 * 
 * 
 * }
 */
 
 
	
	
	
	


