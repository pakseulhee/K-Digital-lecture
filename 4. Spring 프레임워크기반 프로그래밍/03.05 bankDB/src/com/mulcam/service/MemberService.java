package com.mulcam.service;

import java.sql.Connection;

import com.mulcam.bean.Member;
import com.mulcam.dao.MemberDAO;
import com.mulcam.db.JdbcUtil;

public class MemberService {
	public void joinMember(Member mem) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(mem, conn);
			JdbcUtil.commit(conn);
		}catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public boolean loginMember(String id, String password) throws Exception{
		Connection conn = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO();
		boolean success = false;
		try {
			Member mem = dao.queryMember(id, conn);
			if(mem == null) throw new Exception("���̵� ����");
			if(mem.getPassword().equals(password)) {
				success = true;
			}else {
				throw new Exception("�н����� ����");
			}			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return success;
	}
}
