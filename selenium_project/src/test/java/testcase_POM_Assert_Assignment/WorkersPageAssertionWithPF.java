package testcase_POM_Assert_Assignment;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import eRepositor_Assert_Assignment.LoginAssertionWithPF;
import eRepositor_Assert_Assignment.WorkersPageWithPF;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class WorkersPageAssertionWithPF {
	WebDriver driver;

	@Test
	public void verify_WorkersTab_SearchButton_Text() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		WorkersPageWithPF wp_obj = new WorkersPageWithPF(driver);
		wp_obj.click_Workers_Tab();
	}

	@Test
	public void verify_WorkersTab_DeleteButton_ToolTip() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		WorkersPageWithPF wp_obj = new WorkersPageWithPF(driver);
		wp_obj.click_Workers_Tab();

		String exepectedResult = "Delete";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(wp_obj.get_WorkersTab_DeleteButton_ToolTip(), exepectedResult, "Not matching");
		System.out.println("***************");
		softAssert.assertAll();
	}

	@Test
	public void verify_WorkersTab_SearchButton_BGcolor() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		WorkersPageWithPF wp_Search_BGcolor_obj = new WorkersPageWithPF(driver);
		wp_Search_BGcolor_obj.click_Workers_Tab();

		String exepectedResult = "rgba(51, 122, 183, 1)";
		String actualresult = wp_Search_BGcolor_obj.get_WorkersTab_SearchButton_BGcolor();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualresult, exepectedResult, "Not matching");
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
