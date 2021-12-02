package com.organissembly.dao;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.organissembly.bean.Member;
import com.organissembly.bean.Registrant;
public class RegistrantDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_dev","organiss_root","zephyrus12#");
			
			
			//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
	//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
	//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","root","zephyrus12");
			//	con=DriverManager.getConnection("jdbc:mysql://216.231.128.40/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			}catch(Exception e){System.out.println(e);}
		return con;
}
	
	public String getUID() {
		String lastId = "Reg_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from registrant");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Reg_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}
	
	public static int isExisting(Registrant u){
		int status=0;
		ResultSet rs = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select count(*) from registrant where registrant_memberId=? and registrant_orgId=? and registrant_eventId=?");
			ps.setString(1,u.getRegistrantMemberId());
			ps.setString(2,u.getRegistrantOrgId());
			ps.setString(3,u.getRegistrantEventId());
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
	
	public static int save(Registrant u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into registrant(registrant_id,registrant_memberId,registrant_orgId,registrant_eventId,registrant_eventName,registrant_name,registrant_isPresent,registrant_dateCreated) values (?,?,?,?,?,?,?,?);");
			ps.setString(1,u.getRegistrantId());
			ps.setString(2,u.getRegistrantMemberId());
			ps.setString(3,u.getRegistrantOrgId());
			ps.setString(4,u.getRegistrantEventId());
			ps.setString(5,u.getRegistrantEventName());
			ps.setString(6,u.getRegistrantName());
			ps.setString(7,"No");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(8,dateTime);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int updateSingle(Registrant u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update registrant set registrant_isPresent=? where registrant_id=?");
			ps.setString(1,u.getRegistrantIsPresent());
			ps.setString(2,u.getRegistrantId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int updateAll(Registrant u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update registrant set registrant_isPresent=? where registrant_orgId=?");
			ps.setString(1,"Yes");
			ps.setString(2,u.getRegistrantOrgId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Registrant u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from registrant where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public static List<Registrant> getAllRecords(List<String> orgId){
		List<Registrant> list=new ArrayList<Registrant>();
		try{
			Connection con=getConnection();
			//PreparedStatement ps=con.prepareStatement("select * from registrant where registrant_orgId=? order by registrant_eventId ASC");
			PreparedStatement ps=con.prepareStatement("select registrant.id,registrant.registrant_memberId,registrant.registrant_orgId,registrant.registrant_eventName,user.user_firstName,user.user_middleName,user.user_lastName,registrant.registrant_isPresent,registrant.registrant_dateCreated,user.user_number,user.user_year,user.user_section from registrant inner join user on registrant.registrant_memberId=user.user_id where registrant.registrant_orgId=? order by registrant.registrant_eventId ASC");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Registrant u=new Registrant();
					u.setId(rs.getInt("registrant.id"));
					u.setRegistrantId(rs.getString("registrant.registrant_memberId"));
					u.setRegistrantOrgId(rs.getString("registrant.registrant_orgId"));
					u.setRegistrantEventName(rs.getString("registrant.registrant_eventName"));
					u.setFirstName(rs.getString("user.user_firstName"));
					u.setMiddleName(rs.getString("user.user_middleName"));
					u.setLastName(rs.getString("user.user_lastName"));
					u.setRegistrantIsPresent(rs.getString("registrant.registrant_isPresent"));
					u.setRegistrantDateCreated(rs.getString("registrant.registrant_dateCreated"));
					u.setNumber(rs.getString("user.user_number"));
					u.setYear(rs.getString("user.user_year"));
					u.setSection(rs.getString("user.user_section"));
					list.add(u);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public List<String> getOrgIdByUserId(String userId){
		List<String> orgId = new ArrayList<String>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from member where member_userId=? and member_isActive=?");
			ps.setString(1,userId);
			ps.setString(2,"Yes");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String tempOrg = null;
				tempOrg=rs.getString("member_orgId");
				orgId.add(tempOrg);
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
