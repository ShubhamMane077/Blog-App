package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.LoginDao;
import com.nt.dto.LoginDto;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao dao;
	
	public LoginDto login(String userName,String passWord) {
		return dao.login(userName, passWord);
	}
}
