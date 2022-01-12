package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(linkText="Login")
	private WebElement logIn;
	
	@FindBy(css=".text-center h2")
	private WebElement title;
	
	@FindBy(css=".nav.navbar-nav.navbar-right li a")
	private WebElement navBar;
	
	@FindBy(css="div[class*='video-banner'] h3")
	private WebElement header;
	
	public LogInPage getLogIn() {
	    logIn.click();
	    return new LogInPage(driver);
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getNavBar() {
		return navBar;
	}
	
	public WebElement getHeader() {
		return header;
	}
	
}
