package chapter10;
import java.util.Scanner;

public class ExceptionSample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sel;
		while(true) {
			try {
				System.out.println("숫자입력>>");
				sel = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.");
			}
		}
	}
}
