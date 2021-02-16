package chapter10;
//예외를 추적하여서 근본부터 고치는 것
public class ExceptionSample6 {
	public static void method1() {
		method2();
	}
	public static void method2() {
		String str = null;
		try {
			System.out.println(str.toString());
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		method1();
	}

}
