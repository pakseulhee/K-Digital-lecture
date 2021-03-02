package chapter6;
//생성자는 매개변수의 갯수와 타입이 다르면 여러개 올 수 있다. -> 오버로드

public class Person {
	int age;
	String name;
	
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String info(){
		return "이름:" + name + ", 나이:" + age;
	}
}
