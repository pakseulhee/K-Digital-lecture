class Person{
	int age;
	String name;
	public Person() {}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String info() {
		return "이름:"+name+", 나이:"+ age;
	}
}

//생성자가 부모것이 먼저 호출이 된다. 그래서 기본생성자를 항상 만들어줘야한다.
class Student extends Person{
	String major;

	public Student(int age, String name, String major) {
		super(age,name);
//		this.age = age;
//		this.name = name;
		this.major = major;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String info() {
		// 부모꺼 쓰고 내꺼도 추가! (내꺼는 major)
		return super.info() + ", 전공:" +major;
	}
}

class Professor extends Person{
	String department;
	public Professor() {}
	public Professor(int age, String name, String department) {
		super(age,name);
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+ ", 부서:" + department;
	}
	
	
}
public class InheritSample1 {
	static Person[] pers = new Person[10];
	
	public static void main(String[] args) {
//		Student s= new Student(20, "고길동", "산업디자인");
//		System.out.println(s.info());
//		Person p = new Student(20, "고길동", "산업디자인");
//		//자식 객체를 부모타입 변수에 넣을 수 있다 -> 업캐스팅
//		//생성은 자식으로 시켰지만 타입이 부모이면 자식꺼를 쓸수가 없다.
//		Student s2 = (Student)p;
//		//부모 객체로 만든애를 타입 변수에 저장하려면 -> 다운캐스팅
//		//student로 손코딩을 해줘야 한다.
		pers[0] = new Student(20,"고길동", "산업디자인");
		pers[1] = new Student(20, "하길동", "데이터과학");
		pers[2] = new Professor(50, "나교수", "정보과학부");
		
		for(int i = 0; i<3; i++) {
			System.out.println(pers[i].info());
		}
		for(int i = 0; i<3; i++) {
			if(pers[i] instanceof Student) { //트루 펄스로 반환 됨
				System.out.println(pers[i].info());
			}
		}
//		Person p = new Student(20, "고길동", "산업디자인");
//		System.out.println(p.info());
		//info가 부모에도 있고 자식에도 있어, 그럼 누구꺼 호출할꺼?
		//자식거의 info가 호출이 된다.-> 다형성(많이 쓰는게 호출된다.)
	}
}
