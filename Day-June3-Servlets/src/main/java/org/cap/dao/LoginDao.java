package org.cap.dao;

import org.cap.login.pojo.Login;

public interface LoginDao {
	public boolean isValidUser(Login login);
}
