public class BeepPrintExample1 {

	public static void main(String[] args) {
		//Thread thread = new Thread(new BeepTask());
		Thread thread = new BeepThread(); //부모 자식간이라 동적바인딩 가능
		thread.start();
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);} catch (Exception e) {} 
		}
	}
}
