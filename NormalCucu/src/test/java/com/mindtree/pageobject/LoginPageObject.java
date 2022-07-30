package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablemethods.HelperMethods;
import com.mindtree.uistore.LoginPageLocater;

public class LoginPageObject {
	WebDriver driver;
	public  LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	HelperMethods hm=new HelperMethods();
	public void enterUsername(String uname) {
      		hm.SendKeys(LoginPageLocater.Username, uname);
	}

	public void enterPassword(String pwd) {
	       hm.SendKeys(LoginPageLocater.Password, pwd);
	}
	
	public void clickButton() {
	       hm.Click(LoginPageLocater.Login);
	}
}
