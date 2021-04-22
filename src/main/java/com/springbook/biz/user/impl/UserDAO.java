package com.springbook.biz.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;



@Repository
public class UserDAO {
	//JDBC 변수
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL
	private final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";
		
	
	//기능
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC�� getUser() ��� ó��");
		Object[] args={vo.getId(),vo.getPassword()};
        return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
    }
}