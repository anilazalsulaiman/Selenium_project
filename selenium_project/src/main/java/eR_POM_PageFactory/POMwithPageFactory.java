package eR_POM_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMwithPageFactory {
WebDriver driver;
	public POMwithPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="loginform-username") //With page factory
	WebElement userName;
	@FindBy(id="loginform-password")
	WebElement password;
	@FindBy(xpath ="//button[@name='login-button']")
	WebElement click_Submit;
	
	public void enter_Username(String userNameText) { //instance method
		userName.sendKeys(userNameText);
	}
	public void enter_Password(String passwordText) {
		password.sendKeys(passwordText);
	}
	public void click_Submit() {
		click_Submit.click();
	}
}
