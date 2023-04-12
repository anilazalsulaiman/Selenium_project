package webElement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		String parentWindowId=driver.getWindowHandle(); //parent window id
		System.out.println(parentWindowId);
		
		WebElement newTab =driver.findElement(By.id("tabButton"));
		newTab.click();
		Set<String> allWindowsId=driver.getWindowHandles();
		System.out.println(allWindowsId);
		for(String childWindow : allWindowsId) {
			if(!parentWindowId.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement newTabText=driver.findElement(By.id("sampleHeading"));
				String storeText=newTabText.getText();
				System.out.println(storeText);
			}
		}
		driver.switchTo().window(parentWindowId);
		
		
//		WebElement newTabText=driver.findElement(By.id("sampleHeading"));
//		String storeText=newTabText.getText();
//		System.out.println(storeText);

	}

}
