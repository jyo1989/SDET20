package com.vtiger.comcast.producttest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositorylib.CreateProductPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.ProductInformationPage;
import com.vtiger.comcast.pomrepositorylib.ProductsPage;

@Listeners(com.vtiger.comcast.genericUtility.ListenerImpClass.class)
public class Search_ProductTest  extends BaseClass{

@Test(groups="SmokeTesting")
	public void createProductTest() throws Throwable, Throwable {
	
	HomePage hp=new HomePage(driver);
	hp.getProductLink().click();
	

	ProductsPage p=new ProductsPage(driver);
	p.getCreateProductImg().click();
	
	String productname=eu.getDataFromExcel("Sheet1", 1, 0);
	System.out.println(productname);
	
	CreateProductPage cp=new CreateProductPage(driver);
	cp.getProductNameEdt().sendKeys(productname);
	cp.getSavebutton().click();
	
	ProductInformationPage pi=new ProductInformationPage(driver);
	String actualmsg=pi.getSuccessfullMsg().getText();
	
	
	boolean productStatus=actualmsg.contains(productname);
	Assert.assertTrue(productStatus);
	
//	if(actualmsg.contains(productname)) {
//		System.out.println("Product is Successfully created: PASS");
//	}else
//	System.out.println("Product is not Created: FAIL");
	
	String productno = pi.getProductno().getText();
	hp.getProductLink().click();

	p.getSearchtextfield().sendKeys(productno);
	p.getIndropdown().click();
	p.getProductno().click();
	p.getSubmitbutton().click();

	List<WebElement> allProNo=p.getProductnotext();
	for(WebElement ele : allProNo)
	{
		String allProText=ele.getText();
	
		if(productno.contains(allProText)) {
		System.out.println("Pass::"+allProText+"product hasbeen found sucessfully after searching");
		break;
	}	

}
}


	@Test(groups= "RegressionTesting")
	
	public void searchProductByPartnameTest() throws Throwable {
	
		HomePage hp=new HomePage(driver);
		hp.getProductLink().click();
			
	ProductsPage p=new ProductsPage(driver);
	p.getCreateProductImg().click();
	
	String productname=eu.getDataFromExcel("Sheet1", 1, 0);
	System.out.println(productname);
	
	
	String partNumber = eu.getDataFromExcel("Sheet1", 1, 3);
	System.out.println(partNumber);
	
	CreateProductPage cp=new CreateProductPage(driver);
	cp.getProductNameEdt().sendKeys(productname);
	cp.getPartNumberEdt().sendKeys(partNumber);
	cp.getSavebutton().click();


	ProductInformationPage pi=new ProductInformationPage(driver);
	String actualmsg=pi.getSuccessfullMsg().getText();
	
	boolean productStatus=(actualmsg.contains(productname));
	Assert.assertTrue(productStatus);
//	if(actualmsg.contains(productname)) {
//		System.out.println("pass: Product is Successfully Created");
//	}else
//	System.out.println("fail: Product is not Created");
//	
	
	
	String productno = pi.getProductno().getText();
	hp.getProductLink().click();

	p.getSearchtextfield().sendKeys(partNumber);
	p.getIndropdown().click();
	//p.getProductno().click();
	p.getPartno().click();
	p.getSubmitbutton().click();

	List<WebElement> allProNo=p.getProductnotext();
	for(WebElement ele : allProNo)
	{
		String allProText=ele.getText();
		
		if(productno.contains(allProText)) {
			System.out.println("Pass::"+allProText+"product hasbeen found sucessfully after searching");
		break;
		}	
	}
	
	
	

	}


	@Test(groups= "RegressionTesting")
	public void searchProductByCommissionRateTest() throws Throwable{
		
		HomePage hp=new HomePage(driver);
		hp.getProductLink().click();
		
		ProductsPage p=new ProductsPage(driver);
		p.getCreateProductImg().click();
		
		
		String productname=eu.getDataFromExcel("Sheet1", 1, 0);
		System.out.println(productname);
		
		
		String partNumber = eu.getDataFromExcel("Sheet1", 1, 3);
		System.out.println(partNumber);
		
		String commissionRate=eu.getDataFromExcel("Sheet1", 1, 4);
		System.out.println(commissionRate);
		
		
		CreateProductPage cp=new CreateProductPage(driver);
		cp.getProductNameEdt().sendKeys(productname);
		
		cp.getCommisiontextfield().sendKeys(commissionRate);
		cp.getSavebutton().click();
	
	
		ProductInformationPage pi=new ProductInformationPage(driver);
		String actualmsg=pi.getSuccessfullMsg().getText();
		
		boolean productstatus=(actualmsg.contains(productname));
		Assert.assertTrue(productstatus);
		
//		if(actualmsg.contains(productname)) {
//			System.out.println("pass: Product is Successfully Created");
//		}else
//		System.out.println("fail: Product is not Created");
//		
		String productno = pi.getProductno().getText().trim();
		System.out.println(productno);
		hp.getProductLink().click();
	
		p.getSearchtextfield().sendKeys(commissionRate);
		p.getIndropdown().click();
		
		p.getCommisionrate().click();
		p.getSubmitbutton().click();
	
		Thread.sleep(5000);
		String allProNo=null;
		List<WebElement> prodNos=p.getProductnotext();
		System.out.println(prodNos.size());
		for(WebElement ele : prodNos)
		{
			allProNo=ele.getText().trim();
			
			if(productno.equals(allProNo)) {
				System.out.println(allProNo);
			System.out.println("Pass::"+allProNo+"product has been found sucessfully after searching");
				break;
			}	
		}
		
		//Assert.assertEquals(allProNo, productno);
	}
}


