package chapter6;

public class Person_example {

	public static void main(String[] args) {
		Person p = new Person();
		p.age = 20;
		p.name = "슬희";
		System.out.println(p.info());
		
		Person p1 = new Person("서영", 20);
		System.out.println(p1.info());
	}

}
