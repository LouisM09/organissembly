package com.organissembly.dao;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import com.organissembly.bean.Organization;
import com.organissembly.bean.User;
public class OrgDao {
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

	public static String getUID() {
		String lastId = "Oi_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from organization");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Oi_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}
	
	public static int save(Organization u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into organization(org_id,org_name,org_about,org_vision,org_mission,org_calendarImage,org_adviserId,org_presidentId,org_secretaryId,org_proId,org_isEnabled) values (?,?,?,?,?,?,?,?,?,?,?);");
			InputStream inputStream = null;
			inputStream = u.getOrgImage();
			ps.setString(1,getUID());
			ps.setString(2,u.getOrgName());
			ps.setString(3,u.getOrgAbout());
			ps.setString(4,u.getOrgVision());
			ps.setString(5,u.getOrgMission());
			ps.setBinaryStream(6, inputStream, inputStream.available());
			ps.setString(7,u.getOrgAdviserId());
			ps.setString(8,u.getOrgPresidentId());
			ps.setString(9,u.getOrgSecretaryId());
			ps.setString(10,u.getOrgProId());
			ps.setString(11,"Yes");
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(Organization u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update organization set org_name=?,org_about=?,org_vision=?,org_mission=?,org_calendarImage=?,org_adviserId=?,org_presidentId=?,org_secretaryId=?,org_proId=?,org_isEnabled=? where org_id=?");
			InputStream inputStream = null;
			inputStream = u.getOrgImage();
			ps.setString(1,u.getOrgName());
			ps.setString(2,u.getOrgAbout());
			ps.setString(3,u.getOrgVision());
			ps.setString(4,u.getOrgMission());
			ps.setBinaryStream(5, inputStream, inputStream.available());
			ps.setString(6,u.getOrgAdviserId());
			ps.setString(7,u.getOrgPresidentId());
			ps.setString(8,u.getOrgSecretaryId());
			ps.setString(9,u.getOrgProId());
			ps.setString(10,u.getIsEnabled());
			ps.setString(11,u.getOrgId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int updateDetails(Organization u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update organization set org_name=?,org_about=?,org_vision=?,org_mission=?,org_calendarImage=? where org_id=?");
			InputStream inputStream = null;
			inputStream = u.getOrgImage();
			ps.setString(1,u.getOrgName());
			ps.setString(2,u.getOrgAbout());
			ps.setString(3,u.getOrgVision());
			ps.setString(4,u.getOrgMission());
			ps.setBinaryStream(5, inputStream, inputStream.available());
			ps.setString(6,u.getOrgId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	
	public static int updateUserLevel(String userId, String userLevel){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update user set user_level=? where user_id=?");
			ps.setString(1,userLevel);
			ps.setString(2,userId);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<Organization> getAllRecords(){
		List<Organization> list=new ArrayList<Organization>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from organization");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Organization u=new Organization();
				u.setId(rs.getInt("id"));
				u.setOrgId(rs.getString("org_id"));
				u.setOrgName(rs.getString("org_name"));
				u.setOrgAbout(rs.getString("org_about"));
				u.setOrgVision(rs.getString("org_vision"));
				u.setOrgMission(rs.getString("org_mission"));
				u.setOrgAdviserId(rs.getString("org_adviserId"));
				u.setOrgPresidentId(rs.getString("org_presidentId"));
				u.setOrgSecretaryId(rs.getString("org_secretaryId"));
				u.setOrgProId(rs.getString("org_proId"));
				u.setOrgAdviserName(getUserName(rs.getString("org_adviserId")));
				u.setOrgPresidentName(getUserName(rs.getString("org_presidentId")));
				u.setOrgSecretaryName(getUserName(rs.getString("org_secretaryId")));
				u.setOrgProName(getUserName(rs.getString("org_proId")));
				u.setIsEnabled(rs.getString("org_isEnabled"));
				u.setOrgImage(rs.getBinaryStream("org_calendarImage"));
				
                Blob blob = rs.getBlob("org_calendarImage");
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                     
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);                  
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    inputStream.close();
                    outputStream.close();
                    
    				u.setBase64Image(base64Image);
                } else {
                	u.setBase64Image(null);
                }
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static List<Organization> getSpecificOrganization(String a){
		List<Organization> list=new ArrayList<Organization>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from organization where org_id=?");
			ps.setString(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Organization u=new Organization();
				u.setId(rs.getInt("id"));
				u.setOrgId(rs.getString("org_id"));
				u.setOrgName(rs.getString("org_name"));
				u.setOrgAbout(rs.getString("org_about"));
				u.setOrgVision(rs.getString("org_vision"));
				u.setOrgMission(rs.getString("org_mission"));
				u.setOrgAdviserId(rs.getString("org_adviserId"));
				u.setOrgPresidentId(rs.getString("org_presidentId"));
				u.setOrgSecretaryId(rs.getString("org_secretaryId"));
				u.setOrgProId(rs.getString("org_proId"));
				u.setOrgAdviserName(getUserName(rs.getString("org_adviserId")));
				u.setOrgPresidentName(getUserName(rs.getString("org_presidentId")));
				u.setOrgSecretaryName(getUserName(rs.getString("org_secretaryId")));
				u.setOrgProName(getUserName(rs.getString("org_proId")));
				u.setIsEnabled(rs.getString("org_isEnabled"));
				u.setOrgImage(rs.getBinaryStream("org_calendarImage"));
				
                Blob blob = rs.getBlob("org_calendarImage");
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                     
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);                  
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    inputStream.close();
                    outputStream.close();
                    
    				u.setBase64Image(base64Image);
                } else {
                	u.setBase64Image(null);
                }
				list.add(u);
			}
		
		
		
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Organization> getAllEnabledRecords(){
		List<Organization> list=new ArrayList<Organization>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from organization where org_isEnabled=?");
			ps.setString(1,"Yes");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Organization u=new Organization();
				u.setId(rs.getInt("id"));
				u.setOrgId(rs.getString("org_id"));
				u.setOrgName(rs.getString("org_name"));
				u.setOrgAbout(rs.getString("org_about"));
				u.setOrgVision(rs.getString("org_vision"));
				u.setOrgMission(rs.getString("org_mission"));
				u.setOrgAdviserId(rs.getString("org_adviserId"));
				u.setOrgPresidentId(rs.getString("org_presidentId"));
				u.setOrgSecretaryId(rs.getString("org_secretaryId"));
				u.setOrgProId(rs.getString("org_proId"));
				u.setOrgAdviserName(getUserName(rs.getString("org_adviserId")));
				u.setOrgPresidentName(getUserName(rs.getString("org_presidentId")));
				u.setOrgSecretaryName(getUserName(rs.getString("org_secretaryId")));
				u.setOrgProName(getUserName(rs.getString("org_proId")));
				u.setIsEnabled(rs.getString("org_isEnabled"));
				u.setOrgImage(rs.getBinaryStream("org_calendarImage"));
				
                Blob blob = rs.getBlob("org_calendarImage");
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                     
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);                  
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    inputStream.close();
                    outputStream.close();
                    
    				u.setBase64Image(base64Image);
                } else {
                	u.setBase64Image(null);
                }
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static String getUserName(String id) {
		String fullName = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select user_firstName,user_middleName,user_lastName from user where user_id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				fullName = rs.getString("user_firstName")+" "+rs.getString("user_middleName")+" "+rs.getString("user_lastName");
			}
		}catch(Exception e){System.out.println(e);}
		return fullName;
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
	
	public static List<String> getAffiliateOrgs(String userId) {
		List<String> orgList = new ArrayList<String>();
		List<String> orgNames = new ArrayList<String>();
		// get list of orgId associated with user
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select member_orgId from member where member_userId=?");
			ps.setString(1,userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String orgId = rs.getString("member_orgId");
				orgList.add(orgId);
			}
		}catch(Exception e){System.out.println(e);}
		
		// get Organization name list associated with user
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select org_name from organization where org_id=?");
			for(int i=0;i < orgList.size();i++) {
				ps.setString(1,orgList.get(i));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					String orgName = rs.getString("org_name");
					orgNames.add(orgName);
				}
			}
		}catch(Exception e){System.out.println(e);}
		return orgNames;
	}
	
	public String getOrgName(String orgId) {
		String resultOrgName = "test";
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("Select org_name from organization where org_id=?");
			ps.setString(1, orgId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			resultOrgName = rs.getString("org_name");
		}catch(SQLException e) {
			System.out.println(e);
		}

		return resultOrgName; 
	}
}
