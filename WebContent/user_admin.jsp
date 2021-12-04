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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add an active class to highlight the current page */
.topnav a.active {
  background-color: #fecc36;
  color: white;
}

/* Hide the link that should open and close the topnav on small screens */
.topnav .icon {
  display: none;
}
@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

/* The "responsive" class is added to the topnav with JavaScript when the user clicks on the icon. This class makes the topnav look good on small screens (display the links vertically instead of horizontally) */
@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive a.icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}
</style>
</head>
<body>
<!--<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>-->

<div id="id01" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/login" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <label for="uname"><b>Email</b></label>
      <input type="text" placeholder="Enter email" name="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter password" name="password" id="password" required>
      <input type="checkbox" onclick="showPassword()">Show Password
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#000000">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

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
      <input type="password" name="password" required value="<%=session.getAttribute("password").toString()%>"/>
      
      <input type="hidden" name="dateCreated" required disabled="disabled"/>
      <input type="hidden" name="dateUpdated" required disabled="disabled"/>
        
      <button type="submit" onclick="setValues()">Update User Info</button>
      <button type="button" onclick="document.getElementById('id03').style.display='none'" class="cancelbtn">Cancel</button>
      
      <input type="hidden" name="dateCreated" id="dateC"/>
	  <input type="hidden" name="dateUpdated" id="dateU"/>
    </div>
  </form>
</div>

<div id="id04" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/add_org" method="post">
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
        
      <button type="submit">Add Organization</button>
      <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div id="id05" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/add_user" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id05').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
	  <label><b>Email</b></label>
      <input type="text" name="addUserEmail" pattern="^[.a-zA-Z0-9]+@ust+\.edu\.ph$" title="juan.delacruz.iics@ust.edu.ph\cics@edu.ph" required/>
      
      <label><b>Password</b></label>
      <input type="text" name="addUserPassword" required/>
      
      <label><b>First Name</b></label>
      <input type="text" name="addUserFirstName" required/>
      
      <label><b>Middle Name</b></label>
      <input type="text" name="addUserMiddleName" required/>
      
      <label><b>Last Name</b></label>
      <input type="text" name="addUserLastName" required/>
      
	  <label><b>User ID: </b></label>
      <input type="text" name="addUserId" required/>
      
      <br><label for="addUserYear"><b>User Year: </b></label>
      <br><select name="addUserYear" id="addUserYear" style="width:200px" required>
		<option value="First Year">First Year</option>
		<option value="Second Year">Second Year</option>
		<option value="Third Year">Third Year</option>
		<option value="Fourth Year">Fourth Year</option>
		<option value="Faculty">Faculty</option>
	  </select>
	  
	  <label><b>User Section: </b></label>
      <input type="text" name="addUserSection" required/>
	  
	  <br><label for="addUserLevel"><b>User Level: </b></label>
      <br><select name="addUserLevel" id="addUserLevel" style="width:200px" required>
		<option value="Student">Student</option>
		<option value="Student Coordinator">Student Coordinator</option>
		<option value="Organization Representative">Organization Representative</option>
		<option value="Organization Adviser">Organization Adviser</option>
	  </select>
      <input type="hidden" name="dateCreated" id="dateC"/>
      <br><button type="submit" onclick="setValues()">Add User</button>
      <button type="button" onclick="document.getElementById('id05').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div id="id06" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/update_user" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id06').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
	  <label><b>Email</b></label>
	  <input type="text"name="editUserEmail" id="editUserEmail" pattern="^[.a-zA-Z0-9]+@ust+\.edu\.ph$" title="juan.delacruz.iics@ust.edu.ph" required/>

      
      <label><b>Password</b></label>
      <input type="text" name="editUserPassword" id="editUserPassword" required/>
      
      <label><b>First Name</b></label>
      <input type="text" name="editUserFirstName" id="editUserFirstName" required/>
      
      <label><b>Middle Name</b></label>
      <input type="text" name="editUserMiddleName" id="editUserMiddleName" required/>
      
      <label><b>Last Name</b></label>
      <input type="text" name="editUserLastName" id="editUserLastName" required/>
      
	  <label><b>User ID: </b></label>
      <input type="text" name="editUserIdNumber" id="editUserIdNumber" required/>
      
      <br><label for="editUserYear"><b>User Year: </b></label>
      <br><select name="editUserYear" id="editUserYear" style="width:200px" required>
		<option value="First Year">First Year</option>
		<option value="Second Year">Second Year</option>
		<option value="Third Year">Third Year</option>
		<option value="Fourth Year">Fourth Year</option>
		<option value="Faculty">Faculty</option>
	  </select>
	  
	  <label><b>User Section: </b></label>
      <input type="text" name="editUserSection" id="editUserSection" required/>
      
      <br><label for="editUserLevel"><b>User Level: </b></label>
      <br><select name="editUserLevel" id="editUserLevel" style="width:200px" required>
		<option value="Student">Student</option>
		<option value="Student Coordinator">Student Coordinator</option>
		<option value="Organization Representative">Organization Representative</option>
		<option value="Organization Adviser">Organization Adviser</option>
	  </select>
	  <input type="hidden" name="editUserId" id="editUserId"/>
      <input type="hidden" name="dateCreated" id="dateC"/>
      <br><button type="submit" onclick="setValues()">Update User</button>
      <button type="button" onclick="document.getElementById('id06').style.display='none'" class="cancelbtn">Cancel</button>
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

