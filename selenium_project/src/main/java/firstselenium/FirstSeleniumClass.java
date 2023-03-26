package firstselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ChromeOptions ops = new ChromeOptions(); 
//		ops.addArguments("--remote-allow-origins=*");
//		System.getProperty("webdriver.chrome.driver","F:\\Anilaz Projects\\Software Testing\\Selenium Automation\\Installation softwares\\Chromedriver\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver(ops);
		// WebDriver driver=new FirefoxDriver();

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/"); // page waits
		// driver.navigate().to("https://www.amazon.in/"); //page will not wait for page load

		String title = driver.getTitle();
		System.out.println(title);

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// String pageSource=driver.getPageSource(); //HTML code
		// System.out.println(pageSource);

		driver.manage().window().maximize(); // window maximize and minimize

		driver.navigate().back(); // back
		driver.navigate().forward(); // forward
		driver.navigate().refresh(); // refresh

		// driver.close(); // current or focused window only close
		driver.quit(); // all windows will close including web driver instance

	}

}
