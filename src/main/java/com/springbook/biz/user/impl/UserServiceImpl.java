package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserDAO userDAO;
	
	
}