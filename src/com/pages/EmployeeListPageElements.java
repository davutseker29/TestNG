package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.CommonMethods;

public class EmployeeListPageElements extends CommonMethods {

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement idInfo;

	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
