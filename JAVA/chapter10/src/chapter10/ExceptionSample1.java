package chapter10;
//try안의 내용이 정상적으로 실행된다면 catch를 건너뛰고 코드를 실행함.
public class ExceptionSample1 {

	public static void main(String[] args) {
		String str = null;
		try {//여기서 던진애는 캐치에서 잡을 수 있다.
			System.out.println(str.toString());
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	System.out.println("프로그램 종료");
	}
}
