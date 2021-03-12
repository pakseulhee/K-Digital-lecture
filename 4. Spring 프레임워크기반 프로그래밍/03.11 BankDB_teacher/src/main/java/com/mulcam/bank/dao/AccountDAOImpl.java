package com.mulcam.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.mulcam.bank.beans.Account;

public class AccountDAOImpl implements AccountDAO {
	private JdbcTemplate template;
	private SimpleJdbcInsert jdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("accountw");
	}

	@Override
	public void insertAccount(Account acc) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("id",acc.getId());
		params.put("name", acc.getName());
		params.put("balance", acc.getBalance());
		params.put("sect", acc.getSect());
		params.put("grade", acc.getGrade());
		jdbcInsert.execute(params);
	}

	@Override
	public Account queryAccount(String id) throws Exception {
		System.out.println(id);
		String sql = "select * from accountw where id=?";
		Account acc = template.queryForObject(sql,new Object[] {id}, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account acc = new Account();
				acc.setId(rs.getString(1));
				acc.setName(rs.getString(2));
				acc.setBalance(rs.getInt(3));
				acc.setSect(rs.getString(4));
				acc.setGrade(rs.getString(5));
				return acc;
			}
		});
		return acc;
	}

	@Override
	public void updateAccBalance(Account acc) throws Exception {
		String sql="update accountw set balance=? where id=?";
		int count=template.update(sql,acc.getBalance(), acc.getId());
		if(count==0) {
			throw new Exception();
		}
	}

	@Override
	public List<Account> queryAccounts() throws Exception {
		String sql = "select * from accountw";
		RowMapper<Account> mapper = new BeanPropertyRowMapper<Account>(Account.class);
		return template.query(sql, mapper);
	}
}
