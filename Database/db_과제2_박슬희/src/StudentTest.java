import java.util.List;

import dao.StudentDAO;
import dto.StudentDTO;

public class StudentTest {
	
	public static void insertStudent() {
		StudentDAO dao = new StudentDAO();
		dao.insertStudent(new StudentDTO(1, "홍길동","국문학과","서울","010-1111-1111"));
		dao.insertStudent(new StudentDTO(2, "고길동","수학과","인천","010-2222-2222"));
		dao.insertStudent(new StudentDTO(3, "나길동","영문학과","제주","010-3333-3333"));
		dao.connectClose();
	}
	
	public static void printAllStudents() {
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> list = dao.printAllStudents();
		for(StudentDTO acc: list) {
			System.out.println(acc.getNo()+acc.getName()+acc.getDet()+acc.getAddr()+acc.getTel());
		}
	}

	
	public static void main(String[] args) {
		insertStudent();
//		printAllStudents();
	}
}
