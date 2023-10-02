package testngsessions;

import org.testng.annotations.Test;

public class CRUDOperationTest {
	
	public void createUser() {
		System.out.println("Create User");
		
	}
	
	public void getUser(int userId) {
		System.out.println("Get User:" +userId);
		
	}
	
	public void updateUser() {
		
	}
	
	public void deleteUser() {
		
	}
	
	@Test
	public void CreateUserTest() {
		createUser();
	}
	
	@Test
	public void getUserTest() {
		createUser();
		getUser(1);
	}
	
	@Test
	public void updateUserTest() {
		createUser();
		getUser(1);
		updateUser();
		getUser(1);
		
	}
	
	@Test
	public void getUserTesting() {
		int userId = 123;
		getUser(userId);
		
	}

}
