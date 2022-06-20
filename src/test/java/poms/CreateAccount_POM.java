package poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccount_POM extends base.Baseclass_amazon{
	
public static	Actions action;

static   Select select;
	
	@FindBy (xpath="//input[@id='ap_customer_name']" ) WebElement Yourname;
	@FindBy (id="ap_email" ) WebElement MobileorEmail ;
	@FindBy (xpath="//input[@name='password']" ) WebElement Password;
	@FindBy (id="ap_password_check" ) WebElement Passwordcheck;
	@FindBy (xpath="//input[@id='continue']" ) WebElement Verify;
	@FindBy (xpath="//span[contains(text(),'Verify mobile number')]")WebElement verify_mob_text;
	@FindBy (xpath="//span[contains(text(),'Verify email')]")WebElement verify_email_text;
	@FindBy (xpath="//div[contains(text(),'Enter your name')]" ) WebElement Yourname_error;
	@FindBy (xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]" ) WebElement mobile_email_error;
	@FindBy (xpath="//div[@id='auth-password-missing-alert']//div[contains(text(),'Minimum 6 characters required')]" ) WebElement Password_error;
	@FindBy (xpath="//h1[contains(text(),'Verify email address')]")WebElement Email_Auth;
	@FindBy (xpath="//h1[contains(text(),'Verify mobile number')]")WebElement Mob_Auth;
	@FindBy (xpath="//div[contains(text(),'Passwords do not match')]	" ) WebElement password_again_match_error;
	@FindBy (xpath="//div[contains(text(),'Type your password again')]")WebElement Password_again_no_type; 
	@FindBy (xpath="//div[@class='a-row']/a[contains(text(),'Sign in')]")WebElement Sign_in;
	@FindBy (xpath="//a[@id='nav-link-accountList']") WebElement Hello_Sign;
	@FindBy (xpath="//div[@id='nav-flyout-ya-newCust']//a[text()='Start here.']")WebElement Start_new_user;
	@FindBy (xpath="//h4[contains(text(),'Are you a returning customer?')]")WebElement return_user;
	public CreateAccount_POM() {
		PageFactory.initElements(driver, this);
	}
	public void mousehover() throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(Hello_Sign).build().perform();
		Thread.sleep(3000);
		action.moveToElement(Start_new_user).click().build().perform();
		
	}
	
	public void yourname_field(String value) {
		Yourname.sendKeys(value);
		
	}
	
	public String  getnameerror() {
		String result	=Yourname_error.getText();
		return result;
		}
	
	public void Mobile_email_field(String data) {
		MobileorEmail.sendKeys(data);
		
	}
	public String  Email_mob_error() {
		String result	=mobile_email_error.getText();
		return result;
		}
	
	public void pass_field(String pass) {
		Password.sendKeys(pass);
		
	}
	public String  pass_error() {
		String result	=Password_error.getText();
		return result;
		}
	public void password_again_field(String passchk) {
		Passwordcheck.sendKeys(passchk);
	}
	
	public String password_again_field_error() {
	String result=	password_again_match_error.getText();
	return result;
	
	}
	public String password_again_field_no_data_error() {
		String result=	Password_again_no_type.getText();
		return result;
		
		}
	
	
	
	public String get_text_verify_button_for_mob() {
		   String mob_text= verify_mob_text.getText();
		return mob_text;
	}
	
	public String get_text_verify_button_for_email() {
		   String email_text= verify_email_text.getText();
           return email_text;
}
	public boolean Email_auth_page() {
		  
		     boolean result = Email_Auth.isDisplayed();
        return result ;
}
	
	public boolean Mob_auth_page() {
		 boolean result = Mob_Auth.isDisplayed();
		 return result;
}
	public String get_tittle() {
		return driver.getTitle();
	}
	
	public void verify() {
		Verify.click();
	}
	
	public  String returning_cx() {
		
		return return_user.getText();
	}
	
}

	
	