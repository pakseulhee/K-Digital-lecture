import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import dao.AccountDAO;
import dto.Account;
import dto.SpecialAccount;

public class AccountTest {
	public static void insertAccount() {
			AccountDAO dao = new AccountDAO();
			dao.insertAccount(new Account("1001", "hong",100000));
			dao.insertAccount(new SpecialAccount("1002", "park",200000, "VIP"));
			dao.connectClose();
	}
	public static void queryAccount() {
		AccountDAO dao = new AccountDAO();
		Account acc = dao.queryAccount("1001");
		dao.connectClose();
		System.out.println(acc.accInfo());
	}
	public static void depositAccount() {
		AccountDAO dao = new AccountDAO();
		dao.depositAccount("1002", 10000);
	}
	
	public static void withdrawAccount() {
		AccountDAO dao = new AccountDAO();
		dao.withdrawAccount("1002", 10000);
	}
	public static void queryAllAccounts() {
		AccountDAO dao = new AccountDAO();
		List<Account> list = dao.queryAllAccounts();
		for(Account acc: list) {
			System.out.println(acc.accInfo());
		}
	}
	public static void main(String[] args) {
//		insertAccount();
//		queryAccount();
//		depositAccount();
//		queryAllAccounts();
		
//		Statement stmt = conn.createStatement();
//		String sql = "insert into temp values('11',50)";
//		stmt.executeUpdate(sql);
//		
//		String sql2 = "insert into temp values(?,?)";
//		PreparedStatement pstmt = conn.prepareStatement();
//		pstmt.setString(1, "22");
//		pstmt.setDouble(2, 3.14);
//		pstmt.executeUpdate();
	}
}
