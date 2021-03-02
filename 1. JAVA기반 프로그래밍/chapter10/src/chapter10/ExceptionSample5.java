package chapter10;

public class ExceptionSample5 {

	public static void main(String[] args) {
		try {
			throw new Exception("내가 만든 예외");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
