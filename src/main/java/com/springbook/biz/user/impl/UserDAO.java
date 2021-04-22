package com.springbook.biz.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;



@Repository
public class UserDAO {
	//JDBC º¯¼ö
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
		
	
}