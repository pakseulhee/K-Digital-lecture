package chapter5;
// 깊은 복사: 배열의 주소가 아닌, 새로운 객체를 생성하여 배열의 값을 복사하는 것
public class ArrayCopyExample {

	public static void main(String[] args) {
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for(int i = 0; i<newStrArray.length; i++) {
			System.out.println(newStrArray[i] + ",");
		}
	}

}
