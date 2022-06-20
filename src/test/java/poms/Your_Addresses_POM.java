package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Your_Addresses_POM  extends base.Baseclass_amazon{
    
	static Select select;
	
	public void Account_click() {
		driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
	}
	public void addresses_tab() {
		driver.findElement(By.xpath("//h2[contains(text(),' Your Addresses')]")).click();
	}
	
	public void add_address() {
		driver.findElement(By.xpath("//h2[contains(text(),'Add Address')]")).click();
	}
	
	public String default_Country() {
	String result=	driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']//span[contains(text(),'Canada')]")).getText();
	return result;
	}
	public void Fullname(String value) {
		driver.findElement(By.xpath("//input[@name='address-ui-widgets-enterAddressFullName']")).sendKeys(value);
	}
	public void phonenumber(String value) {
		driver.findElement(By.xpath("//input[@name='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys(value);
	}
	public void address(String value) {
		driver.findElement(By.xpath("//input[@name='address-ui-widgets-enterAddressLine1']")).sendKeys(value);
	}
	public void city(String value) {
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(value);
	}
	public void postalcode(String value) {
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(value);
	}
	public void province(String text) {
		select=new Select(driver.findElement(By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']")));
		select.selectByValue(text);
	}
	
	public void default_address_checkbox() {
		driver.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
	}
	public void add_address_after_info() {
		driver.findElement(By.xpath("//span[@id='address-ui-widgets-form-submit-button']")).click();
	}
	public boolean weekend_del() {
	boolean result=	driver.findElement(By.xpath("//span[text()='Weekend delivery']")).isDisplayed();
	return result;
	}

	public boolean Access_code() {
		boolean result=driver.findElement(By.xpath("//span[text()='Do we need a security code or a call box number to access this building?']")).isDisplayed();
	   return result ;
	}
	
	public String empty_address_error() {
	String result  =driver.findElement(By.xpath("//div[contains(text(),'Please enter an address.')]")).getText();
	return result;
	}
	
	public String empty_fullname_error() {
		String result  =driver.findElement(By.xpath("//div[contains(text(),'Please enter a name.')]")).getText();
		return result;
		}
	
	
	public String empty_phone() {
		String result  =driver.findElement(By.xpath("//div[contains(text(),'Please enter a phone number so we can call if there are any issues with delivery.')]")).getText();
		return result;
		}
	public String empty_city() {
		String result  =driver.findElement(By.xpath("//div[contains(text(),'Please enter a city name.')]")).getText();
		return result;
		}
	
	
	public String empty_postalcode() {
		String result  =driver.findElement(By.xpath("//div[contains(text(),'Please enter a postal code.')]")).getText();
		return result;
		}
	
	
	
	public String invalid_postal () {
		String result  =driver.findElement(By.xpath("//div[contains(text(),'The province/territory and postal code that you provided do not match.')]")).getText();
		return result;
		}
	
	public void suggested_address() {
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-suggested-address-block_id-input']")).click();
	}
	public void original_address() {
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-original-address-block_id-input']")).click();
	}
	
	public void save_addres_after_selection() {
		driver.findElement(By.xpath("//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']")).click();
	}
	
}
