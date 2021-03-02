import java.util.List;

import dao.EmpDAO;
import dto.EmpDTO;

public class EmpTest {
	//emp삽입
	public static void insertEmp() {
		EmpDTO emp = new EmpDTO();
		emp.setEmpno(9000);
		emp.setEname("ADAMS");
		emp.setJob("RESEARCH");
		emp.setMgr(7839);
		emp.setSal(3000);
		emp.setDptno(20);
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		dao.connectClose();
		
	}
	//empno을 가지고 행 하나의 ename을 조회
	public static void queryEmp() {
		EmpDAO dao = new EmpDAO();
		EmpDTO emp = dao.queryEmp(9000);
		dao.connectClose();
		System.out.println(emp.getEname());
	}

	//where 절의 조건을 만족하는 empno, ename을 조회
	public static void queryEmps() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryEmps(20);
		dao.connectClose();
		for(EmpDTO e : list) {
			System.out.println(e.getEmpno()+":"+e.getEname());
		}
	}
	
	public static void queryDname() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryDname("RESEARCH");
		dao.connectClose();
		for(EmpDTO e : list) {
			System.out.println(e.getEmpno()+":"+e.getEname());
		}
	}
	
	//모든 행에 대한 empno과 ename을 조회
	public static void queryAllEmps() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> list = dao.queryEmps();
		dao.connectClose();
		for(EmpDTO e : list) {
			System.out.println(e.getEmpno()+":"+e.getEname());
		}
	}
	
	public static void deleteEmp() {
		EmpDAO dao = new EmpDAO();
		dao.deleteEmp(9000);
		dao.connectClose();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertEmp();
//		queryEmp();
//		queryEmps();
//		queryAllEmps();
//		queryDname();
		deleteEmp();
	}

}
