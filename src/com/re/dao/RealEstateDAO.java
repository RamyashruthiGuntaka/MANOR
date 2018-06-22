package com.re.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.re.dbutility.DBConnection;
import com.re.dto.User;


public class RealEstateDAO {
	
	public static int addUser(User user){
		final String INSERT_QUERY="insert into register(name,mail_id,password,phno) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getName());
		    pst.setString(2, user.getMail_id());
			pst.setString(3, user.getpassword());
			pst.setString(4, user.getPhno());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int getUserId(String mail_id){
		PreparedStatement pst = null;
		ResultSet rst = null;
		int user_id = 0;
		final String INSERT_QUERY="select user_id from register where mail_id = ?";
		//PreparedStatement pst = null;
		//int status=0;
		try{
			Connection con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1, mail_id);
			rst = pst.executeQuery();
			if(rst.next()){
				user_id = rst.getInt(1);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return user_id ;

		}
	
	public User getUser(String mail_id,String password){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		User user=null;
	final String SELECT_QUERY = "select * from register where mail_id = ? and password = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, mail_id);
		pst.setString(2, password);
		rst = pst.executeQuery();
		if(rst.next()){
			 user=new User();
			// user.setregisterId(rst.getInt(1));
			 user.setName(rst.getString(2));
			 user.setMail_id(rst.getString(3));
			 user.setpassword(rst.getString(4));
			 user.setPhno(rst.getString(5));
		System.out.println(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	}
	
	public User getUserDetails(String name){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		User user=null;
	final String SELECT_QUERY = "select * from registration where name = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, name);
		rst = pst.executeQuery();
		if(rst.next()){
			user=new User();
			 //user.setregisterId(rst.getInt(1));l
			 user.setName(rst.getString(2));
			 user.setMail_id(rst.getString(3));
			 user.setpassword(rst.getString(4));
			 user.setPhno(rst.getString(5));
		System.out.println(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	}
	
}
