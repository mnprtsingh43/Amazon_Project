package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class YourAccount_Icon_pom extends base.Baseclass_amazon {
	static Actions action;
	
	
	@FindBy   (xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement ICON ;
	@FindBy   (xpath="//span[contains(text(),'Your Account')]") WebElement sublist_element ;
	@FindBy   (xpath="//h1[contains(text(),'Your Account')]") WebElement element_in_sublist_element ;
	@FindBy   (xpath="//a[@id='nav-link-accountList']") WebElement MSG_ICON ;
	
	

     
	
	public String msg() {
	String result=	driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
	return result;
	}
	
	
	 public void mousehovering_login() throws InterruptedException {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
			Thread.sleep(3000);
			
				}

	public boolean element_displayed() {
		
		     boolean result = driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).isDisplayed();
			return result;	
	}
	 
	public boolean element_in_sublist_after_click() {
		   driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
		   boolean result = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]")).isDisplayed();
		return result;
	}
	 
	public void click_on_icon() throws InterruptedException{
		
		  driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();  
		  Thread.sleep(3000);
			}
	
	public void logged_in_(String user, String pass) throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-al-signin']/div/a/span[contains(text(),'Sign in')]"))).click().build().perform();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(user);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
	 
	 
	public boolean your_order_title() {
	boolean title	 = driver.findElement(By.xpath("//h2[contains(text(),'Your Orders')]")).isDisplayed();
	return title;
	}
	 
	 
	 
}
