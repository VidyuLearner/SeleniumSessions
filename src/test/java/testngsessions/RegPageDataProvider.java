package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPageDataProvider {
	
	public WebDriver driver;
	
	public boolean doRegPage(String fn, String ln, String email, String ph, String pwd) {
		
		
		driver.findElement(By.id("input-firstname")).sendKeys(fn);
		
		driver.findElement(By.id("input-lastname")).sendKeys(ln);
	
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).sendKeys(ph);
	
		driver.findElement(By.id("input-password")).sendKeys(pwd);
	
		driver.findElement(By.id("input-confirm")).sendKeys(pwd);
		
		driver.findElement(By.name("agree")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		String Message = driver.findElement(By.xpath("//div[@id='content']")).getText();
		//System.out.println(Message);
		if(Message.contains("Your Account Has Been Created!")) {
			return true;
			
		}
		return false;
	}
	@BeforeTest
	public void setUp() {
		
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@DataProvider
	public Object[][] getRegTestData() {
		return new Object[][] {
			{"Sam","Dam", "sam123@gmail.com", "9098765435", "sam@123"},
			{"Dam","Sam", "dam123@gmail.com", "9098765437", "dam@123"},
//			{"Fam","Bam", "fam@gmail.com", "9098765438", "fam@123"}
		};
			
		}
	@Test(dataProvider = "getRegTestData")
	public void regPagetest(String fn, String ln, String email, String ph, String pwd) {
		boolean flag = doRegPage(fn,ln,email, ph, pwd);
		Assert.assertTrue(flag);
		
		
	}
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	

}
