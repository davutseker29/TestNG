package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class AssertClassDemo extends CommonMethods {

	@Test
	public void titleValidation() {
		
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);;
		
	}

}