<div class="topnav" id="myTopnav">
  <a href="${pageContext.request.contextPath}/home">Home</a>
  <a href="${pageContext.request.contextPath}/org">Organizations</a>
  <a href="${pageContext.request.contextPath}/users" class="active">Users</a>
  <a href="#" class="right" onclick="document.getElementById('id02').style.display='block'">Logout</a>
  <a href="#" class="right" onclick="document.getElementById('id03').style.display='block'">Account Settings</a>
	<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
    </a>
</div>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.organissembly.dao.AnnouncementDao,com.organissembly.bean.*,java.util.*"%>
<%
List<User> list = new ArrayList<User>();
list = (List<User>) session.getAttribute("list");
%>

<div style="width:flex;padding: 0px">
<div class="centeredDiv"><button onclick="document.getElementById('id05').style.display='block'" style="font-size:30px">Add New Users</button></div>
<div style="width:flex;border:1;padding:10px;">
<c:forEach items="${list}" var="u">
	<table style="width:100%;background:#FED250;border-radius:10px;padding-left:50px">
		<tr>
			<td style="width:85%;padding-left:50px"><p style="color:black;font-size: 18px"><strong>Student Number:</strong> ${u.getNumber()} <strong>| Name: </strong>${u.getFirstName()} ${u.getMiddleName()} ${u.getLastName()} <strong>| Year:</strong> ${u.getYear()} <strong>| Points:</strong> ${u.getUserPoints()} <strong>| Section:</strong> ${u.getSection()} <strong>| Date Added: </strong>${u.getDateCreated()}</p></td>
			<td style="width:15%">
				<button class="normalbtn" onclick="document.getElementById('editUserEmail').value='${u.getEmail()}';
										document.getElementById('editUserPassword').value='${u.getPassword()}';
										document.getElementById('editUserFirstName').value='${u.getFirstName()}';
										document.getElementById('editUserMiddleName').value='${u.getMiddleName()}';
										document.getElementById('editUserLastName').value='${u.getLastName()}';
										document.getElementById('editUserLevel').value='${u.getUserLevel()}';
										document.getElementById('editUserId').value='${u.getUserId()}';
										document.getElementById('editUserIdNumber').value='${u.getNumber()}';
										document.getElementById('editUserYear').value='${u.getYear()}';
										document.getElementById('editUserSection').value='${u.getSection()}';
										document.getElementById('id06').style.display='block'" style="border-radius:20px">Edit User</button>
			</td>
		</tr>
	</table>
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
var modal5 = document.getElementById('id05');
var modal6 = document.getElementById('id06');
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
    } else if (event.target == modal5) {
    	modal5.style.display = "none";
    } else if (event.target == modal6) {
    	modal6.style.display = "none";
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

function myFunction() {
	  var x = document.getElementById("myTopnav");
	  if (x.className === "topnav") {
	    x.className += " responsive";
	  } else {
	    x.className = "topnav";
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
