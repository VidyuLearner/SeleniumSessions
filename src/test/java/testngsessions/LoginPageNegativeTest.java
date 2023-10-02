package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest {
	
	public WebDriver driver;
	
	public boolean doLogin(String userName, String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(userName);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String errorMesg = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
		System.out.println(errorMesg);
		
		if(errorMesg.contains("No match for E-Mail Address and/or Password.")) {
			return true;
			
		}
		return false;
		
	}
	
	@DataProvider
	public Object[][] getLoginNegativeData() {
		return new Object [][] {
			{"aabcc@gmail.com", "testttt@123"},
			{"testtt@gmail.com", "testtttt@123"},
			{"abc", "rest@123"},
			{"resttt@123", " "}
		};
			
		}
	@DataProvider
	public Object[][] getRegTestData() {
		return new Object[][] {
			{"Heena","Vaghela", "heena@gmail.com", "9098765436", "heena@123"},
			{"veena","paghela", "veena@gmail.com", "9098765437", "Veena@123"},
			{"Seema","Gaghela", "Seema@gmail.com", "90987654389", "Seema@123"}
		};
			
		}
		
	@Test(dataProvider = "getRegTestData")
	public void registerTest(String fn, String ln, String email, String ph, String pwd) {
		
	}
		
	
	//https://naveenautomationlabs.com/opencart/index.php?route=account/register
	//https://naveenautomationlabs.com/opencart/index.php?route=account/login
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
			
		}
	
	@Test(dataProvider = "getLoginNegativeData")
	public void loginTest(String userName, String password) {
	 boolean flag = doLogin(userName, password);
	 Assert.assertTrue(flag);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
