package datasheet;

import java.io.IOException;


import org.testng.annotations.DataProvider;

import excel_data_driven.Excel_intergration;

public class Datapro extends base.Baseclass_amazon {
	
 
	 @DataProvider 
	 public Object[][]  All_valid_data() throws IOException {
			
	      Object[][] result    = Excel_intergration.Exceldata("CreateAccount");
		
		 return result;
	        }
	 @DataProvider 
	 public Object[][]  Login_existing_User() throws IOException {
			
	      Object[][] result    = Excel_intergration.Exceldata("Login");
		
		 return result;
	        }
	 
	 @DataProvider
	 public String [] order_dropdown() {
		 
	String [] result	 = { "2022", "past 3 months", /*"Archived Orders"*/ "the past 30 days" };
		 
		 
		return result;
		 
	 }
	 @DataProvider 
	 public Object[][]  Address_data() throws IOException {
			
	      Object[][] result    = Excel_intergration.Exceldata("Address");
		
		 return result;
	        }
	 
	 @DataProvider
	 public String [] SRP_Search() {
		 
	String [] result	 = { "adidas", "adidas shoes", "B07RHZSWBY", "shoes","adid", "shoe" };
		 
		 
		return result;
	 
	 }
	 
	 @DataProvider
	 public String [] SRP_Sorting() {
		 
	String [] result	 = { "Price: High to Low", "Price: Low to High"} ;
		 
		 
		return result;


	 }
	 @DataProvider
		public Object[][] Details3(){
			return new Object[][] {{"adidas"},{"adidas shoes"},{"B07RHZSW8Y"},{"shoes"},{"adid"},{"shoe"}};
		}
}









	 
	 
