package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	public WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	private WebElement Email;

	@FindBy(name = " password")
	private WebElement password;

	@FindBy(css = "[value='Log In']")
	private WebElement logIn;

	@FindBy(css = "[href*='password/new']")
	private WebElement forgotPassword;
	

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogIn() {
		return logIn;
	}
	
	public ForgotPasswordPage getForgotPassword() {
		forgotPassword.click();
		return new ForgotPasswordPage(driver);
	}

}
