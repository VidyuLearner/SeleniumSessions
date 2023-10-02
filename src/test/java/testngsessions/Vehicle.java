package testngsessions;

public class Vehicle {
	void run() {
		System.out.println("Vehicle is runninng");
	}
	
static class bike2 extends Vehicle{
		void run() {
			System.out.println("Vehicle is running in safe mode");
		}
		
	}

	public static void main(String[] args) {
		bike2 obj = new bike2();
		obj.run();
		Vehicle obj1 = new Vehicle();
		obj1.run();
		

	}

}
