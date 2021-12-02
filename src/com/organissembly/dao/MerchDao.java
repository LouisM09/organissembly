package com.organissembly.dao;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import javax.servlet.annotation.MultipartConfig;

import com.organissembly.bean.Merch;

@MultipartConfig(maxFileSize = 16177215)
public class MerchDao {
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
		String lastId = "Merch_0";
		try{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from merch");
			int tempId = 0;
			if(rs.last()){
				tempId=rs.getInt("id");
				lastId = "Merch_"+String.valueOf(tempId);
			}
		}catch(Exception e){System.out.println(e);}
		return lastId;
	}
	
	public static int save(Merch u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into merch(merch_id,merch_orgId,merch_postedById,merch_name,merch_image,merch_price,merch_description,merch_isApproved,merch_isEnabled,merch_dateCreated) values (?,?,?,?,?,?,?,?,?,?);");
			InputStream inputStream = null;
			inputStream = u.getMerchImage();
			ps.setString(1,u.getMerchId());
			ps.setString(2,u.getMerchOrgId());
			ps.setString(3,u.getMerchPostedById());
			ps.setString(4,u.getMerchName());
			ps.setBinaryStream(5, inputStream, inputStream.available());
			ps.setString(6,u.getMerchPrice());
			ps.setString(7,u.getMerchDescription());
			ps.setString(8,"No");
			ps.setString(9,"No");
			LocalDateTime ldt = LocalDateTime.now();
			String dateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(ldt);
			ps.setString(10,dateTime);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int update(Merch u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update merch set merch_postedById=?,merch_name=?,merch_image=?,merch_price=?,merch_description=?,merch_isApproved=?,merch_isEnabled=? where merch_id=?");
			InputStream inputStream = null;
			inputStream = u.getMerchImage();
			ps.setString(1,u.getMerchPostedById());
			ps.setString(2,u.getMerchName());
			ps.setBinaryStream(3, inputStream, inputStream.available());
			ps.setString(4,u.getMerchPrice());
			ps.setString(5,u.getMerchDescription());
			ps.setString(6,u.getMerchIsApproved());
			ps.setString(7,u.getMerchIsEnabled());
			ps.setString(8,u.getMerchId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Merch u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from merch where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	
		return status;
	}
	
	public List<Merch> getAllRecords(List<String> orgId){
		List<Merch> list=new ArrayList<Merch>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from merch where merch_orgId=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Merch u=new Merch();
					u.setId(rs.getInt("id"));
					u.setMerchId(rs.getString("merch_id"));
					u.setMerchOrgId(rs.getString("merch_orgId"));
					u.setMerchPostedById(rs.getString("merch_postedById"));
					u.setMerchName(rs.getString("merch_name"));
					u.setMerchImage(rs.getBinaryStream("merch_image"));
					u.setMerchPrice(rs.getString("merch_price"));
					u.setMerchDescription(rs.getString("merch_description"));
					u.setMerchIsApproved(rs.getString("merch_isApproved"));
					u.setMerchIsEnabled(rs.getString("merch_isEnabled"));
					u.setMerchDateCreated(rs.getString("merch_dateCreated"));
					
	                Blob blob = rs.getBlob("merch_image");
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
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	public List<Merch> getAllEnabledRecords(List<String> orgId){
		List<Merch> list=new ArrayList<Merch>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from merch where merch_orgId=? and merch_isApproved=? and merch_isEnabled=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"Yes");
				ps.setString(3,"Yes");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Merch u=new Merch();
					u.setId(rs.getInt("id"));
					u.setMerchId(rs.getString("merch_id"));
					u.setMerchOrgId(rs.getString("merch_orgId"));
					u.setMerchPostedById(rs.getString("merch_postedById"));
					u.setMerchName(rs.getString("merch_name"));
					u.setMerchImage(rs.getBinaryStream("merch_image"));
					u.setMerchPrice(rs.getString("merch_price"));
					u.setMerchDescription(rs.getString("merch_description"));
					u.setMerchIsApproved(rs.getString("merch_isApproved"));
					u.setMerchIsEnabled(rs.getString("merch_isEnabled"));
					u.setMerchDateCreated(rs.getString("merch_dateCreated"));
					
	                Blob blob = rs.getBlob("merch_image");
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
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Merch> getAllApprovalRecords(List<String> orgId){
		List<Merch> list=new ArrayList<Merch>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from merch where merch_orgId=? and merch_isApproved=?");
			for(int i=0;i < orgId.size();i++) {
				ps.setString(1,orgId.get(i));
				ps.setString(2,"No");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Merch u=new Merch();
					u.setId(rs.getInt("id"));
//					u.setEventId(rs.getString("event_id"));
//					u.setEventOrgId(rs.getString("event_orgId"));
//					u.setEventPostedById(rs.getString("event_postedById"));
//					u.setEventTitle(rs.getString("event_title"));
//					u.setEventDescription(rs.getString("event_description"));
//					u.setEventStatus(rs.getString("event_status"));
//					u.setEventIsApproved(rs.getString("event_isApproved"));
//					u.setEventIsEnabled(rs.getString("event_isEnabled"));
//					u.setEventDateCreated(rs.getString("event_dateCreated"));
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
}
