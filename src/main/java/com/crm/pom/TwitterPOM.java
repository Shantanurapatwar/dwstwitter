package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TwitterPOM {
public Select select;
	
	public TwitterPOM(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create account']")
	private WebElement createAccountLink;
	
	@FindBy(xpath ="//input[@name='name']" )
	private WebElement name;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(id ="SELECTOR_1" )
	private WebElement month;
	
	@FindBy(id ="SELECTOR_2" )
	private WebElement day;
	
	@FindBy(id ="SELECTOR_3" )
	private WebElement year;
	
	
	public WebElement createAccountLink() {
		return createAccountLink;
	}
	
	public void name(String name) {
		this.name.sendKeys(name);
	}
	
	public void email(String email) {
		this.email.sendKeys(email);
	}
	
	public void monthDropDown(String value) {
		select=new Select(month);
		select.selectByValue(value);
	}
	
	public void dayDropDown(String value) {
		select=new Select(day);
		select.selectByValue(value);
	}
	
	public void yearDropDown(String value) {
		select=new Select(year);
		select.selectByValue(value);
	}
	
}
