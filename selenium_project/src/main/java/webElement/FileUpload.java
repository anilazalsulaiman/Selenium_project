package webElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		driver.get("http://demo.guru99.com/selenium/upload/");
		driver.manage().window().maximize();
		
		Robot robot=new Robot(); //robot/keyEvent is the class
//		robot.keyPress(KeyEvent.VK_CONTROL); //for pressing any keyboard click 2 lines of code(virtual key "cntrl")
//		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
		Actions action=new Actions(driver);
		action.moveToElement(chooseFile).click().perform();

		//copy file path to clipboard --> press control --> press V --> press Enter Key
		//copy path to your system clipboard
	     StringSelection ss = new StringSelection("F:\\Anilaz Projects\\Software Testing\\Selenium Automation\\Programs\\Assignments word\\Selenium Assignment.docx");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement submit=driver.findElement(By.id("submitbutton"));
		submit.click();
	}

}
