package sec01.inter;

@FunctionalInterface 
//이것의 의미는 오브젝트 클래스의 오버라이딩을 제외하고 
//하나의 메소드만을 가지고 있는 것을 장담한다.
interface Moveable{
	void move(int x, int y);
}
interface Attackable{
	void attack();
}

class Fighter implements Moveable, Attackable{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
		Attackable f1 = new Fighter();
		//구현한 객체를 interface 참조변수에 가질 수 있다.
		f1.attack();//이거하면 자식클래스 의 메소드가 호출됨(다형성)
		//f1.move(); //이거 불가능ㄴ함.
		
	}

}
