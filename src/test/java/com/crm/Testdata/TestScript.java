package com.crm.Testdata;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.finalMock_BaseClass.BaseClass;
import com.crm.pom.HomePage;
import com.crm.pom.TwitterPOM;

import JavaUtility.TestData;

public class TestScript extends BaseClass {
	@Test
	public void testCase() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String parentHandle=driver.getWindowHandle();
		
		WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(100));
		
		Actions actions=new Actions(driver);
		
		actions.keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).perform();
		
		HomePage homePage=new HomePage(driver);
		driverWait.until(ExpectedConditions.elementToBeClickable(homePage.twitterLink()));
		homePage.twitterLink().click();
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		for(String string: handles) {
			driver.switchTo().window(string);
			if(!string.equals(parentHandle)) {

				TestData data=new TestData();
				String name=data.data("Sheet1", 0, 0);
				String email=data.data("Sheet1", 0, 1);
				String month=data.data("Sheet1", 0, 2);
				String day=data.data("Sheet1", 0, 3);
				String year=data.data("Sheet1", 0, 4);
			
				month=String.valueOf((int)Double.parseDouble(month));
				day=String.valueOf((int)Double.parseDouble(day));
				year=String.valueOf((int)Double.parseDouble(year));
				
				TwitterPOM twitterPOM=new TwitterPOM(driver);
				
				driverWait.until(ExpectedConditions.elementToBeClickable(twitterPOM.createAccountLink()));
				twitterPOM.createAccountLink().click();
				
				twitterPOM.name(name);
				
				twitterPOM.email(email);
				
//				Exception StaleElementException
				twitterPOM.monthDropDown(month);
				twitterPOM.dayDropDown(day);
				twitterPOM.yearDropDown(year);
				Thread.sleep(2000);
				break;
			}
		}
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

}
