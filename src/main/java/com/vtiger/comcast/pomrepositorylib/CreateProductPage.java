package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {


	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="productname")
	private WebElement productNameEdt;
	@FindBy(id="productcode")
	private WebElement partNumberEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	@FindBy(id="productcode")
	private WebElement partnumbertextfield;
	@FindBy(id="commissionrate")
	private WebElement commisiontextfield;
	
	
	public WebElement getPartnumbertextfield() {
		return partnumbertextfield;
	}

	public WebElement getCommisiontextfield() {
		return commisiontextfield;
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getPartNumberEdt() {
		return partNumberEdt;
	}

	
	public WebElement getSavebutton() {
		return savebutton;
	}


	

	
}
