package org.cap.login.service;

import org.cap.dao.LoginDao;
import org.cap.dao.LoginDaoImpl;
import org.cap.login.pojo.Login;

public class LoginServiceImpl implements LoginService{

	LoginDao loginDao=new LoginDaoImpl();
	
	@Override
	public boolean isValidUser(Login login) {
		/*if(login.getUserName().equals("tom") && login.getUserPwd().equals("tom123"))
		return true;
		else
			return false;*/
		return loginDao.isValidUser(login);
	}

}
