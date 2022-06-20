package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import poms.CreateAccount_POM;
import poms.Login_pom;


@Listeners (listener_class.listener_fail_test.class)
public class Signin_ExistingCx extends base.Baseclass_amazon {

	static  Login_pom   login;
	static CreateAccount_POM  Create;
	
	
	public Signin_ExistingCx () {
		super();
	}

	      @BeforeMethod
	      public void openbrowser() {
		base.Baseclass_amazon.initiation();
		
	}
	
	
	@Test (priority=1 ,dataProviderClass=datasheet.Datapro.class, dataProvider="Login_existing_User")
	public void Existing_User(String condition , String email, String pass) throws InterruptedException {
	 
		boolean con1= condition.equals("ParEmail");
		boolean con2= condition.equals("blnk Email");
		boolean con3= condition.equals("ParMob");
		boolean con4= condition.equals("valid Email");
		boolean con5= condition.equals("valid number");
		boolean con6= condition.equals("invalpass");
		boolean con7= condition.equals("blnkpass");
		
	if (  con1 || con2  || con3 ) {		
	  login	= new Login_pom();
	  login.mousehover_login();
	  Thread.sleep(2000);
	  login.Email(email);
	  Thread.sleep(2000);  
	  login.contine_butn();
	  
	 if(con2) {
	  String error = login.mob_email_blnk();
	  Assert.assertEquals(error, "Enter your e-mail address or mobile phone number", "Email or mobile can not empty");
	  System.out.println(error);
	 }
	 else if(con1) {
	String error=	 login.par_email_enter();
	Assert.assertEquals(error, "We cannot find an account with that e-mail address", "Email or mobile field can not be empty");
	System.out.println(error);
	 }
	 else if(con3) {
		 String error=login.par_mob_enter();
		 Assert.assertEquals(error, "We cannot find an account with that mobile number", "need to enter a valid mobile number");
		 System.out.println(error);
	 }
	 
	
	}
 
	else if ( con4 || con5  || con6 ||  con7)
{  
	  
		  login	= new Login_pom();
		  login.mousehover_login();
		  Thread.sleep(2000);
		  login.Email(email);
		  Thread.sleep(2000);
		  login.contine_butn();
		  Thread.sleep(2000);
		  login.Password(pass);
		  Thread.sleep(2000);
		  login.Checkbox();
		  login.Signin();
		
if(con7) {
	String error=login.empty_password();
	 Assert.assertEquals(error, "Enter your password", "Password can not be empty and different message came up");
	 System.out.println(error);
	
}
else if(con6) {
	String error=login.invalid_password();
	 Assert.assertEquals(error, "Your password is incorrect", "different message came up");
	 System.out.println(error);
	
}
else if(con5) {
	  String error=login.tittle();
	  System.out.println(error);
	 Assert.assertEquals(error, "Amazon Sign In", "different message came up");

	
}
else if(con4) {
	String error=login.tittle();
	System.out.println(error);
	 Assert.assertEquals(error, "Amazon Sign In", "different message came up");

	
}		  	  
		 		  
		  
		  
	}
	
	}


@AfterMethod
public void close() {
	driver.quit();
}
}
	
	

