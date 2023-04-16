package obsquraWebsites;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Workers")));
		WebElement workers_Click = driver.findElement(By.linkText("Workers"));
		workers_Click.click();

		wait.until(ExpectedConditions.textToBe(By.xpath("//button[@type='submit']"), "Search"));

		WebElement workersDelete = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[8]//a[3]//span"));
		workersDelete.click();
		wait.until(ExpectedConditions.alertIsPresent());
		

	}

}
