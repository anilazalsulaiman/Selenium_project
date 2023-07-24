package eR_POM_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMwithoutPageFactory {
	WebDriver driver;
	
	public POMwithoutPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By userName=By.id("loginform-username"); //Without page factory
	By password=By.id("loginform-password");
	By click_Submit=By.xpath("//button[@name='login-button']");

	
	public void enter_Username() {
		driver.findElement(userName).sendKeys("carol");
	}
	public void enter_Password() {
		driver.findElement(password).sendKeys("1q2w3e4r");
	}
	public void click_Submit() {
		driver.findElement(click_Submit).click();
	}
}
