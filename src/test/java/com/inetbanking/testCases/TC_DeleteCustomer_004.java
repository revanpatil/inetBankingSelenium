package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.DeleteCustomer;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_DeleteCustomer_004 extends BaseClass{

	@BeforeTest
	public void login() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
	}
	@Test(dataProvider ="DeleteData")
	public void deleteData(String id) throws InterruptedException{
		
	
		DeleteCustomer delcust = new DeleteCustomer(driver);
		delcust.clickDeleteCustomer();
		
		Thread.sleep(5000);
		
		delcust.customerID(id);
		delcust.clickSubmit();
		
		if(isAlertPresent() == true ){
			driver.switchTo().alert().accept();
		}
		else{
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}

	}
	
	
	@DataProvider(name = "DeleteData")
	String [][] getData() throws IOException{
	String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	int rownum = XLUtils.getRowCount(path, "Sheet2");
	int colcount = XLUtils.getCellCount(path, "Sheet2", rownum);
	String customerdata[][] = new String[rownum][colcount];
	int i =0;
	int j= 0;
//	for(int i = 0;i<=rownum;i++){
//		for(int j =0;j<colcount;j++){
//			customerdata[i-1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
//		}
//	}
	XLUtils.getCellData(path, "Sheet2", i, j);
	return customerdata;
	
	}
}
