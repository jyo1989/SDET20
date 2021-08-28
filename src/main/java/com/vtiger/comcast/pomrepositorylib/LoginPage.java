package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {		//Rule 1:Create a separate java class for every page in a application
WebDriver driver;
	public LoginPage(WebDriver driver) {
	//Rule 3: Execute all the elements & initialize the elements using PageFactory.initElements (initialization)
	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule 2: Identify all the elements using @FindBy & FindBys, @FindAll (Declaration)

	@FindBy(name="user_name")		
	private WebElement userNameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	//@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	@FindBy(id="submitButton")
	private WebElement loginBtn;


	
	//Rule 4:Declare all the elements as private & provide getters method, business method for (Utilization)
	
	public WebDriver getDriver() {
		return driver;
	}

	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Function To Login To the Application
	public void loginToApp(String userName, String password)
	{
		
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		
		loginBtn.click();
		
	}
	
	
	
}
