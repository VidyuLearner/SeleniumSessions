package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountTest{
	
	@Test(invocationCount = 5)
	public void createUserTest() {
		System.out.println("create User");
	}
	
}


