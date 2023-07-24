package elementRepository_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//web elements of login page + functions
	By userName=By.id("loginform-username"); //without page factory
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
