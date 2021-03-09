package com.mulcam.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mulcam.bean.Account;
import com.mulcam.dao.AccountDAO;
import com.mulcam.db.JdbcUtil;
import com.mulcam.err.AccountException;
import com.mulcam.err.BankErrCode;

public class AccountService {
	public void makeAccount(Account acc) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			if(dao.queryAccount(acc.getId(), conn)!=null) {
				throw new AccountException(BankErrCode.EXIST_ACC);
			}			
			dao.insertAccount(acc, conn);
			JdbcUtil.commit(conn);
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public Account accountInfo(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		Account acc = null;
		try {
			acc = dao.queryAccount(id, conn);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return acc;
	}
	public void deposit(String id, int money) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			Account acc = dao.queryAccount(id, conn);
			boolean success = acc.deposit(money);
			if(success==false) {
				throw new AccountException(BankErrCode.FAIL_DEPOSIT);
			}
			dao.updateAccBalance(id, acc.getBalance(), conn);
			JdbcUtil.commit(conn);
		} catch(Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public void withdraw(String id, int money) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			Account acc = dao.queryAccount(id, conn);
			boolean success = acc.withdraw(money);
			if(success==false) {
				throw new AccountException(BankErrCode.LACK_BALANCE);
			}
			dao.updateAccBalance(id, acc.getBalance(), conn);
			JdbcUtil.commit(conn);
		} catch(Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public ArrayList<Account> allAccountInfo() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		AccountDAO dao = new AccountDAO();
		ArrayList<Account> accs=null;
		try {
			accs = dao.queryAccounts(conn);
			if(accs.size()==0) {
				throw new AccountException(BankErrCode.NO_DATA);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		return accs;
	}
}

