package webElement;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3 types wait 
//		Implicit Wait - WebDriver wait till page complete loads (High level verification), Only one time declare because its comming from driver
//		Explicit Wait - WebDriver wait till a Specified element loads
//		Fluent Wait - polling interval time for specified time upto maximum time out
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");

//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); //Select first implicitWait(Selenium 4),Duration is Java class
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.id("loginform-username"));
		username.sendKeys("carol");

		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");

		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();

		// EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // Explicit Wait,presence of element
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Clients"))); // expected condition is
																								// static so direct call
																								// the inbuilt presence
																								// method
//		wait.until(ExpectedConditions.textToBe(By.xpath(""), "text value")); // text
//		wait.until(ExpectedConditions.alertIsPresent());//wait for alert present
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("")));
		WebElement clientsButton = driver.findElement(By.linkText("Clients"));
		clientsButton.click();

//		FLUENT WAIT
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L)) //maximum time out
			       .pollingEvery(Duration.ofSeconds(5L)) //check every  5 seconds/polling interval
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.className("btn btn-primary"));
			     }
			   });

	}

}
