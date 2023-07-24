package eRepositor_Assert_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class ClientPageWithPF {

	WebDriver driver;

	public ClientPageWithPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Clients")
	WebElement client_Tab;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search_Button;

	public void click_Client_Tab() {
		client_Tab.click();
	}

	public String get_ClientsTab_SearchButton_Text() {
		String check_Text_searchButton = search_Button.getText();
		return check_Text_searchButton;
	}

	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement create_Client_Button;

	public void click_Create_Client_Button() {
		create_Client_Button.click();
	}

	@FindBy(id = "client-invoice_order")
	WebElement invoice_order_DropDown;

	public String get_ClientTab_CreateClient_Dropdown_InvoiceOrder() {

		Select drp_value = new Select(invoice_order_DropDown);
		drp_value.selectByVisibleText("Multi timesheet per client");
		WebElement SelectedValue = drp_value.getFirstSelectedOption();
		String print_value = SelectedValue.getText();
		return print_value;
	}

	@FindBy(id = "client-require_po")
	WebElement checkbox_check;

	public void get_ClientsTab_CreateClient_Checkbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		checkbox_check.click();
	}

	public boolean check_ClientsTab_CreateClient_checkbox_isselected() {
		boolean actual_result = checkbox_check.isSelected();
		return actual_result;
	}

}
