package chapter5;
 //얕은 복사: 객체의 주소값만을 복사하는 것
public class ArrayCopyByForExample {

	public static void main(String[] args) {
		int[] oldIntArray = {1,2,3};
		int[] newIntArray = new int[5];
		
		for(int i = 0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		for(int i = 0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ",");
	
		}
	}
}
