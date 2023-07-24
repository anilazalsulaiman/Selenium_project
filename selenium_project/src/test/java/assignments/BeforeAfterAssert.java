package assignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BeforeAfterAssert {
	WebDriver driver;

	@Test
	public void verify_WorkersTab_DeleteButton_ToolTip() {
		WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Workers"));
		clientsButton.click();
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
		String print_Tooltip_value = Verify_tooltip_delete.getAttribute("title"); // DOUBT -Not getting in console

		String exepectedResult = "Delete";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(print_Tooltip_value, exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();
		System.out.println(print_Tooltip_value); // DOUBT - not getting in console everytime
	}

	@Test
	public void verify_WorkersTab_Text_SearchButton() {
		WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Workers"));
		clientsButton.click();

		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		String exepectedResult = "Search";
		String actualResult = searchButton.getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();
	}

	@Test
	public void verify_WorkersTab_SearchButton_BGcolor() {
		WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Workers"));
		clientsButton.click();

		WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
		// String exepectedResult = "rgb(51, 122, 183)"; //DOUBT
		String exepectedResult = "rgba(51, 122, 183, 1)";
		String actualResult = searchButton.getCssValue("background-color");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();
	}

	@Test
	public void verify_ClientTab_CreateClient_Dropdown_InvoiceOrder() {
		WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Clients"));
		clientsButton.click();
		WebElement click_create_Client_SubTab = driver.findElement(By.xpath("//a[@href='/payrollapp/client/create']"));
		click_create_Client_SubTab.click();

		WebElement dropdown = driver.findElement(By.id("client-invoice_order"));
		Select drp_value = new Select(dropdown);
		drp_value.selectByVisibleText("Multi timesheet per client");

		WebElement SelectedValue = drp_value.getFirstSelectedOption();
		String print_value = SelectedValue.getText();

		String exepectedResult = "Multi timesheet per client";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(print_value, exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();
		System.out.println(print_value);

	}

	@Test
	public void verify_ClientsTab_CreateClient_Checkbox() throws InterruptedException {
		WebElement username = driver.findElement(By.id("loginform-username"));

		username.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement clickSubmit = driver.findElement(By.xpath("//button[@name='login-button']"));
		clickSubmit.click();
		WebElement clientsButton = driver.findElement(By.linkText("Clients"));
		clientsButton.click();
		WebElement click_create_Client_SubTab = driver.findElement(By.xpath("//a[@href='/payrollapp/client/create']"));
		click_create_Client_SubTab.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");

		WebElement checkbox_check = driver.findElement(By.xpath("//input[@id='client-require_po']"));
		checkbox_check.click(); 
		boolean actual_result = checkbox_check.isSelected();
		boolean exepectedResult = true;
		
		
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual_result, exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();

	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
