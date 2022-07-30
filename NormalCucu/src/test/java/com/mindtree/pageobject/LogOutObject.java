package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablemethods.HelperMethods;
import com.mindtree.uistore.LogOutLocater;



public class LogOutObject {
	WebDriver driver;
	public LogOutObject(WebDriver driver) {
		this.driver=driver;
	}
	HelperMethods hm=new HelperMethods();
	public boolean clickButton(WebDriver driver) {
		 hm.Click(LogOutLocater.Logout);
		return true;
	}
}
