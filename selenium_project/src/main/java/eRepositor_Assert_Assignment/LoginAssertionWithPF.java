package eRepositor_Assert_Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAssertionWithPF {
	WebDriver driver;

	public LoginAssertionWithPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginform-username") // With page factory
	WebElement userName;
	@FindBy(id = "loginform-password")
	WebElement password;
	@FindBy(xpath = "//button[@name='login-button']")
	WebElement click_Submit;

	public void enter_Username(String userNameText) { // instance method
		userName.sendKeys(userNameText);
	}

	public void enter_Password(String passwordText) {
		password.sendKeys(passwordText);
	}

	public void click_Submit() {
		click_Submit.click();
	}
}
