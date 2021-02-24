package sec01.val;
//싱글톤은 외부에서 객체 생성이 불가하게 함
//그래서 생성자를 private으로

class SingleTon{
	//instance에는 생성되 객체의 주소를 준다.
	private static SingleTon instance = new SingleTon(); 
	//static메소드에서 참조되므로 static이 붙어야 한다.
	public static SingleTon getInstance() {
		//객체 생성 없이 호출해야 하므로 static 메소드 여야 한다.
		return instance;
		//생성된 객체의 주소를 복사.
	}
	private SingleTon() {}; //private은 외부에서 객체 생성이 불가하게 한다.
}
public class SingleTonTest {

	public static void main(String[] args) {
		SingleTon t1 = SingleTon.getInstance();
		//생성된 객체를 직접 가져오는게 아닌, 객체의 주소값을 가지고 옴

	}

}
