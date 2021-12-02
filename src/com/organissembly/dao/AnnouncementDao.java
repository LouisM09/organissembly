package com.organissembly.dao;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.organissembly.bean.Announcement;

public class AnnouncementDao {
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
	
	public static String getUID() {
		String lastId = "Anoun_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from announcement");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Anoun_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}
	
	public static int save(Announcement u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into announcement(announcement_id,announcement_orgId,announcement_postedById,announcement_title,announcement_body,announcement_isApproved,announcement_isEnabled,announcement_dateCreated,announcement_orgName) values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1,u.getAnnouncementId());
			ps.setString(2,u.getAnnouncementOrgId());
			ps.setString(3,u.getAnnouncementPostedById());
			ps.setString(4,u.getAnnouncementTitle());
			ps.setString(5,u.getAnnouncementBody());
			ps.setString(6,"No");
			ps.setString(7,"No");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(8,dateTime);
			ps.setString(9, u.getAnnouncementOrgName());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(Announcement u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update announcement set announcement_postedById=?,announcement_title=?,announcement_body=?,announcement_isApproved=?,announcement_isEnabled=? where announcement_id=?");
			ps.setString(1,u.getAnnouncementPostedById());
			ps.setString(2,u.getAnnouncementTitle());
			ps.setString(3,u.getAnnouncementBody());
			ps.setString(4,u.getAnnouncementIsApproved());
			ps.setString(5,u.getAnnouncementIsEnabled());
			ps.setString(6,u.getAnnouncementId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Announcement u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from announcement where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public List<Announcement> getAllRecords(List<String> orgId){
		List<Announcement> list=new ArrayList<Announcement>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from announcement where announcement_orgId=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Announcement u=new Announcement();
					u.setId(rs.getInt("id"));
					u.setAnnouncementId(rs.getString("announcement_id"));
					u.setAnnouncementOrgId(rs.getString("announcement_orgId"));
					u.setAnnouncementPostedById(rs.getString("announcement_postedById"));
					u.setAnnouncementTitle(rs.getString("announcement_title"));
					u.setAnnouncementBody(rs.getString("announcement_body"));
					u.setAnnouncementIsApproved(rs.getString("announcement_isApproved"));
					u.setAnnouncementIsEnabled(rs.getString("announcement_isEnabled"));
					u.setAnnouncementDateCreated(rs.getString("announcement_dateCreated"));
					u.setAnnouncementOrgName(rs.getString("announcement_orgName"));
					list.add(u);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	public List<Announcement> getAllEnabledRecords(List<String> orgId){
		List<Announcement> list=new ArrayList<Announcement>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from announcement where announcement_orgId=? and announcement_isApproved=? and announcement_isEnabled=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"Yes");
				ps.setString(3,"Yes");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Announcement u=new Announcement();
					u.setId(rs.getInt("id"));
					u.setAnnouncementId(rs.getString("announcement_id"));
					u.setAnnouncementOrgId(rs.getString("announcement_orgId"));
					u.setAnnouncementPostedById(rs.getString("announcement_postedById"));
					u.setAnnouncementTitle(rs.getString("announcement_title"));
					u.setAnnouncementBody(rs.getString("announcement_body"));
					u.setAnnouncementIsApproved(rs.getString("announcement_isApproved"));
					u.setAnnouncementIsEnabled(rs.getString("announcement_isEnabled"));
					u.setAnnouncementDateCreated(rs.getString("announcement_dateCreated"));
					u.setAnnouncementOrgName(rs.getString("announcement_orgName"));
					list.add(u);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Announcement> getAllApprovalRecords(List<String> orgId){
		List<Announcement> list=new ArrayList<Announcement>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from announcement where announcement_orgId=? and announcement_isApproved=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"No");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Announcement u=new Announcement();
					u.setId(rs.getInt("id"));
					u.setAnnouncementId(rs.getString("announcement_id"));
					u.setAnnouncementOrgId(rs.getString("announcement_orgId"));
					u.setAnnouncementPostedById(rs.getString("announcement_postedById"));
					u.setAnnouncementTitle(rs.getString("announcement_title"));
					u.setAnnouncementBody(rs.getString("announcement_body"));
					u.setAnnouncementIsApproved(rs.getString("announcement_isApproved"));
					u.setAnnouncementIsEnabled(rs.getString("announcement_isEnabled"));
					u.setAnnouncementDateCreated(rs.getString("announcement_dateCreated"));
					u.setAnnouncementOrgName(rs.getString("announcement_orgName"));
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
	
	public List<String> getAnnounOrgName(String orgId) {
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

