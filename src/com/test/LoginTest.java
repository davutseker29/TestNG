package com.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test
	public void adminLogin() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected = "Welcome Admin";
		String actual = dashboard.welcome.getText();
		Assert.assertEquals(expected, actual, "Admin is NOT Logged in");
		System.out.println("Admin Log in Successful");
		Assert.assertTrue(actual.contains(ConfigsReader.getProperty("username")));

	}

	@Test
	public void invalidPasswordLogin() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "sadadad");
		click(login.loginBtn);

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		System.out.println("InvalidPasswordLogin passed");
	}

	@Test(enabled = true)
	public void emptyUsernameLogin() {

		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected = "Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");

	}
}
