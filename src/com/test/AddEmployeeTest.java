package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;

public class AddEmployeeTest extends CommonMethods {
	
	
	@Test
	public void AddEmployeeTest() {
	
		LoginPageElements login=new LoginPageElements();
		
		login.login("Admin", "Hum@nhrm123");
		WebElement pimLink = driver.findElement(By.xpath("//b[text()='PIM']"));
		click(pimLink);
		WebElement employeeList = driver.findElement(By.id("menu_pim_addEmployee"));
		click(employeeList);
		
		String expected="Add Employee";
		Assert.assertEquals(expected, driver.findElement(By.xpath("//h1[text()='Add Employee']")).getText(), "not matched");
		
	}
}
