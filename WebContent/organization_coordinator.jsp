<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

textarea {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  resize: none;
}

/* Set a style for all buttons */
button {
  border-radius: 25px;
  background-color: #000000;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: 100%;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Extra styles for the normal button */
.normalbtn {
  border-radius: 0px;
  font-size: 20px;
  width: 100%;
  padding: 0px px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #FECC36;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 20%; /* Could be more or less, depending on screen size */
  min-width: 300px;
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}

<!-- START OF MAIN -->
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

/* Header/logo Title */
.header {
  padding: 10px;
  text-align: center;
  background: #FECC36;
  color: black;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 40px;
}

/* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
.navbar {
  overflow: hidden;
  background-color: #000000;
  position: sticky;
  position: -webkit-sticky;
  top: 0;
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}


/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
}

/* Main column */
.main {   
  -ms-flex: 100%; /* IE10 */
  flex: 100%;
  background-color: white;
  padding: 40px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Footer */
.footer {
  padding: 5px;
  text-align: center;
  background: #000000;
  color: white;
  position: fixed;
  bottom: 0;
}

/* centeredDiv */
.centeredDiv {
  padding: 20px;
  text-align: center;
  vertical-align: middle;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
<!-- Child layout -->
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

/* The grid: Three equal columns that floats next to each other */
.column {
  float: center;
  width: 31%;
  padding: 20px;
  text-align: center;
  font-size: 25px;
  cursor: pointer;
  color: white;
}

.containerTab {
  padding: 20px;
  color: white;
}
</style>
</head>
<body>
<!--<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>-->

<div id="id02" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/logout" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <label><b>Do you really want to logout?</b></label>
        
      <button type="submit">Logout</button>
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div id="id03" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/account" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id03').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="account.jpg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <input type="hidden" name="userId" value="<%=session.getAttribute("userId").toString()%>"/>
      <input type="hidden" name="userRole" value="<%=session.getAttribute("userRole").toString()%>"/>

      <label><b>Email</b></label>
      <input type="text" name="email" required value="<%=session.getAttribute("email").toString()%>"/>
      
      <label><b>First Name</b></label>
      <input type="text" name="firstName" required value="<%=session.getAttribute("firstName").toString()%>"/>
      
      <label><b>Middle Name</b></label>
      <input type="text" name="middleName" required value="<%=session.getAttribute("middleName").toString()%>"/>
      
      <label><b>Last Name</b></label>
      <input type="text" name="lastName" required value="<%=session.getAttribute("lastName").toString()%>"/>
      
	  <label><b>Password</b></label>
      <input type="password" name="password"  id="password" required value="<%=session.getAttribute("password").toString()%>"/>
       <input type="checkbox" onclick="showPassword()">Show Password
      <input type="hidden" name="dateCreated" required disabled="disabled"/>
      <input type="hidden" name="dateUpdated" required disabled="disabled"/>
        
      <button type="submit" onclick="setValues()">Update User Info</button>
      <button type="button" onclick="document.getElementById('id03').style.display='none'" class="cancelbtn">Cancel</button>
      
      <input type="hidden" name="dateCreated" id="dateC"/>
	  <input type="hidden" name="dateUpdated" id="dateU"/>
    </div>
  </form>
</div>

<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<div id="id04" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/add_org" method="post" enctype="multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id04').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <label for="orgName"><b>Organization Name</b></label>
      <input type="text" placeholder="Enter Organization Name" name="orgName" required>

      <label for="orgAbout"><b>About Organization</b></label>
      <textarea rows=4 cols=40 placeholder="Enter About Organization" name="orgAbout" id="orgAbout" required></textarea>
      
      <label for="orgVision"><b>Organization Vision</b></label>
      <textarea rows=4 cols=40 placeholder="Enter Organization Vision" name="orgVision" id="orgVision" required></textarea>
      
      <label for="orgMission"><b>Organization Mission</b></label>
      <textarea rows=4 cols=40 placeholder="Enter Organization Mission" name="orgMission" id="orgMission" required></textarea>
      
		<%
    	try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = 
         	DriverManager.getConnection
            //("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
         	//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
         	//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
         //	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
	("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
       		Statement statement = connection.createStatement() ;

       		resultset = statement.executeQuery("select * from user where user_year='Faculty'") ;
		%>
      <label for="orgAdviser"><b>Organization Adviser</b></label>
      <select name="orgAdviser" style="width:200px" required>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
            //("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
			//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
      <br><br><label for="orgPresident"><b>Organization President</b></label>
      <br><select name="orgPresident" style="width:200px" required>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
           // ("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/omgvna2s_prod","omgvna2s_root","zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
		//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
	  <br><br><label for="orgSecretary"><b>Organization Secretary</b></label>
      <br><select name="orgSecretary" style="width:200px" required>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
      //      ("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
		//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
	  <br><br><label for="orgPro"><b>Organization P.R.O</b></label>
      <br><select name="orgPro" style="width:200px" required>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <br><br><label for="orgImage"><b>Organization Calendar</b></label>
      <input type="file" name="orgImage" id="orgImage" onchange="document.getElementById('output').src = window.URL.createObjectURL(this.files[0])">
	  <div class="imgcontainer">
		<img id="output" name="output" src="#" alt="Organization Calendar coming soon" class="leftImage" width="280px" height="280px">
      </div>
        
      <button type="submit">Add Organization</button>
      <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div id="id05" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/update_org" method="post" enctype="multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id05').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <label for="editOrgName"><b>Organization Name</b></label>
      <input type="text" placeholder="Enter Organization Name" name="editOrgName" id="editOrgName" required>

      <label for="editOrgAbout"><b>About Organization</b></label>
      <textarea rows=4 cols=40 placeholder="Enter About Organization" name="editOrgAbout" id="editOrgAbout" required></textarea>
      
      <label for="editOrgVision"><b>Organization Vision</b></label>
      <textarea rows=4 cols=40 placeholder="Enter Organization Vision" name="editOrgVision" id="editOrgVision" required></textarea>
      
      <label for="editOrgMission"><b>Organization Mission</b></label>
      <textarea rows=4 cols=40 placeholder="Enter Organization Mission" name="editOrgMission" id="editOrgMission" required></textarea>
      
		<%
    	try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = 
         	DriverManager.getConnection
            //("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
         	//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
         	//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
       //	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
       		Statement statement = connection.createStatement() ;

       		resultset = statement.executeQuery("select * from user where user_year='Faculty'") ;
		%>
      <label for="editOrgAdviser"><b>Organization Adviser</b></label>
      <select name="editOrgAdviser" id="editOrgAdviser" style="width:200px">
      <option value=""></option>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
           // ("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
	//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
      <br><br><label for="editOrgPresident"><b>Organization President</b></label>
      <br><select name="editOrgPresident" id="editOrgPresident" style="width:200px">
      <option value=""></option>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
            //("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
			//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
	  <br><br><label for="editOrgSecretary"><b>Organization Secretary</b></label>
      <br><select name="editOrgSecretary" id="editOrgSecretary" style="width:200px">
      <option value=""></option>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <%
    	try{
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = 
			DriverManager.getConnection
            //("jdbc:mysql://localhost/organiss_dev?user=root&password=zephyrus12");
			//("jdbc:mysql://localhost/delwio67_prod?user=delwio67_root&password=zephyrus12#");
			//("jdbc:mysql://localhost/omgvna2s_prod?user=omgvna2s_root&password=zephyrus12#");
		//	("jdbc:mysql://localhost/organiss_dev?user=organiss_root&password=zephyrus12#");
		("jdbc:mysql://localhost/capstone_dev?user=capstone_root&password=zephyrus12#");
		Statement statement = connection.createStatement() ;

		resultset = statement.executeQuery("select * from user where user_year<>'Faculty'") ;
	  %>
	  <br><br><label for="editOrgPro"><b>Organization P.R.O</b></label>
      <br><select name="editOrgPro" id="editOrgPro" style="width:200px">
      <option value=""></option>
		<%  while(resultset.next()){ %>
            <option value="<%= resultset.getString(2)%>"><%= resultset.getString(5) +" "+ resultset.getString(6) +" "+ resultset.getString(7) %></option>
        <% } %>
        <%
			//**Should I input the codes here?**
        	}
        	catch(Exception e)
        	{
             	out.println("wrong entry"+e);
        	}
		%>
      </select>
      
      <br><label for="editIsEnabled"><b>Is Enabled Status: </b></label>
      <br><select name="editIsEnabled" id="editIsEnabled" style="width:100px" required>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
	  </select>
      
      <br><label for="editOrgImage"><b>Organization Calendar</b></label>
      <input type="file" name="editOrgImage" id="editOrgImage" onchange="document.getElementById('outputEdit').src = window.URL.createObjectURL(this.files[0])">
	  <div class="imgcontainer">
		<img id="outputEdit" name="outputEdit" src="#" alt="Organization Calendar coming soon" class="leftImage" width="280px" height="280px">
      </div>
        
      <input type="hidden" name="orgId" id="orgId"/>
      <input type="hidden" name="oldOrgAdviser" id="oldOrgAdviser"/>
      <input type="hidden" name="oldOrgPresident" id="oldOrgPresident"/>
      <input type="hidden" name="oldOrgSecretary" id="oldOrgSecretary"/>
      <input type="hidden" name="oldOrgPro" id="oldOrgPro"/>
      <button type="submit">Update Organization</button>
      <button type="button" onclick="document.getElementById('id05').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div class="header">
  <h1>Organissembly</h1>
  <p>An <b>student hub</b> for the growling tigers.</p>
  <a href="${pageContext.request.contextPath}/home">
  <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="Avatar" class="avatar">
  </a>
  <div align="right">
  <%@page import="com.organissembly.dao.OrgDao,com.organissembly.bean.*,java.util.*"%>
    <%
    String fullName = session.getAttribute("fullName").toString();
    String userRole = session.getAttribute("userRole").toString();
    String points = session.getAttribute("points").toString();
    List<String> affiliateOrgs = (List<String>) session.getAttribute("affiliateOrgs");
    try {
    	String accountUpdateStatus = session.getAttribute("accountUpdateStatus").toString();
    	if (accountUpdateStatus!=null) {
    		out.println("<b>Account Status Update Failed</b>");
    	}
    } catch (Exception e) {}
    if (fullName!=null) {
    	out.println("<b>Welcome! "+fullName+" - "+userRole+"</b>");
    	out.println("<br><b>User Points: "+points+"</b>");
    	if (userRole.compareTo("Student")!=0) {
    		// for non-students
    		if (affiliateOrgs.size() > 0) {
    			out.println("<br><b>Affiliated Organization: "+affiliateOrgs.get(0)+"</b>");
    		} else {
    			out.println("<br><b>Affiliated Organization: Not yet affiliated</b>");
    		}
    	}
    	
    }
    %>
  </div>
</div>

<div class="navbar">
  <a href="${pageContext.request.contextPath}/home">Home</a>
  <a href="${pageContext.request.contextPath}/org" class="active">Organizations</a>
  <a href="${pageContext.request.contextPath}/users">Users</a>
  <a href="#" class="right" onclick="document.getElementById('id02').style.display='block'">Logout</a>
  <a href="#" class="right" onclick="document.getElementById('id03').style.display='block'">Account Settings</a>
</div>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.organissembly.dao.OrgDao,com.organissembly.bean.*,java.util.*"%>
<%
List<Organization> list = new ArrayList<Organization>();
list = (List<Organization>) session.getAttribute("list");
%>

<div style="width:flex;padding: 0px">
<div class="centeredDiv"><button onclick="document.getElementById('id04').style.display='block'" style="font-size:30px">Add New Organization</button></div>
<div style="width:flex;border:1;padding:10px;">
<c:forEach items="${list}" var="u">
	<div style="width:20%;min-width:300px;align-items:right;background:black;border-top-left-radius:50px;border-top-right-radius: 50px">
		<button class="normalbtn" onclick="document.getElementById('editOrgName').value='${u.getOrgName()}';
											document.getElementById('editIsEnabled').value='${u.getIsEnabled()}';
											document.getElementById('orgId').value='${u.getOrgId()}';
											document.getElementById('editOrgAbout').value='${u.getOrgAbout()}';
											document.getElementById('editOrgVision').value='${u.getOrgVision()}';
											document.getElementById('editOrgMission').value='${u.getOrgMission()}';
											document.getElementById('editOrgAdviser').value='${u.getOrgAdviserId()}';
											document.getElementById('editOrgPresident').value='${u.getOrgPresidentId()}';
											document.getElementById('editOrgSecretary').value='${u.getOrgSecretaryId()}';
											document.getElementById('editOrgPro').value='${u.getOrgProId()}';
											document.getElementById('oldOrgAdviser').value='${u.getOrgAdviserId()}';
											document.getElementById('oldOrgPresident').value='${u.getOrgPresidentId()}';
											document.getElementById('oldOrgSecretary').value='${u.getOrgSecretaryId()}';
											document.getElementById('oldOrgPro').value='${u.getOrgProId()}';
											document.getElementById('outputEdit').src='data:image/jpg;base64,${u.getBase64Image()}';
											document.getElementById('id05').style.display='block'" style="border-top-left-radius:50px;border-top-right-radius: 50px">Update Organization</button>
	</div>
	<div class="centeredDiv" style="background:black;border:2px;border-color:white;border-bottom-left-radius:50px;border-bottom-right-radius: 50px;border-top-right-radius: 50px">
		<div style="width:flex;align-items:center"><h2 style="color:white;align-self:center;">${u.getOrgName()}</h2></div>
		<div style="width:flex;">
			<div class="centeredDiv" style="background:#FED250;border-top-left-radius:50px;border-top-right-radius:50px;">
  				<h2 style="color:black">About</h2>
  				<p style="color:black">${u.getOrgAbout()}</p>
			</div>

			<div class="centeredDiv" style="background:#FEC825">
  				<h2 style="color:black">Vision</h2>
  				<p style="color:black">${u.getOrgVision()}</p>
			</div>

			<div class="centeredDiv" style="background:#F3B701">
		  		<h2 style="color:black">Mission</h2>
		  		<p style="color:black">${u.getOrgMission()}</p>
			</div>
			
			<div class="centeredDiv" style="background:#FED250;border-bottom-left-radius:50px;border-bottom-right-radius:50px;">
				<h2 style="color:black">Calendar</h2>
				<div class="imgcontainer">
					<img src="data:image/jpg;base64,${u.getBase64Image()}" class="leftImage" alt="Organization Calendar coming soon" width="704px" height="382px">
      			</div>
			</div>
		</div>
	</div>
	<!-- Creates List of Organization Roles -->
	<div class="centeredDiv" style="background:black;border:2px;border-color:white;border-radius:50px">
		<div style="width:flex;align-items:center"><h2 style="color:white;align-self:center;">${u.getOrgName()}'s Organizational Structure</h2></div>
		<div style="width:flex;">
			<div class="centeredDiv" style="background:#FED250;border-top-left-radius:50px;border-top-right-radius:50px;">
  				<h2 style="color:black">Adviser</h2>
  				<p style="color:black">${u.getOrgAdviserName()}</p>
			</div>

			<div class="centeredDiv" style="background:#FED250;">
  				<h2 style="color:black">President</h2>
  				<p style="color:black">${u.getOrgPresidentName()}</p>
			</div>
			
			<div class="centeredDiv" style="background:#FED250;">
  				<h2 style="color:black">Secretary</h2>
  				<p style="color:black">${u.getOrgSecretaryName()}</p>
			</div>

			<div class="centeredDiv" style="background:#FED250;border-bottom-left-radius:50px;border-bottom-right-radius:50px;">
		  		<h2 style="color:black">Press Relations Officer</h2>
		  		<p style="color:black">${u.getOrgProName()}</p>
			</div>
		</div>
	</div>
</c:forEach>
</div>
</div>

<div class="footer">
	<p>Organissembly - Copyright 2020. University of Santo Tomas</p>
</div>
     <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src='assets/libs/js/main-js.js'></script>

<script>
// Get the modal
var modal = document.getElementById('id01');
var modal2 = document.getElementById('id02');
var modal3 = document.getElementById('id03');
var modal4 = document.getElementById('id04');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    } else if (event.target == modal2) {
    	modal2.style.display = "none";
    } else if (event.target == modal3) {
    	modal3.style.display = "none";
    } else if (event.target == modal4) {
    	modal4.style.display = "none";
    } else {
    	//  Nothing to do
    }
}

function showPassword() {
	var x = document.getElementById("password");
	if (x.type === "password") {
	    x.type = "text";
	} else {
	    x.type = "password";
	}
}

function setValues() {
	alert("Action has been processed");
	document.getElementById('dateC').value= Date();
	document.getElementById('dateU').value= Date();
}
</script>

</body>
</html>
