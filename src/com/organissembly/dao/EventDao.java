package com.organissembly.dao;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;

import com.organissembly.bean.Event;


public class EventDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone_dev","capstone_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delwio67_prod","delwio67_root","zephyrus12#");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
		//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ustorgan_prod","ustorgan_root","zephyrus12#");
			//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/organiss_ustorgan_prod","root","zephyrus12");
			//	con=DriverManager.getConnection("jdbc:mysql://216.231.128.40/organiss_ustorgan_prod","organiss_root","organissemblyzephyrus12");
			}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public String getUID() {
		String lastId = "Event_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from event");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Event_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}
	
	public static int save(Event u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into event(event_id,event_orgId,event_postedById,event_title,event_description,event_status,event_isApproved,event_isEnabled,event_dateCreated,event_orgName) values (?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1,u.getEventId());
			ps.setString(2,u.getEventOrgId());
			ps.setString(3,u.getEventPostedById());
			ps.setString(4,u.getEventTitle());
			ps.setString(5,u.getEventDescription());
			ps.setString(6,"Upcoming");
			ps.setString(7,"No");
			ps.setString(8,"No");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(9,dateTime);
			ps.setString(10, u.getEventOrgName());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(Event u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update event set event_postedById=?,event_title=?,event_description=?,event_status=?,event_isApproved=?,event_isEnabled=? where event_id=?");
			ps.setString(1,u.getEventPostedById());
			ps.setString(2,u.getEventTitle());
			ps.setString(3,u.getEventDescription());
			ps.setString(4,u.getEventStatus());
			ps.setString(5,u.getEventIsApproved());
			ps.setString(6,u.getEventIsEnabled());
			ps.setString(7,u.getEventId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Event u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from event where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public List<Event> getAllRecords(List<String> orgId){
		List<Event> list=new ArrayList<Event>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from event where event_orgId=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Event u=new Event();
					u.setId(rs.getInt("id"));
					u.setEventId(rs.getString("event_id"));
					u.setEventOrgId(rs.getString("event_orgId"));
					u.setEventPostedById(rs.getString("event_postedById"));
					u.setEventTitle(rs.getString("event_title"));
					u.setEventDescription(rs.getString("event_description"));
					u.setEventStatus(rs.getString("event_status"));
					u.setEventIsApproved(rs.getString("event_isApproved"));
					u.setEventIsEnabled(rs.getString("event_isEnabled"));
					u.setEventDateCreated(rs.getString("event_dateCreated"));
					u.setEventOrgName(rs.getString("event_orgName"));
					list.add(u);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	public List<Event> getAllEnabledRecords(List<String> orgId){
		List<Event> list=new ArrayList<Event>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from event where event_orgId=? and event_status=? and event_isApproved=? and event_isEnabled=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"Upcoming");
				ps.setString(3,"Yes");
				ps.setString(4,"Yes");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Event u=new Event();
					u.setId(rs.getInt("id"));
					u.setEventId(rs.getString("event_id"));
					u.setEventOrgId(rs.getString("event_orgId"));
					u.setEventPostedById(rs.getString("event_postedById"));
					u.setEventTitle(rs.getString("event_title"));
					u.setEventDescription(rs.getString("event_description"));
					u.setEventStatus(rs.getString("event_status"));
					u.setEventIsApproved(rs.getString("event_isApproved"));
					u.setEventIsEnabled(rs.getString("event_isEnabled"));
					u.setEventDateCreated(rs.getString("event_dateCreated"));
					u.setEventOrgName(rs.getString("event_orgName"));
					list.add(u);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Event> getAllApprovalRecords(List<String> orgId){
		List<Event> list=new ArrayList<Event>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from event where event_orgId=? and event_isApproved=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"No");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Event u=new Event();
					u.setId(rs.getInt("id"));
					u.setEventId(rs.getString("event_id"));
					u.setEventOrgId(rs.getString("event_orgId"));
					u.setEventPostedById(rs.getString("event_postedById"));
					u.setEventTitle(rs.getString("event_title"));
					u.setEventDescription(rs.getString("event_description"));
					u.setEventStatus(rs.getString("event_status"));
					u.setEventIsApproved(rs.getString("event_isApproved"));
					u.setEventIsEnabled(rs.getString("event_isEnabled"));
					u.setEventDateCreated(rs.getString("event_dateCreated"));
					u.setEventOrgName(rs.getString("event_orgName"));
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
	
	public List<String> getEventOrgName(String orgId) {
		List<String> orgName = new ArrayList<String>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select org_name from organization where org_id=?");
			ps.setString(1, orgId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String resultOrgName = null;
				resultOrgName = rs.getString("org_name");
				orgName.add(resultOrgName);
			}
		}catch(Exception e){System.out.println(e);}
		return orgName;
	}
}
