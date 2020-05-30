package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods {
	
	
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();	
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();	
	}
	@Test
	public void titleValidation() {
		
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
	}
	@Test
	public void logoValidation() {
		String logoPath="//div[@id='divLogo']/img";
		WebElement logo = driver.findElement(By.xpath(logoPath));
		boolean isDisplayed = logo.isDisplayed();
		if(isDisplayed) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
			
	}
	@Test
	public void loginValidation() {
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username,ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(username,ConfigsReader.getProperty("password"));
		WebElement login = driver.findElement(By.id("btnLogin"));
		click(login);
		
		WebElement welcome = driver.findElement(By.xpath("//a[@class='panelTrigger']"));
		boolean isDisplayed2=welcome.isDisplayed();
		if(isDisplayed2) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}
}
