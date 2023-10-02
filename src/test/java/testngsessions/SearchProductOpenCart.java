package testngsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchProductOpenCart {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		 driver = new ChromeDriver();
		 driver.get("https://naveenautomationlabs.com/opencart/");
		 driver.manage().window().maximize();
		
		}

		
		
	}
	


