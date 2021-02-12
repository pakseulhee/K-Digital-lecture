package example05;

public class Anonymous {
	Vehicle field = new Vehicle() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	
	};
	void method1() {
		Vehicle localVar = localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}
