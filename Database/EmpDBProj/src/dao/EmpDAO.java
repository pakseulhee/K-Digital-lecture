package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.EmpDTO;

public class EmpDAO {
	Connection conn;
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void connectClose() {
		try {
			if(conn!=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public int insertEmp(EmpDTO emp){
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2,  emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4,  emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setDouble(6, emp.getSal());
			pstmt.setDouble(7, emp.getComm());
			pstmt.setInt(8, emp.getDptno());
			rcnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
	public EmpDTO queryEmp(int empno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EmpDTO member = null;
		String sql= "select * from emp where empno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,empno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new EmpDTO();
				member.setEmpno(rset.getInt(1));
				member.setEname(rset.getString(2));
				member.setJob(rset.getString(3));
				member.setMgr(rset.getInt(4));
				member.setHiredate(rset.getString(5));
				member.setSal(rset.getDouble(6));
				member.setComm(rset.getDouble(7));
				member.setDptno(rset.getInt(8));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	
	//특정 부서의 직원목록 조회
	//함수에 매개변수가 있다는건 가변이라는 의미이다.
	public ArrayList<EmpDTO> queryEmps(int deptno){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from emp where deptno=?";
		ArrayList<EmpDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,deptno);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				EmpDTO member = new EmpDTO(); //리스트 안에 넣어야해서 여기에 생성을 다 시켜야 함
				member.setEmpno(rset.getInt(1));
				member.setEname(rset.getString(2));
				member.setJob(rset.getString(3));
				member.setMgr(rset.getInt(4));
				member.setHiredate(rset.getString(5));
				member.setSal(rset.getDouble(6));
				member.setComm(rset.getDouble(7));
				member.setDptno(rset.getInt(8));
				list.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<EmpDTO> queryDname(String dname){
		String sql = "select * from emp where deptno = "
				+ "(select deptno from dept where dname=?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EmpDTO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dname);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				EmpDTO member = new EmpDTO(); //리스트 안에 넣어야해서 여기에 생성을 다 시켜야 함
				member.setEmpno(rset.getInt(1));
				member.setEname(rset.getString(2));
				member.setJob(rset.getString(3));
				member.setMgr(rset.getInt(4));
				member.setHiredate(rset.getString(5));
				member.setSal(rset.getDouble(6));
				member.setComm(rset.getDouble(7));
				member.setDptno(rset.getInt(8));
				list.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<EmpDTO> queryEmps(){
		String sql = "select * from emp";
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<EmpDTO> emps = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				EmpDTO member = new EmpDTO(); //리스트 안에 넣어야해서 여기에 생성을 다 시켜야 함
				member.setEmpno(rset.getInt(1));
				member.setEname(rset.getString(2));
				member.setJob(rset.getString(3));
				member.setMgr(rset.getInt(4));
				member.setHiredate(rset.getString(5));
				member.setSal(rset.getDouble(6));
				member.setComm(rset.getDouble(7));
				member.setDptno(rset.getInt(8));
				emps.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return emps;
	}
	public int deleteEmp(int empno) {
		String sql = "delete from emp where empno=?";
		PreparedStatement pstmt = null;
		int rcnt=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno); //숫자 1의 의미는 물음표의 순서를 의미
			rcnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
}
