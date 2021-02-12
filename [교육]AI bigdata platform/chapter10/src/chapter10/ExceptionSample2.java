package chapter10;

public class ExceptionSample2 {

	public static void main(String[] args) {
		int[] arr1 = {10,20,30};
		int[] arr2 = {2,0,6};
		try {
			for(int i=0; i<arr1.length; i++) {
				System.out.println(arr1[i]/arr2[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
