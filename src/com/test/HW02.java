package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HW02 extends CommonMethods {

	/*
	 * US 67789 As an admin while adding employee if I leave required fields empty I
	 * should see “Required” message Note: first name and last name are required
	 * fields
	 */
	@Test
	public void requiredCheck() {

		//logging in to the page
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		//navigating to the add employee page
		dashboard.PIM.click();
		dashboard.addEmp.click();
		
		
		sendText(addEmp.firstName, "Hacibumbala");
		jsClick(addEmp.saveBtn);
		
		String actual=addEmp.reqLastName.getText();
		String expected="Required";
		Assert.assertEquals(actual, expected);
		
	}

}
