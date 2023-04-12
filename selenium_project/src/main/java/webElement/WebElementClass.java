package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebElementClass {
	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		
		WebElement userName=driver.findElement(By.id("loginform-username"));
		userName.sendKeys("test textbox");
		
		WebElement password=driver.findElement(By.id("loginform-password"));
		password.sendKeys("password");
		
		//tagName[@attributeType='attributeValue'] //to find xpath
		//WebElement loginButton=driver.findElement(By.xpath("//button[@name='login-button']"));
		WebElement loginButton=driver.findElement(By.cssSelector("button.btn-default"));
		loginButton.click();
		userName.clear();
		password.clear(); //to clear field
		
		
		
		String textValue=loginButton.getText(); //to get the visible value
		System.out.println(textValue);
		
		String cssValue=loginButton.getCssValue("font-family"); //to get the css property values
		System.out.println(cssValue);
		
		String attributevalue=loginButton.getAttribute("name"); //to get the values by giving attribute type
		System.out.println(attributevalue);
		
		String tagname=loginButton.getTagName();
		System.out.println(tagname);
		
	}
}
