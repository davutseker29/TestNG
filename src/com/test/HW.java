package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HW extends CommonMethods {

	// US 12678 As an Admin I should be able to create login credentials while
	// adding employee

	@Test
	public void login() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);

		String actual = dashboard.welcome.getText();
		String expected = "Welcome Admin";
		Assert.assertEquals(actual, expected, "not verified");

	}

	@Test
	public void addEmployee() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);

		dashboard.PIM.click();
		dashboard.addEmp.click();

		sendText(addEmp.firstName, "LAZ");
		sendText(addEmp.lastName, "ZIYA");
		addEmp.checkboxLoginDetails.click();

		sendText(addEmp.username, "FerdiBaba654");
		sendText(addEmp.password, "Antalya07,,");
		sendText(addEmp.confirmPassword, "Antalya07,,");
		selectDdValue(addEmp.status, "Disabled");

		jsClick(addEmp.saveBtn);
		wait(3);
		String actual=empList.idInfo.getText();
		String expected="LAZ ZIYA";
		Assert.assertEquals(actual, expected);
	}

}
