package com.ae.qa.pagesTenantAdmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ae.qa.base.TestBase;

public class LoginPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	// PageFactory
	@FindBy(xpath = "//input[@id='uname']")
	WebElement username;
	@FindBy(xpath = "//input[@id='pswd']")
	WebElement password;
	@FindBy(xpath = "//button[@id='signin']")
	WebElement signInBtn;
	@FindBy(xpath = "//span[contains(text(),'Forgot')]")
	WebElement forgotPwsdLink;
	@FindBy(xpath = "//title")
	WebElement pageTitle;

	// initialize all this Object Repository
	public LoginPageTA() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// return type is object of TenantPage
	public void login(String un, String pswd) throws Exception {
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pswd);
		wait.until(ExpectedConditions.visibilityOf(signInBtn));
		signInBtn.click();
	}

}
