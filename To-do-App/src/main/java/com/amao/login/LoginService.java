package com.amao.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name,String password){
		return name.equals("amao")&&password.equals("123");
	}
}
