package com.review;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class sauceDemoTask extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {

		setUp();
	driver.manage().window().maximize();
	
	}
	@AfterMethod
	public void closeBrowser() {
		
		tearDown();
	}
	@Test(priority=1)
	public void login() {
		
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement btn = driver.findElement(By.xpath("//input[@class='btn_action']"));
		click(btn);
	}
	@Test (priority=2)
	public void verigfLogin() {
		login();
		String actualTitle="Products";
		
		WebElement expectedTitle = driver.findElement(By.xpath("//div[@class='product_label']"));
		String text=expectedTitle.getText();
		
		Assert.assertEquals(actualTitle, text);
		System.out.println("print if they same");
		
	}
	@Test(priority=3)
	public void select() {
		login();
		WebElement DD = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select select=new Select(DD);
		select.selectByIndex(3);
		
		
	}

}
