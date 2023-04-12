package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
//		3 types wait 
//		Implicit Wait - WebDriver wait till page complete loads (High level verification), Only one time declare because its comming from driver
//		Explicit Wait - WebDriver wait till apecified element loads
//		Fluent Wait - 
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); //Select first implicitWait(Selenium 4),Duration is Java class
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("loginform-username"));
		username.sendKeys("carol");
		
		WebElement password=driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		
		WebElement clickSubmit=driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000)); //Explicit Wait
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Clients"))); //expected condition is static so direct call the inbuilt presence method
		WebElement clientsButton=driver.findElement(By.linkText("Clients"));
		clientsButton.click();

		
		
		
	}

}
