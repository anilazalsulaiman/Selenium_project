package eRepositor_Assert_Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class WorkersPageWithPF {
	WebDriver driver;

	public WorkersPageWithPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Workers")
	WebElement workers_Tab;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search_Button;

	public void click_Workers_Tab() {
		workers_Tab.click();
	}

	public String get_WorkersTab_DeleteButton_ToolTip() {
		List<WebElement> DynamicList = driver
				.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[2]"));
		String locate = null;
		for (int i = 0; i < DynamicList.size(); i++) {
			if (DynamicList.get(i).getText().equals("Dennis Benny")) {
				locate = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1)
						+ "]//td[8]//a[3]";
				break;
			}
		}
		WebElement Verify_tooltip_delete = driver.findElement(By.xpath(locate));
		String print_Tooltip_value = Verify_tooltip_delete.getAttribute("title");
		return print_Tooltip_value;
	}

	public String get_WorkersTab_SearchButton_Text() {
		String check_Text_searchButton = search_Button.getText();
		return check_Text_searchButton;
	}

	public String get_WorkersTab_SearchButton_BGcolor() {
		String actualResult = search_Button.getCssValue("background-color");
		return actualResult;
	}
}
