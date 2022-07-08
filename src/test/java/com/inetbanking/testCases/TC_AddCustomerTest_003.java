package com.inetbanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		Thread.sleep(5000);
		
		addcust.custName("pavan");
		addcust.custGender("male");
		addcust.custDob("10", "05", "1985");
		Thread.sleep(1000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987654321");
		
		String email = randomeString()+"@gmail.com";
		addcust.custemailId(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true){
			Assert.assertTrue(true);
		}
		else{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
		
		setData();
	}
	
	public String randomeString(){
		
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum(){
		
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
	

	String  setData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int i =0;
		int j =0;
		String b = AddCustomerPage.getId();
		String test = XLUtils.setCellData(path, "Sheet2", i, j, b);
		
		return test;
		}
		
	
	
	
				
	
}
