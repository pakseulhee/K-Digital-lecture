package sec03;

public class Member {
	public String name;
	public int age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {//이름과 나이가 같으면 true
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age);
		}else {
			return false;
		}
	}
	
	public int hashCode() { // 이름과 나이가 같으면 같은 해쉬코드로 반환하는 코드
		return name.hashCode()+age;
	}
}
