import emp.Employee;

public class Company {
	Employee[] emps = new Employee[100];
	int empCnt;
	
	public void addEmployee(Employee emp) {
		emps[empCnt++] = emp; //empCnt는 실제 생성된 객체의 수
	}
	
	public void empList() {
		for(int i=0; i<empCnt; i++) {
			System.out.println(emps[i].info());
		}
	}
	
	public int getTotEmpsPay() {
		int tot=0;
		for(int i = 0; i<empCnt; i++) {
			tot += emps[i].getPay();
		}
		return tot;
	}
	
	public static void main(String[] args) {
		Company com = new Company();
		com.addEmployee(new Employee("101", "김과장", 3000000));
		com.addEmployee(new Employee("102", "박대리", 2000000));
		com.addEmployee(new Employee("103", "홍차장", 4000000));
		
		com.empList();
		System.out.println();
		System.out.println("총 급여액: "+ com.getTotEmpsPay());
	}
}
