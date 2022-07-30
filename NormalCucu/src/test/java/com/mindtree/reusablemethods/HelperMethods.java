package com.mindtree.reusablemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.utilities.BaseClass;

public class HelperMethods extends BaseClass {

   //public WebDriver driver;
//    public HelperMethods(WebDriver driver) {
//    	this.driver=driver;
//    }
	
	public  void Click(By path) {
		try{
			driver.findElement(path).click();
		}catch(Exception e) {
			
		}
	}
	
	public void SendKeys(By path,String value) {
	try {
		driver.findElement(path).sendKeys(value);
	}catch(Exception e) {
		
	}
	}
	
	public void pressEnter(By path) {
		driver.findElement(path).sendKeys(Keys.ENTER);
	}
	
	public boolean displayed(By path) {
		return driver.findElement(path).isDisplayed();
	}
}
