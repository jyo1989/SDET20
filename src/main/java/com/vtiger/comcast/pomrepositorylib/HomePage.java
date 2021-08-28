package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;     //global driver variable
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	//Identifying Quickcreate Dropdown
		@FindBy(id="qccombo")
		private WebElement quickCreateEdt;
		
	//Identifying New Product from the drop down
		@FindBy(xpath="//options[@value='Products']")
		private WebElement newProductOpt;
		
	//Switching to Create Product Window
		//@FindBy(xpath="//")
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signOutLink;
		
	
	public WebDriver getDriver() {
			return driver;
		}
		public  WebElement getQuickCreateEdt() {
			return quickCreateEdt;
		}
		public WebElement getNewProductOpt() {
			return newProductOpt;
		}

	
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getQuickCreate() {
		return quickCreateEdt;
	}
	
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	//Function To Select New Product From Quick Create Dropdown.
//		public void quickCreate()
//		{
//			quickCreateEdt.click();
//			newProductOpt.click();
//			
//		}

	
	public void logOut() {
		Actions actions=new Actions(driver);
		actions.moveToElement(administratorImg).perform();
		signOutLink.click();
	}
	
}
