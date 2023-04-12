package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();
		
		WebElement checkboxRead=driver.findElement(By.id("gridCheck"));
		checkboxRead.click();
		boolean check=checkboxRead.isSelected(); //to check selection in radio or check boxes
		System.out.println(check);
		
//		boolean checkisenabled=checkboxRead.isEnabled(); //enabled/disabled 
//		System.out.println(checkisenabled);
		
//		boolean checkisdisplayed=checkboxRead.isDisplayed(); //for element present or not
//		System.out.println(checkisdisplayed);
	}

}
