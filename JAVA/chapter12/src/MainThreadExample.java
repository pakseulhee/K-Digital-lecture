
public class MainThreadExample {
//하나의 객체를 가지고 두개의 쓰레드가 공유를 하고 있음.
	public static void main(String[] args) {
		Calculator calculator1 = new Calculator();
//		Calculator calculator2 = new Calculator();

		User1 user1 = new User1();
		user1.setCalculator(calculator1);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator1);
		user2.start();
	}

}
