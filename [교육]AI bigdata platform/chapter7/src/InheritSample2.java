class Parent{
	int pnum;
	public Parent() {}
	public Parent(int pnum) {
		this.pnum = pnum;
	}
	public void method() {
		
	}
	public void method1() {
		
	}
}

class Child extends Parent{
	int cnum;
	public Child() {}
	public Child(int pnum, int cnum) {
		super(pnum); //부모의 생성자를 호출한다.
		this.cnum = cnum;
	}
	
	@Override
	public void method() {
		super.method(); 
// super를 안쓰면, 가장가까운 곳의 함수를 호출한다. 그래서 부모것이 아니라 본인것을 호출하는 것
// 그래서 부모의 것을 명시적으로 붙혀줘야한다. super를 통해
	}

	public void method2() {
		method1(); 
//super.method1(); 이렇게 붙여도 되고 안해도된다.
//결과는 부모것을 호출한다. 왜냐하면 부모에만 메소드1이 존재하기 때문에.
	}
}
public class InheritSample2 {

	public static void main(String[] args) {
		Child c = new Child(10,20);
		c.method();
		
		Parent p1 = new Child(10,20);
		Parent p2 = new Parent();
		
		System.out.println(p1 instanceof Parent);
		System.out.println(p1 instanceof Child);
		System.out.println(p2 instanceof Parent);
		System.out.println(p2 instanceof Child);

	}

}
