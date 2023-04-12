package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseEvents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		
		WebElement doubleclickbtn=driver.findElement(By.id("doubleClickBtn"));
		Actions action=new Actions(driver); //Action is class and web driver parameter
//		action.doubleClick(); // click anywhere in the screen,using method overloading (same method two purpose)
		action.doubleClick(doubleclickbtn).perform();
		
		WebElement rightclickbtn=driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightclickbtn).perform();
		
		action.moveToElement(rightclickbtn).perform();
		
		action.sendKeys(Keys.ARROW_DOWN).perform();//keyboard static methods
		
		

	}

}
