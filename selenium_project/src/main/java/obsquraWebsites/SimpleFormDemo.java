package obsquraWebsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleFormDemo {
	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();

		WebElement message = driver.findElement(By.id("single-input-field"));
		message.sendKeys("test message");

		WebElement messageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		messageButton.click();

		WebElement valueA = driver.findElement(By.id("value-a"));
		valueA.sendKeys("2");

		WebElement valueB = driver.findElement(By.id("value-b"));
		valueB.sendKeys("3");

		WebElement getTotalButton = driver.findElement(By.xpath("//button[@id='button-two']"));
		getTotalButton.click();

		String messageButtonText = messageButton.getText();
		System.out.println(messageButtonText);

		String getTotalButtonText = getTotalButton.getText();
		System.out.println(getTotalButtonText);

		String messageButtonBcolor = messageButton.getCssValue("background-color");
		System.out.println(messageButtonBcolor);

		String messageButtonFontcolor = messageButton.getCssValue("color");
		System.out.println(messageButtonFontcolor);

		String messageButtonVerifyClass = messageButton.getAttribute("class");
		System.out.println(messageButtonVerifyClass);

		String messageButtonVerifyID = messageButton.getAttribute("id");
		System.out.println(messageButtonVerifyID);

	}

}
