package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Basetest;
import utilities.ReadXLSdata;

public class LoginTestFW extends Basetest{
	 
	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="zohodata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		
	
	driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); //locators--properties
	driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
	driver.findElement(By.xpath(loc.getProperty("next_button"))).click();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys( password);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	driver.findElement(By.xpath(loc.getProperty("login_nxt_button"))).click();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	
	}
	
	
}
