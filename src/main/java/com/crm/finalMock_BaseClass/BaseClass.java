package com.crm.finalMock_BaseClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.pom.HomePage;
import com.crm.pom.LoginPage;

import JavaUtility.CommonData;

public class BaseClass {
public static WebDriver driver;
	
	CommonData commonData = new CommonData();

	@BeforeClass
	public void preCondition() throws IOException {

		String browser = commonData.data("browser");
		String url = commonData.data("url");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("fireFox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(url);
		
		assertEquals(url, driver.getCurrentUrl(),"The Verification is failed");
	}
	
	@BeforeMethod
	public void login() throws IOException {
		HomePage homePage=new HomePage(driver);
		homePage.loginLink();
		
		String username=commonData.data("username");
		String password=commonData.data("pwd");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		Thread.sleep(2000);
		homePage.logout();
	}
}
