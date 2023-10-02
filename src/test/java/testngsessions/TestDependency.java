package testngsessions;

import org.testng.annotations.Test;

public class TestDependency {
	
	@Test
	public void searchTest() {
		System.out.println("searchTest");
	}
	
	@Test(dependsOnMethods = "searchTest")
	public void addToCart() {
		System.out.println("addToCart");
	}
	
	@Test(dependsOnMethods = "addToCart")
	public void makePayment() {
		System.out.println("makePayment");
	}

}
