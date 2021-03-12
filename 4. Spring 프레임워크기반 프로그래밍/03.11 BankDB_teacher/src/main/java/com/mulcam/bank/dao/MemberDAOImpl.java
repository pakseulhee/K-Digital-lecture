package com.mulcam.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mulcam.bank.beans.Member;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate template;
	private SimpleJdbcInsert jdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("memberw");
	}

	@Override
	public void insertMember(Member mem) throws Exception {
		Map<String, Object> params= new HashMap<>();
		params.put("id", mem.getId());
		params.put("password", mem.getPassword());
		params.put("name", mem.getName());
		params.put("sex", mem.getSex());
		params.put("age", mem.getAge());
		params.put("email", mem.getEmail());
		jdbcInsert.execute(params);
	}

	@Override
	public Member queryMember(String id) throws Exception {
		String sql="select * from memberw where id=?";
		Member mem = template.queryForObject(sql, new Object[] {id}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setPassword(rs.getString("password"));
				mem.setName(rs.getString("name"));
				mem.setAge(rs.getInt("age"));
				mem.setSex(rs.getString("sex"));
				mem.setEmail(rs.getString("email"));
				return mem;
			}			
		});
		return mem;
	}


}
