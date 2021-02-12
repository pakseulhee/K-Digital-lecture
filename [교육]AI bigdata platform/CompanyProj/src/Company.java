import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

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
			//부모거가 아닌 자식거를 호출시켜서 0이 아닌 정상 값이 반환된다.
		}
		return tot;
	}
	public void regBusinessTrip(IBusinessTrip e, int day) {
		e.goBusinessTrip(day);
	}
	
	public static void main(String[] args) {
		Company com = new Company();
		
		Permanent e1 = new Permanent("101", "김과장", 3000000);
		Sales e2 = new Sales("102", "박대리",1000, 2000000);
		PartTime e3 = new PartTime("103", "홍차장",160, 4000000);
		
		com.addEmployee(e1);
		com.addEmployee(e2);
		com.addEmployee(e3);

//		com.regBusinessTrip(e1, 3); //불가능하게
		com.regBusinessTrip(e2, 2); //가능하게
		com.regBusinessTrip(e3, 3); //가능하게 해보기

		
		com.empList();
		System.out.println();
		System.out.println("총 급여액: "+ com.getTotEmpsPay());
	}
}
