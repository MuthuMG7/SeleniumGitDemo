package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	public WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	private WebElement userEmail;
	
	@FindBy(css=".btn.btn-primary.btn-md.login-button")
	private WebElement instruction;
	
	public WebElement getUserEmail() {
		return userEmail;
	}
	
	public WebElement getInstruction() {
		return instruction;
	}
	
}
