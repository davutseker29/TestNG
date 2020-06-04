package com.review;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class SauceDemoTest extends CommonMethods {

	@Test (dataProvider="dataProvider",groups="smoke")
	public void test(String username, String password) {
		sendText(sauce.username,username);
		sendText(sauce.password,password);
		sauce.jsClick(sauce.loginBtn);
		wait(2);
		

		
	}
	@DataProvider(name="dataProvider")
	public Object[][] getData() {
		
		Object [][] data=new Object[4][2];
		
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		
		data[2][0]="performance_glitch_user";
		data[2][1]="secret_sauce";
		
		data[3][0]="locked_put_user";
		data[3][1]="secret_sauce";
		
		
		
		
		return data;
		
		
		
		
	
	}
	
	
}
