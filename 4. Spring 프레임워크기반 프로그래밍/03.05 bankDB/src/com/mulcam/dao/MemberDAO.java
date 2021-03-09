package com.mulcam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mulcam.bean.Member;
import com.mulcam.db.JdbcUtil;

public class MemberDAO {
	public void insertMember(Member mem, Connection conn) throws Exception{
		PreparedStatement pstmt=null;
		String sql ="insert into memberw values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getSex());
			pstmt.setInt(5, mem.getAge());
			pstmt.setString(6, mem.getEmail());
			int count = pstmt.executeUpdate();
			if(count != 1) {
				throw new Exception("회원가입 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public Member queryMember(String id, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mem = null;
		String sql = "select * from memberw where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			pstmt.executeQuery();
			if(rset.next()) {
				mem =new Member();
				mem.setId(rset.getString(1));
				mem.setPassword(rset.getString(2));
				mem.setName(rset.getString(3));
				mem.setSex(rset.getString(4));
				mem.setAge(rset.getInt(5));
				mem.setEmail(rset.getString(6));
			}else {
				throw new Exception("회원번호 오류");
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}
		return mem; 
			
	}
	
}

