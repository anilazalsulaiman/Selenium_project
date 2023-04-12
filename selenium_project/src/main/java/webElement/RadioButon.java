package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.manage().window().maximize();

		WebElement radiobutton = driver.findElement(By.id("inlineRadio1"));
		radiobutton.click();

		boolean checkradiobutton = radiobutton.isSelected();
		System.out.println(checkradiobutton);
		String radioButtontagname = radiobutton.getTagName();
		System.out.println(radioButtontagname);

		WebElement showvalueButton = driver.findElement(By.id("button-one"));
		String buttontagname = showvalueButton.getTagName();
		System.out.println(buttontagname);

	}

}
