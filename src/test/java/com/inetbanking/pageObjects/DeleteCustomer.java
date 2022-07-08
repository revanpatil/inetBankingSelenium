package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.BaseClass;

public class DeleteCustomer extends BaseClass{

	WebDriver driver;
	public DeleteCustomer(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.NAME,using = "name")
	@CacheLookup
	WebElement customerID;
	
	@FindBy(how = How.NAME,using = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH,using ="//body/div[3]/div[1]/ul[1]/li[4]/a[1]")
	@CacheLookup
	WebElement lnkDeleteCustomer;
	
	public void clickDeleteCustomer(){
		lnkDeleteCustomer.click();
	}

	public void customerID(String cID){
		customerID.sendKeys(cID);
	}
	
	public void clickSubmit(){
		btnSubmit.click();
	}
	
}
