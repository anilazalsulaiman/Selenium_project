package obsquraWebsites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		
		List<WebElement> tableList=driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]"));
		List<WebElement> tableListHeader=driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
		
		for(int i=0;i<tableList.size();i++) {
			String storeTableValues=tableList.get(i).getText();
			System.out.println(storeTableValues);
		}
		for(int j=0;j<tableListHeader.size();j++) {
			String storeTableHeaderValues=tableListHeader.get(j).getText();
			System.out.println(storeTableHeaderValues);
		}

	}

}
