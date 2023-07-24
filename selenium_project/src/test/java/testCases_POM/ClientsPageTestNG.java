package testCases_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository_POM.ClientsPage;
import elementRepository_POM.LoginPage;

public class ClientsPageTestNG {
	WebDriver driver;

	@Test
	public void verify_ClientsTab_SearchButton_Text() {
		LoginPage lp_obj = new LoginPage(driver);
		lp_obj.enter_Username();
		lp_obj.enter_Password();
		lp_obj.click_Submit();

		ClientsPage cl_page_obj = new ClientsPage(driver);
		cl_page_obj.click_Client_Tab();

		String exepectedResult = "Search";
		String actualResult = cl_page_obj.get_ClientsTab_SearchButton_Text();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualResult, exepectedResult, "Not matching");
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
