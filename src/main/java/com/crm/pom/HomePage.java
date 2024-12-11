package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-login")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[text()='Twitter']")
	private WebElement twitterLink;
	
	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutLink;
	
	public void loginLink() {
		loginLink.click();
	}
	
	public WebElement twitterLink() {
		return twitterLink;
	}
	
	public void logout() {
		logoutLink.click();
	}
}
