package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	public ProductInformationPage(WebDriver driver) {
     PageFactory.initElements(driver, this);
	}
 
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successfullMsg;
	@FindBy(xpath="//td[text()='Product No']/following-sibling::td[@class='dvtCellInfo']")
	private WebElement productno;
	
	public WebElement getProductno() {
		return productno;
	}

	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
}
