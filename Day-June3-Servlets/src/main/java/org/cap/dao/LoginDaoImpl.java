package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cap.login.pojo.Login;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean isValidUser(Login login) {
		
		boolean flag=false;
		String sql="select * from userlogin where userName=? and userPassword=?";
		try {
			PreparedStatement pst=getSQLConnection().prepareStatement(sql);
			
			pst.setString(1, login.getUserName());
			pst.setString(2, login.getUserPwd());
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	
	public Connection getSQLConnection(){
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capdb","root","admin");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}
