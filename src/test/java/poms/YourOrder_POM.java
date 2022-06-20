package poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class YourOrder_POM extends base.Baseclass_amazon {
	static Select select;
	
	
	
	
	public void order_tab_click() {
		driver.findElement(By.xpath("//span[contains(text(),'Your Orders')]")).click();
	}
	
	
	
	public void drop_down(String text) throws InterruptedException {
		driver.findElement(By.xpath("//span[@id='a-autoid-1-announce']")).click();
		Thread.sleep(2000);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='a-popover-inner']//li"));
		 
		list.size();
		for(int i=0 ; i<=list.size() ; i++) {
			String result = list.get(i).getText();
			
			if (result.equals(text)) {
				driver.findElement(By.xpath("//div[@class='a-popover-inner']//li/a[contains(text(),'"+text+"')]")).click();
				break;
			}
			else {continue;
		}
		
		
	}
	}
	
	public boolean order_list(String retext){
	boolean result=	driver.findElement(By.xpath("//span[contains(text(),'"+ retext+"')]")).isDisplayed();
	return result;
	}
	
	
	public boolean yourorder_other_tabs(String text) {
		
		
	       boolean result   = driver.findElement(By.xpath("//li[@role='tab']//a[contains(text(),'"+text+"')]")).isDisplayed();
	       return result;
			
		}
	public boolean buy_again_rec() {
		boolean result=driver.findElement(By.xpath("//span[contains(text(),'Optimum Nutrition Gold Standard 100% Whey Prot…')]")).isDisplayed();
		return result;
	}
		
		
	
	
	
	public void buy_again_click() {
		driver.findElement(By.xpath("//li//a[contains(text(),'Buy Again')]")).click();
	}
	
	
	}
	
	
	
		
	

	

