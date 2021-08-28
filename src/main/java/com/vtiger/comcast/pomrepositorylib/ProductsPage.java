package com.vtiger.comcast.pomrepositorylib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage{

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	public WebElement getCreateProductImg() {
		return createProductImg;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductImg;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtextfield;
	
	@FindBy(id="bas_searchfield")
	private WebElement indropdown;
	
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Product Name']")
	private WebElement productname;
	
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Product No']")
	private WebElement productno;
	
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Part Number']")
	private WebElement partno;
	
	@FindBy(xpath="//select[@id='bas_searchfield']//option[text()='Commission Rate']")
	private WebElement commisionrate;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/descendant::span[@vtfieldname='product_no']/..")
	private List<WebElement> productnotext;
	public List<WebElement> getProductnotext() {
		return productnotext;
	}
	public WebElement getCommisionrate() {
		return commisionrate;
	}
	public WebElement getPartno() {
		return partno;
	}
	
	
	@FindBy(name="submit")
	private WebElement submitbutton;
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public WebElement getSearchtextfield() {
		return searchtextfield;
	}
	public WebElement getIndropdown() {
		return indropdown;
	}
	public WebElement getProductname() {
		return productname;
	}
	public WebElement getProductno() {
		return productno;
	}
	public WebElement getCreateOrgImg() {
		return createProductImg;
	}
	
	
}
