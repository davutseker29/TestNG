package com.class02;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Task02 extends CommonMethods {

	/*
	 * Open application Verify Logo is displayed Enter valid credentials Verify user
	 * successfully logged in by verifying "Welcome" message
	 */

	@Test(priority = 1)
	public void logoDisplayed() {

		boolean logoDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(logoDisplayed, "Logo is not displayed");

	}

	@Test(priority = 2, dependsOnMethods = { "logoDisplayed" })

	public void signIn() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		String actual = driver.getTitle();
		String expected = "Human Management System";

		Assert.assertEquals(actual, expected, "Not true");

	}

	@Test(priority = 3, dependsOnMethods = { "signIn" })
	public void verification() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		boolean rightPage = dashboard.welcome.isDisplayed();

		Assert.assertTrue(rightPage, "Wrong Page");

	}

}
