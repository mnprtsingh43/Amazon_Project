package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Your_Payments_POM extends base.Baseclass_amazon {
static Select select;

    public void your_account() {
	driver.findElement(By.xpath("//span[contains(text(),'Your Account')]")).click();
}

	public void your_payment_click() {
		driver.findElement(By.xpath("//h2[contains(text(),'Your Payments')]")).click();
	}
	
	public void add_payment() {
		driver.findElement(By.xpath("//a[contains(text(),'Add a payment method')]")).click();
	}
	
	public void add_debit_credit() {
		driver.findElement(By.xpath("//span[@id='apx-add-credit-card-action-test-id']")).click();
	}
	
	public void card_number (String value) {
		driver.findElement(By.xpath("//input[@name='addCreditCardNumber']")).sendKeys(value);
		
	}
	public void card_name(String value) {
		driver.findElement(By.xpath("//input[@name='ppw-accountHolderName']")).sendKeys(value);
	}
	
	
	public void month_drop(String value) {
		select = new Select(driver.findElement(By.xpath("//select[@name='ppw-expirationDate_month']")));
		select.selectByValue(value);
	}
	public void year_drop(String value) {
		select = new Select(driver.findElement(By.xpath("//select[@name='ppw-expirationDate_year']")));
		select.selectByValue(value);
	}
	public void add_your_card_icon() {
		driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
