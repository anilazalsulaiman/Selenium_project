package webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();

		WebElement dropdown = driver.findElement(By.id("single-input-field"));
		Select drp=new Select(dropdown);
//		drp.selectByIndex(1);
//		drp.selectByVisibleText("Yellow");
//		drp.selectByValue("Green");
//		WebElement drpSelectedValue=drp.getFirstSelectedOption();
//		String webelementstore=drpSelectedValue.getText();
//		System.out.println(webelementstore);
		
		WebElement multiDropdown=driver.findElement(By.id("multi-select-field"));
		Select multidrp=new Select(multiDropdown);
		multidrp.selectByValue("Red");
		multidrp.selectByIndex(1);
		List<WebElement> list=multidrp.getAllSelectedOptions();
		//System.out.println(list);
		for(int i=0;i<list.size();i++) {
			String getList=list.get(i).getText();
			System.out.println(getList);
		}
		

	}

}
