package chapter6;

class Student{
	public Student() {
		System.out.println("저는 학생의 생성자 입니다.");
	}
}

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다. ");
		Student s2 = new Student();
		System.out.println("s2 변수가 Student 객체를 참조합니다. ");
	}
}
