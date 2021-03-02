class A{
	//instance inner class
	class B{ //인스턴스 이너클래스
		B(){} //생성자
		int n; //인스턴스 필드
		void method() {}
		//static int sn; static 필드 선언 불가능
		//static void smethod(){} static 메소드 선언 불가능
	}
}

class C{
	//static inner class
	static class D { //인스턴스 이너클래스
		D(){} //생성자
		int n; //인스턴스 필드
		void method() {}
		static int sn; //static 필드 
		static void smethod(){} //static 메소드
	}
}

public class InnerClassTest {
	public static void method() {
		class F{
			F(){} //생성자
			int n; //인스턴스 필드
			void method() {} //인스턴스 필드
			//static int sn; //static 필드 선언 불가능
			//static void smethod(){}//static 메소드 선언 불가능
		}
		F f = new F();
		f.method();
	}
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.method();
		b.n = 10;
		
		C.D d = new C.D();
		d.n = 10;
		C.D.sn = 20;
		C.D.smethod();
	}
}
