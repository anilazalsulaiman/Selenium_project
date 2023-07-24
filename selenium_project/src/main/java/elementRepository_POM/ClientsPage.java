package elementRepository_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientsPage {
	WebDriver driver;
	
	public ClientsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By client_Tab=By.linkText("Clients");
	By search_Button=By.xpath("//button[@type='submit']");
	
	
	public void click_Client_Tab() {
		driver.findElement(client_Tab).click();
	}
	
	public String get_ClientsTab_SearchButton_Text() {
	String check_Text_searchButton=driver.findElement(search_Button).getText();	
	return check_Text_searchButton;
	}

}
