package com.organissembly.dao;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.organissembly.bean.Member;
public class MemberDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_dev","organiss_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
		//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
			//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","root","zephyrus12");
			//	con=DriverManager.getConnection("jdbc:mysql://216.231.128.40/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int isExisting(Member u){
		int status=0;
		ResultSet rs = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select count(*) from member where member_userId=? and member_orgId=?");
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getOrgId());
			rs=ps.executeQuery();
		    if(rs.next()) {
		        int numberOfRows = rs.getInt(1);
		        //System.out.println("numberOfRows= " + numberOfRows);
		        if(numberOfRows == 0)
		        {
		        	// user is not yet existing
		        	status = 0;
		        }
		        else
		        {
			    	// user exists
		            status = 1;
		        } 
		    }  else {
		    	System.out.println("error: could not get the record counts");
		    }
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int save(Member u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into member(member_userId,member_orgId,member_isActive,member_role,member_dateJoined) values (?,?,?,?,?);");
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getOrgId());
			ps.setString(3,"No");
			ps.setString(4,"Member");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(5,dateTime);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int saveApprove(Member u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into member(member_userId,member_orgId,member_isActive,member_role,member_dateJoined) values (?,?,?,?,?);");
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getOrgId());
			ps.setString(3,"Yes");
			ps.setString(4,"Staff");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(5,dateTime);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(Member u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update member set member_isActive=? where member_userId=? and member_orgId=?");
			ps.setString(1,"Yes");
			ps.setString(2,u.getUserId());
			ps.setString(3,u.getOrgId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Member u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from member where member_userId=? and member_orgId=?");
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getOrgId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public static List<Member> getAllRecords(String orgId){
		List<Member> list=new ArrayList<Member>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select member.id,member.member_userId,member.member_orgId,user.user_firstName,user.user_middleName,user.user_lastName,user.user_level,member.member_isActive,member.member_dateJoined,user.user_number,user.user_year,user.user_section from member inner join user on member.member_userId=user.user_id where member.member_orgId=?");
			ps.setString(1,orgId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Member u=new Member();
				u.setId(rs.getInt("member.id"));
				u.setUserId(rs.getString("member.member_userId"));
				u.setOrgId(rs.getString("member.member_orgId"));
				u.setFirstName(rs.getString("user.user_firstName"));
				u.setMiddleName(rs.getString("user.user_middleName"));
				u.setLastName(rs.getString("user.user_lastName"));
				u.setUserLevel(rs.getString("user.user_level"));
				u.setIsActive(rs.getString("member.member_isActive"));
				u.setDateJoined(rs.getString("member.member_dateJoined"));
				u.setNumber(rs.getString("user.user_number"));
				u.setYear(rs.getString("user.user_year"));
				u.setSection(rs.getString("user.user_section"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Member> getAllEnabledRecords(String orgId){
		List<Member> list=new ArrayList<Member>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select member.id,member.member_userId,member.member_orgId,user.user_firstName,user.user_middleName,user.user_lastName,user.user_level,member.member_isActive,member.member_dateJoined,user.user_number,user.user_year,user.user_section from member inner join user on member.member_userId=user.user_id where member.member_orgId=? and member.member_isActive=?");
			ps.setString(1,orgId);
			ps.setString(2,"Yes");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Member u=new Member();
				u.setId(rs.getInt("member.id"));
				u.setUserId(rs.getString("member.member_userId"));
				u.setOrgId(rs.getString("member.member_orgId"));
				u.setFirstName(rs.getString("user.user_firstName"));
				u.setMiddleName(rs.getString("user.user_middleName"));
				u.setLastName(rs.getString("user.user_lastName"));
				u.setUserLevel(rs.getString("user.user_level"));
				u.setIsActive(rs.getString("member.member_isActive"));
				u.setDateJoined(rs.getString("member.member_dateJoined"));
				u.setNumber(rs.getString("user.user_number"));
				u.setYear(rs.getString("user.user_year"));
				u.setSection(rs.getString("user.user_section"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Member> getAllApplicantRecords(String orgId){
		List<Member> list=new ArrayList<Member>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select member.id,member.member_userId,member.member_orgId,user.user_firstName,user.user_middleName,user.user_lastName,user.user_level,member.member_isActive,member.member_dateJoined,user.user_number,user.user_year,user.user_section from member inner join user on member.member_userId=user.user_id where member.member_orgId=? and member.member_isActive=?");
			ps.setString(1,orgId);
			ps.setString(2,"No");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Member u=new Member();
				u.setId(rs.getInt("member.id"));
				u.setUserId(rs.getString("member.member_userId"));
				u.setOrgId(rs.getString("member.member_orgId"));
				u.setFirstName(rs.getString("user.user_firstName"));
				u.setMiddleName(rs.getString("user.user_middleName"));
				u.setLastName(rs.getString("user.user_lastName"));
				u.setUserLevel(rs.getString("user.user_level"));
				u.setIsActive(rs.getString("member.member_isActive"));
				u.setDateJoined(rs.getString("member.member_dateJoined"));
				u.setNumber(rs.getString("user.user_number"));
				u.setYear(rs.getString("user.user_year"));
				u.setSection(rs.getString("user.user_section"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static String getOrgIdByUserId(String userId){
		String orgId=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from member where member_userId=?");
			ps.setString(1,userId);
			ResultSet rs=ps.executeQuery();
			if(rs.first()){
				orgId=rs.getString("member_orgId");
			}
		}catch(Exception e){System.out.println(e);}
		return orgId;
	}
	
	public static Member getRecordByUserId(String id){
		Member u=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from member where member_userId=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u=new Member();
				u.setUserId(rs.getString("user_id"));
				//u.setEmail(rs.getString("user_email"));
				//u.setPassword(rs.getString("user_password"));
				//u.setFirstName(rs.getString("user_firstName"));
				//u.setMiddleName(rs.getString("user_middleName"));
				//u.setLastName(rs.getString("user_lastName"));
				//u.setDateCreated(rs.getString("user_dateCreated"));
				//u.setDateUpdated(rs.getString("user_dateUpdated"));
				//u.setUserLevel(rs.getString("user_level"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
}
