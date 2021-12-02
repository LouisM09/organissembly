package com.organissembly.dao;

import java.sql.*;

import com.organissembly.bean.User;

public class LoginDao {  
	  
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
		//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
	//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","root","zephyrus12");
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
	
	public String getUserEmail(User bean){  
		String email=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				email=rs.getString("user_email");
			}
		}catch(Exception e){}  
		  
		return email;  
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
	
	public String getFirstName(User bean){  
		String firstName=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				firstName=rs.getString("user_firstName");
			}
		}catch(Exception e){}  
		  
		return firstName;  
	}
	
	public String getMiddleName(User bean){  
		String middleName=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				middleName=rs.getString("user_middleName");
			}
		}catch(Exception e){}  
		  
		return middleName;  
	}
	
	public String getDateCreated(User bean){  
		String createDate=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				createDate=rs.getString("user_dateCreated");
			}
		}catch(Exception e){}  
		  
		return createDate;  
	} 
	
	public String getDateUpdated(User bean){  
		String updateDate=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				updateDate=rs.getString("user_dateUpdated");
			}
		}catch(Exception e){}  
		  
		return updateDate;  
	} 
	
	public String getLastName(User bean){  
		String lastName=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				lastName=rs.getString("user_lastName");
			}
		}catch(Exception e){}  
		  
		return lastName;  
	}
	
	public String getPoints(User bean){  
		String points=null;
		try{  
			Connection con = getConnection();  
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user where user_email=? and user_password=?");  
			  
			ps.setString(1,bean.getEmail());  
			ps.setString(2,bean.getPassword());
			              
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
				points=rs.getString("user_points");
			}
		}catch(Exception e){}  
		  
		return points;  
	} 
}
