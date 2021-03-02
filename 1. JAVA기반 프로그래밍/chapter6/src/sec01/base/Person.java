package sec01.base;
//생성자는 매개변수의 갯수와 타입이 다르면 여러개 올 수 있다. -> 오버로드

/**
 * @author user
 *
 */
public class Person {
	int age;
	String name;
	
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
//	public Person(String n, int a) {
//		name = n;
//		age = a;
//	}
// 생성자의 매개변수 이름이 필드변수와 같지 않다면, 위와 같이 명시해주면 된다. (this를 쓰지 않아도 됨)
	
	public String info(){
		return "이름:" + name + ", 나이:" + age;
	}
}
