package chapter10;

class A{}
class B extends A {}
class C extends A {}
public class ExceptionSample4 {

	public static void main(String[] args) {
		A a = new B(); //물리적으로는 형제관계이다.
		C c = (C)a; //이건 부모자식관계
	}

}
