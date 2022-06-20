package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass_amazon {
	
public	static Properties prop  ; 
public 	static WebDriver driver ;
public	static WebDriverWait wait;
public static JavascriptExecutor js;
public static Actions action;
	
	public Baseclass_amazon() {
		
		prop=new Properties();
	 	
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Preet\\eclipse-workspace\\Amazon_Website\\src\\test\\java\\Config.prop");
			prop.load(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException a) {
		a.printStackTrace();
		}
	
}
		
	
	public static void initiation() {
	
		
 String	browsername=prop.getProperty("Browser");
	
	if (browsername.equals("Chrome")) {
		
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		}
	else if(browsername.equals("Firefox")) {

		System.setProperty("Webdriver.gecko.driver", "gecko.exe");
		driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		
}
	public static void explicit(WebDriver driver, int timeout,WebElement element, String value) {
        wait =new WebDriverWait(driver, timeout);
       wait.until((ExpectedConditions.visibilityOf(element)));	
       element.sendKeys(value);
	}
	
	public static void ScreenshotMethod( String methodname) throws IOException {
		
		
	File scrfle	=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfle, new File("C:\\Users\\Preet\\eclipse-workspace\\Amazon_Website\\Screenshots\\Fail_test_cases\\"+methodname+".jpg"));
		
		
		  
	}
	public static void Javaexecutor(int pixel) {
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,"+pixel+")");
		
		
	}
	
	public static void logged_in_base(String user, String pass) throws InterruptedException {
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
	
	 public static void mousehover_login_base() throws InterruptedException {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
			Thread.sleep(3000);
			
				}
	
	
	

}
