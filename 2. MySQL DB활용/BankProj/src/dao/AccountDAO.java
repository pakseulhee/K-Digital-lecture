package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import acc.Account;
import acc.SpecialAccount;
import exp.AccountException;
import exp.BankExpCode;

public class AccountDAO {
	Connection conn;
	public AccountDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
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
	
	public int insertAccount(Account acc) {
		String sql = "insert into account values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2,  acc.getName());
			pstmt.setInt(3,  acc.getBalance());
			if(acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade());
			}else {
				pstmt.setString(4, null);
			}
			rcnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rcnt;
	}
	//이 함수는 객체를 딤아서 만들어줌
	public Account queryAccount(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null; //쿼리 결과를 저장할 곳
		Account acc = null;
		String sql= "select * from account where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String grade = rs.getString(4);
				if(grade != null) { //널이 아니면 grade를 생성시켜줌
					acc= new SpecialAccount();
					((SpecialAccount)acc).setGrade(grade);
				}else {
					acc = new Account();
				}
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return acc;
	}
	public ArrayList<Account> queryAllAccounts(){
		String sql= "select * from account";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Account acc;
				String grade = rs.getString(4);
				if(grade!=null) {
					acc = new SpecialAccount();
					((SpecialAccount)acc).setGrade(grade);
				} else {
					acc = new Account();
				}
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				accs.add(acc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	//일반계좌만 조회
	public  ArrayList<Account> queryAccounts(){
		String sql = "select * from account where grade is null";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				accs.add(acc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	//특수계좌만 조회
	public  ArrayList<Account> querySpecialAccounts(){
		String sql = "select * from account where grade is not null";
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Account> accs = new ArrayList<>();
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SpecialAccount acc = new SpecialAccount();
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				acc.setGrade(rs.getString(4));
				accs.add(acc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return accs;
	}
	public boolean depositAccount(String id, int money) throws AccountException {
		Account acc = queryAccount(id);
		if(acc==null) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		acc.deposit(money);
		int rcnt = updateAccount(acc);
		if(rcnt>0) return true;
		else return false;
	}
	public boolean withdrawAccount(String id, int money) throws AccountException {
		//계좌 조회
		Account acc = queryAccount(id);
		//계좌번호 오류 체크
		if(acc==null) {
			throw new AccountException(BankExpCode.NOT_ACC);
		}
		//계좌 객체에 출금 호출
		acc.withdraw(money);
		//출금한 금액으로 DB 변경
		int rcnt = updateAccount(acc);
		if(rcnt>0) return true;
		return false;
	}
	
	public int updateAccount(Account acc) {
		String sql = "update account set balance=? where id=?";
		PreparedStatement pstmt = null;
		int rcnt = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			rcnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		};
		return rcnt;
	}
}

