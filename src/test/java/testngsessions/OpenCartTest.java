package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	@Test
	public void titleTest() {
		
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		Assert.assertEquals(title, "Your Store");
	}

	@Test
	public void searchExistTest() {
		boolean flag = driver.findElement(By.name("search")).isDisplayed();
		Assert.assertTrue(flag);
	}
  
}
