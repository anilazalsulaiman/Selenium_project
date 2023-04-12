package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1"); //switch to frame using name or id
//		driver.switchTo().frame("");
		WebElement iframeText=driver.findElement(By.id("sampleHeading"));
		String storeiframeText=iframeText.getText();
		System.out.println(storeiframeText);
		
		driver.switchTo().parentFrame(); //switch from frame to main page
		//driver.switchTo().defaultContent(); //switch from frame to main page
		
	}

}
