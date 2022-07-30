package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocater {

//	public WebElement Username;
//	public WebElement Password;
//	public WebElement Login;
//	public LoginPageLocater(WebDriver driver) {
//		this.Username=driver.findElement(By.xpath("//input[@type='text']"));
//	    this.Password=driver.findElement(By.xpath("//input[@type='password'][1]"));	
//	    this.Login=driver.findElement(By.xpath("//a[@id=\"loginButton\"][1]"));
//	}
	
	public static By Username = By.xpath("//input[@type='text']");
	public static By Password = By.xpath("//input[@type='password'][1]");
	public static By Login = By.xpath("//a[@id=\"loginButton\"][1]");

}
