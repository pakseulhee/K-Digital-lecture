package emp;
public class Employee {
	String num;
	String name;
	int pay;
	
	public void setPay(int pay) {
		this.pay = pay;
	}
	public Employee(String num, String name, int pay) {
		this.num = num;
		this.name = name;
		this.pay = pay;
	}
	public String info() {
		return "사번:"+num+", 이름:"+name+", 급여:"+pay;
	}
	public int getPay() {
		return pay;
	}
}
