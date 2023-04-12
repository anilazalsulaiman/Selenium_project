package webElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicTableValues {

	public static void main(String[] args) {
		String locate=null;
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();

		List<WebElement> DynamicList = driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
		
		for (int i = 0; i < DynamicList.size(); i++) {
			if (DynamicList.get(i).getText().equals("Garrett Winters")) {
				locate="//table[@id='dtBasicExample']//tbody//tr["+(i+1)+"]//td[4]";
				break;
			}
		}
		WebElement ageVerify=driver.findElement(By.xpath(locate));
		System.out.println(ageVerify.getText());

	}

}
