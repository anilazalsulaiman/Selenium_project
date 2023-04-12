package obsquraWebsites;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String locatevalue = null;
		String locatevalue1 = null;
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		List<WebElement> rowValueTable = driver
				.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));

		for (int i = 0; i < rowValueTable.size(); i++) {
			if (rowValueTable.get(i).getText().equals("Cedric Kelly")) {
				locatevalue = "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td[1]";
				// locatevalue = "//table[@id='dtBasicExample']//tbody//tr["+(i+1)+"]//td";
			}
			if (rowValueTable.get(i).getText().equals("Herrod Chandler")) {
				locatevalue1 = "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td[3]";
				break;
			}
		}
		WebElement verify_Table_Row = driver.findElement(By.xpath(locatevalue));
		System.out.println(verify_Table_Row.getText());

		WebElement verify_office_detail = driver.findElement(By.xpath(locatevalue1));
		System.out.println(verify_office_detail.getText());

		// DOUBT (print all column values in selected row)
//		List<WebElement> verify_Table_Row = driver.findElements(By.xpath(locatevalue));
//		for(int j=0;j<verify_Table_Row.size();j++) {
//			String storeTableValue=verify_Table_Row.get(j).getText();
//			System.out.println(storeTableValue);
//		}

	}

}
