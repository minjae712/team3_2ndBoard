package com.springbook.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userservice;

	@RequestMapping("/login.do")
	public String getUser(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리 완료~");
		try {
			
		UserVO user = userservice.getUser(vo);
		session.setAttribute("user", user);
		
		if(user != null) {
			return "getBoardList.do";
		}else {
		
		return "login.jsp";
		}
		}catch (Exception e) {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리 완료~");
		
		session.invalidate();
		return "login.jsp";
		
	}
	
}
