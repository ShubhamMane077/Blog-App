package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.dto.LoginDto;

@Repository
public class LoginDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public LoginDto login(String userName , String passWord) {
		
		try {
			
			Object[] argObjects = {userName , passWord};
			
			return template.queryForObject("select * from login where username=? and password=?", new RowMapper<LoginDto>() {

				@Override
				public LoginDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					int id = rs.getInt("id");
					String userName = rs.getString("username");
					String passWord = rs.getString("password");
					LoginDto dto = new LoginDto(id, userName, passWord);
					System.out.println(dto);
					return dto;
				}
				
			}, argObjects);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
