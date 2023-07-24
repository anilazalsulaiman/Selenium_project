package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestClass {
	WebDriver driver;
  @Test
  public void verifyTextOfTheSearchButton() {
	  WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Clients"));
		clientsButton.click();
  }
  
  @BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String checkBrowser) {
		if (checkBrowser.equals("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
		} 
		else if (checkBrowser.equals("edge")) {
			EdgeOptions ops = new EdgeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(ops);

		}

		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
