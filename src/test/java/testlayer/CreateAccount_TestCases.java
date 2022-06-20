package testlayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import poms.CreateAccount_POM;

@Listeners (listener_class.listener_fail_test.class)
public class CreateAccount_TestCases extends base.Baseclass_amazon{

	
static 	CreateAccount_POM Create;

       public CreateAccount_TestCases() {
	   super();
}


      @BeforeMethod
      public void openbrowser() {
	base.Baseclass_amazon.initiation();
	
}
      
      
	
	
	@Test (priority=1 ,dataProviderClass=datasheet.Datapro.class, dataProvider="All_valid_data") 
    public void Funtionality_of_Create_account (String Condition ,String name, String phn_email, String pass,String passagin) throws Exception {


           
		boolean Cond1= Condition.equals("emptyname");                         
		boolean Cond2= Condition.equals("emptymob_email") ;                               
		boolean Cond3= Condition.equals("partial_email")  ;                                
		boolean Cond4= Condition.equals("empty_pass");                                    
		boolean Cond5= Condition.equals ("empty_pass_again");                              
		boolean Cond6= Condition.equals ("wrong_pass") ;                                
		boolean Cond7= Condition.equals ("partial_mob");                                  
		boolean Cond8=Condition.equals ("valid_data");
		boolean Cond10=Condition.equals ("Existing customer");

		Create  =new CreateAccount_POM();
		Create.mousehover();
		Thread.sleep(2000);
		Create.yourname_field(name);	
		Thread.sleep(2000);
		Create.Mobile_email_field(phn_email);
		Create.pass_field(pass);
		Thread.sleep(2000);
		Create.password_again_field(passagin);
		Thread.sleep(3000);
		
		
		
	    if (Cond1) {  
	    	Create.verify();
			Thread.sleep(2000);
			String Actual = Create.getnameerror();
			Assert.assertEquals(prop.getProperty("Name_error"), Actual , "Error msg did not match");
		System.out.println(Actual);
		}
		else if (Cond2)  {
			      Create.verify();
		       	  Thread.sleep(2000);
			       String Actual=Create.Email_mob_error();
			       Assert.assertEquals(prop.getProperty("Mobile_email_field_error"), Actual , "Error msg did not match");
					System.out.println(Actual);
		}
		else if (Cond3)  {
			Create.verify();
			Thread.sleep(2000);
		       String Actual=Create.get_text_verify_button_for_email();
		       Assert.assertEquals(prop.getProperty("Verify_button_email"), Actual , "Error msg did not match");
				System.out.println(Actual);
	    }
		else if (Cond4)  {
			Create.verify();
		   	Thread.sleep(2000);
		       String Actual=Create.pass_error();
		       Assert.assertEquals(prop.getProperty("Pass_error"), Actual , "Error msg did not match");   
				System.out.println(Actual);
		}
		else if (Cond5)  {
			   Create.verify();
		    	Thread.sleep(2000);
		       String Actual=Create.password_again_field_no_data_error();
		       Assert.assertEquals(prop.getProperty("Pass_again_no_Type"), Actual , "Error msg did not match");
				System.out.println(Actual);
		}
	   else if (Cond6)  {
		              Create.verify();
			           Thread.sleep(2000);
				       String Actual=Create.password_again_field_error();
				       Assert.assertEquals(prop.getProperty("Pass_again_no_match"), Actual , "Error msg did not match");
						System.out.println(Actual);
	   }
	   else if (Cond7)  {
					  String Actual=Create.get_text_verify_button_for_mob();
				      Assert.assertEquals(prop.getProperty("Verify_button_mob"), Actual , "Error msg did not match");
					  System.out.println(Actual);
	  }
	   else if (Cond8)  {
		      Create.verify();
			  Thread.sleep(2000);
		      String title =Create.get_tittle();
		        boolean Cond9 = title.equals("Authentication required")|| title.equals("Amazon Phone verification");
		if(Cond9)	  
		      Assert.assertTrue(Cond8, "Different page coming up");
			  System.out.println(title);
       }
	   else if(Cond10) {
		Create.verify();
		Thread.sleep(4000);
		String error=   Create.returning_cx();
		Assert.assertEquals(error, "Are you a returning customer?" , "Error msg did not match");
		System.out.println(error);   
	   }
		
		
	}	
		
		
		
		
	


	@AfterMethod
	public void close_browser() {
		driver.quit();
	}




}
