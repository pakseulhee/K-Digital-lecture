interface IBase{
	void method();
}
//익명클래스는 정의부터 해서 new까지 같이 한다.
//인터페이스에서만 쓰는것이 아니라, 추상클래스에서도 사용한다.
abstract class CBase {
	abstract void cmethod();
}
public class AnoninmousTest {

	public static void main(String[] args) {
		
		IBase b = new IBase() { //부모를 상속받아서 새로운 클래스를 만듦.
			@Override
			public void method() {
				System.out.println("구현 메소드");
			}
		}; // 이까지가 익명클래스의 정의이고 new IBase여기가 객체생성이다.
		b.method();
		
		CBase c = new CBase() {
			@Override
			void cmethod() {
				System.out.println("두번째 구현 메소드");
			}
		}; //익명클래스의 명령어가 끝나는 부분이기때문에, 세미콜론을 붙혀줘야한다.
		c.cmethod();
	}
}
