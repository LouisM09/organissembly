package com.organissembly.dao;

import java.sql.*;

import com.organissembly.bean.User;

public class AccountDao {  
	  
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
			//				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","root","zephyrus12");
		//	con=DriverManager.getConnection("jdbc:mysql://216.231.128.40/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			}catch(Exception e){System.out.println(e);}
		return con;
	}

	public boolean validate(User bean){  
		boolean status=false;  
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			status=rs.next();       
		}catch(Exception e){}  
		  
		return status;  
	}
	
	public String getUserID(User bean){  
		String userId=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				userId=rs.getString("user_id");
			}
		}catch(Exception e){}  
		  
		return userId;  
	}
	
	public String getUserRole(User bean){  
		String userRole=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				userRole=rs.getString("user_level");
			}
		}catch(Exception e){}  
		  
		return userRole;  
	}  
}
