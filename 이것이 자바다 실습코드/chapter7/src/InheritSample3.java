class Base {
	public Base() {
		System.out.println("Base constructor");
	}
	public Base(int n) {
		System.out.println("n Base constructor");
	}
}
class Derived extends Base{
	public Derived() {
		super(10);
		System.out.println("Derived constructor");
//		super(10); 부모 생성자 호출은 처음에 써야 한다.
	}
}
public class InheritSample3 {
	public static void main(String[] args) {
		Derived d = new Derived();
	}
}
