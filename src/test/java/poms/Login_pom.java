package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Login_pom extends base.Baseclass_amazon {
static Actions action;

	@FindBy (xpath="//input[@id='ap_email']" ) WebElement Email_existing_customer;
    @FindBy (xpath="//input[@id='ap_password']" ) WebElement Password;
    @FindBy (xpath="//input[@id='signInSubmit']" ) WebElement Sign_in;
    @FindBy (xpath="//input[@id='continue']" ) WebElement Continue;
    @FindBy (xpath="//input[@name='rememberMe']" ) WebElement signin_Checkbox;
    @FindBy (xpath="//div[@id='nav-al-signin']/div/a/span[contains(text(),'Sign in')]" ) WebElement signin_ex_user;
    @FindBy (xpath="//a[@id='nav-link-accountList']") WebElement Hello_Sign;	
    @FindBy  (xpath="//li//span[contains(text(),'We cannot find an account with that e-mail address')]")WebElement par_email;
    @FindBy  (xpath="//li//span[contains(text(),'We cannot find an account with that mobile number')]")WebElement par_mobile;
    @FindBy (xpath="//div[contains(text(),'Enter your password')]" ) WebElement empty_pass;
    

    
    
    public void Email(String value) {
    	
  driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(value);
    }
    public void Password(String value) {
    	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(value);
    }
    public void Signin() {
    	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
    }
 
    public void contine_butn() {
    	driver.findElement(By.xpath("//input[@id='continue']")).click();
    }
    
    public void Checkbox() {
    	driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
    }
    public void mousehover_login() throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-al-signin']/div/a/span[contains(text(),'Sign in')]"))).click().build().perform();
			}
    
    public String mob_email_blnk() {
    	   String error = driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
		return error;
    	
    }
    
    public String par_email_enter() {
  String title = driver.findElement(By.xpath("//li//span[contains(text(),'We cannot find an account with that e-mail address')]")).getText();
  return title;
    }
    
    public String par_mob_enter() {
    	  String title = driver.findElement(By.xpath("//li//span[contains(text(),'We cannot find an account with that mobile number')]")).getText();
    	  return title;
    	    }
    
    public String empty_password() {
  	  String title = driver.findElement(By.xpath("//div[contains(text(),'Enter your password')]")).getText();
  	  return title;
  	    }
    
    
  
    
    public String invalid_password() {
    	  String title = driver.findElement(By.xpath("//span[contains(text(),'Your password is incorrect')]")).getText();
    	  return title;
    	    }
      
    
    public String tittle() {
    	return driver.getTitle();
    }
    
   
    

}
