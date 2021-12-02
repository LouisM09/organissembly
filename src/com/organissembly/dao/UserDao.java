package com.organissembly.dao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.organissembly.bean.User;
public class UserDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
		//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
			//	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			//			con=DriverManager.getConnection("jdbc:mysql://216.231.128.40/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			}catch(Exception e){System.out.println(e);}
		return con;
	}

	public static String getUID() {
		String lastId = "Ui_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Ui_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}

	public static int save(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(user_id,user_email,user_password,user_firstName,user_middleName,user_lastName,user_dateCreated,user_dateUpdated,user_level) values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1,getUID());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
		
			ps.setString(4,u.getFirstName());
			ps.setString(5,u.getMiddleName());
			ps.setString(6,u.getLastName());
			ps.setString(7,u.getDateCreated());
			ps.setString(8,u.getDateUpdated());
			ps.setString(9,u.getUserLevel());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update user set user_password=?,user_firstName=?,user_middleName=?,user_lastName=?,user_dateUpdated=? where user_id=?");
			ps.setString(1,u.getPassword());
			ps.setString(2,u.getFirstName());
			ps.setString(3,u.getMiddleName());
			ps.setString(4,u.getLastName());
			ps.setString(5,u.getDateUpdated());
			ps.setString(6,u.getUserId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int adminSave(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(user_id,user_email,user_password,user_firstName,user_middleName,user_lastName,user_points,user_dateCreated,user_dateUpdated,user_level,user_number,user_year,user_section) values (?,?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
			ps.setString(4,u.getFirstName());
			ps.setString(5,u.getMiddleName());
			ps.setString(6,u.getLastName());
			ps.setInt(7,1);
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(8,dateTime);
			ps.setString(9,dateTime);
			ps.setString(10,u.getUserLevel());
			ps.setString(11,u.getNumber());
			ps.setString(12,u.getYear());
			ps.setString(13,u.getSection());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int adminUpdate(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update user set user_email=?,user_password=?,user_firstName=?,user_middleName=?,user_lastName=?,user_dateUpdated=?,user_level=? where user_id=?");
			ps.setString(1,u.getEmail());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getFirstName());
			ps.setString(4,u.getMiddleName());
			ps.setString(5,u.getLastName());
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(6,dateTime);
			ps.setString(7,u.getUserLevel());
			ps.setString(8,u.getUserId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(User u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from user where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public static List<User> getAllRecords(){
		List<User> list=new ArrayList<User>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("user_email"));
				u.setFirstName(rs.getString("user_firstName"));
				u.setMiddleName(rs.getString("user_middleName"));
				u.setLastName(rs.getString("user_lastName"));
				u.setFullName(rs.getString("user_firstName"), rs.getString("user_middleName"), rs.getString("user_lastName"));
				u.setUserPoints(rs.getInt("user_points"));
				u.setDateCreated(rs.getString("user_dateCreated"));
				u.setDateUpdated(rs.getString("user_dateUpdated"));
				u.setUserLevel(rs.getString("user_level"));
				u.setUserPoints(rs.getInt("user_points"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<User> adminGetAllRecords(){
		List<User> list=new ArrayList<User>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUserId(rs.getString("user_id"));
				u.setEmail(rs.getString("user_email"));
				u.setPassword(rs.getString("user_password"));
				u.setFirstName(rs.getString("user_firstName"));
				u.setMiddleName(rs.getString("user_middleName"));
				u.setLastName(rs.getString("user_lastName"));
				u.setFullName(rs.getString("user_firstName"), rs.getString("user_middleName"), rs.getString("user_lastName"));
				u.setUserPoints(rs.getInt("user_points"));
				u.setDateCreated(rs.getString("user_dateCreated"));
				u.setDateUpdated(rs.getString("user_dateUpdated"));
				u.setUserLevel(rs.getString("user_level"));
				u.setNumber(rs.getString("user_number"));
				u.setYear(rs.getString("user_year"));
				u.setSection(rs.getString("user_section"));
				u.setUserPoints(rs.getInt("user_points"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static User getRecordByUserId(String id){
		User u=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user where user_id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u=new User();
				u.setUserId(rs.getString("user_id"));
				u.setEmail(rs.getString("user_email"));
				u.setPassword(rs.getString("user_password"));
				u.setFirstName(rs.getString("user_firstName"));
				u.setMiddleName(rs.getString("user_middleName"));
				u.setLastName(rs.getString("user_lastName"));
				u.setDateCreated(rs.getString("user_dateCreated"));
				u.setDateUpdated(rs.getString("user_dateUpdated"));
				u.setUserLevel(rs.getString("user_level"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
	public static int givePoint(String user_id) {
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps2=con.prepareStatement("select user_points from user where user_id=?");
			ps2.setString(1, user_id);
			ResultSet rs = ps2.executeQuery();
			rs.next();
			int user_points = rs.getInt(1);
			PreparedStatement ps=con.prepareStatement("update user set user_points=? where user_id=?");
			ps.setInt(1, user_points + 1);
			ps.setString(2, user_id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	 
	
	
	
	
}//end class
