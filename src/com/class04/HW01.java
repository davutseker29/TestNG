package com.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HW01 extends CommonMethods {

	@Test(dataProvider = "getData")
	public void login(String firstname, String lastname, String username, String password) {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);

		dashboard.PIM.click();
		dashboard.addEmp.click();

		boolean displayed = dashboard.welcome.isDisplayed();
		Assert.assertTrue(displayed, "not displayed");
		addEmp.checkboxLoginDetails.click();

		String actual = addEmp.employeeId.getAttribute("value");
		sendText(addEmp.firstName, firstname);
		sendText(addEmp.lastName, lastname);
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);

		selectDdValue(addEmp.status, 1);

		addEmp.saveBtn.click();

		waitForVisibility(pdetails.employeeId);
		takeScreenshot(firstname+"_"+lastname);
		String expected = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actual, expected, "not matched");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = { { "ali", "veli", "aliVeli033", "Atlanta02!,," }, { "ziya", "liko", "ziyaliko044", "Atlanta01!,," },
				{ "vedat", "kaan", "kaanvedat067", "Atlanta03!,," }, { "pamir", "sedat", "pamirsedat095", "Atlanta03!,," },

		};

		return data;
	}

}
