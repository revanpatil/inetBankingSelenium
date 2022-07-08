package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.BaseClass;

public class AddCustomerPage extends BaseClass{

	WebDriver driver;
	public AddCustomerPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME,using = "name")
	@CacheLookup
	WebElement txtCustomername;
	
	@FindBy(how = How.NAME,using = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME,using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME,using = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME,using = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME,using = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME,using = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME,using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME,using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME,using = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME,using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH,using = "//*[@id='customer']/tbody/tr[4]/td[2]")
	@CacheLookup
	static WebElement customerId;
	
	public void clickAddNewCustomer(){
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname){
		txtCustomername.sendKeys(cname);
	}
	
	public void custGender(String cgender){
		rdGender.click();
	}
	
	public void custDob(String mm,String dd,String yy){
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress){
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity){
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate){
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinco){
		txtpinno.sendKeys(String.valueOf(cpinco));
	}
	
	public void custtelephoneno(String ctelephoneno){
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailId(String cemailid){
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword){
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit(){
		btnSubmit.click();
	}
	
	public static String getId(){
		String a = customerId.getText();
		
		return a;
	}
}
