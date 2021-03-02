package chapter5;

public class LottoSample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//(int)(Math.random()*45)+1 //1-45 정수중 랜덤한 값 가져오기
		int count = 1;
		int temp, temp2, temp3 = 0;
		
		//1. 1-45 정수값을 저장할 배열 선언과 할당
		int[] list = new int[46];
		
		//2. 1번에서 할당한 배열에 1-45넣기
		for(int i = 1; i<list.length; i++) {
			list[i] = i;
		}
		
		//3. 1-45중 랜덤한 값 2개를 구하여 배열 중 그 순번에 있는 배열의 값 바꾸기
		//4. 3번을 1000번 반복
		while(count <= 1000) {
			temp = (int)(Math.random()*45)+1; //랜덤값
			temp2 = (int)(Math.random()*45)+1;
			temp3 = list[temp];
			list[temp] = list[temp2];
			list[temp2] = temp3;
			count += 1;
		}
		//5. 배열의 요소중 앞에서 6개를 로또 당첨 번호로 출력
		for(int j=0; j<=5; j++) {
			System.out.print(list[j]+" ");
		}
	}

}
