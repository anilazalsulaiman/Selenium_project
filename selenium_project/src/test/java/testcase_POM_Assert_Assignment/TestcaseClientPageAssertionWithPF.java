package testcase_POM_Assert_Assignment;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import eRepositor_Assert_Assignment.ClientPageWithPF;
import eRepositor_Assert_Assignment.LoginAssertionWithPF;
import eRepositor_Assert_Assignment.WorkersPageWithPF;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;

public class TestcaseClientPageAssertionWithPF {
	WebDriver driver;

	@Test
	public void verify_ClientsTab_SearchButton_Text() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		ClientPageWithPF cp_obj = new ClientPageWithPF(driver);
		cp_obj.click_Client_Tab();
	}

	@Test
	public void verify_ClientTab_CreateClient_Dropdown_InvoiceOrder() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		ClientPageWithPF cp_obj = new ClientPageWithPF(driver);
		cp_obj.click_Client_Tab();
		cp_obj.click_Create_Client_Button();

		String exepectedResult = "Multi timesheet per client";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(cp_obj.get_ClientTab_CreateClient_Dropdown_InvoiceOrder(), exepectedResult,
				"Not matching");
		System.out.println("***************");
		softAssert.assertAll();
	}

	@Test
	public void verify_ClientsTab_CreateClient_Checkbox() {
		LoginAssertionWithPF lp_obj = new LoginAssertionWithPF(driver);
		lp_obj.enter_Username("carol");
		lp_obj.enter_Password("1q2w3e4r");
		lp_obj.click_Submit();

		ClientPageWithPF cp_obj = new ClientPageWithPF(driver);
		cp_obj.click_Client_Tab();
		cp_obj.click_Create_Client_Button();
		cp_obj.get_ClientsTab_CreateClient_Checkbox();
		boolean exepectedResult = true;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(cp_obj.check_ClientsTab_CreateClient_checkbox_isselected(), exepectedResult,
				"Not matching");
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
