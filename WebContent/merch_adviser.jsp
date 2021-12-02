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

<div id="id06" class="modal">
  <form class="modal-content animate" action="${pageContext.request.contextPath}/update_merch" method="post" enctype="multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id06').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="leftImage" class="leftImage">
    </div>

    <div class="container">
      <label for="editTitle"><b>Merch Name</b></label>
      <input type="text" name="editTitle" id="editTitle" required>

      <label for="editBody"><b>Merch Description</b></label>
      <textarea rows=4 cols=40 name="editBody" id="editBody" required></textarea>
      
	  <label for="editImage"><b>Merch Image</b></label>
      <input type="file" name="editImage" id="editImage" onchange="document.getElementById('outputEdit').src = window.URL.createObjectURL(this.files[0])">
	  <div class="imgcontainer">
		<img id="outputEdit" name="outputEdit" src="" alt="Merch Image coming soon" class="leftImage" width="280px" height="280px">
      </div>
      
      <br><label for="editPrice"><b>Merch Price</b></label>
      <input type="text" placeholder="Enter Merch Price" name="editPrice" id="editPrice" required>
      
      <label for="editPostedBy"><b>Merch Posted By: </b></label>
      <br><select name="editPostedBy" id="editPostedBy" style="width:200px" required>
		<option value="org_presidentId">Organization President</option>
		<option value="org_secretaryId">Organization Secretary</option>
		<option value="org_proId">Organization P.R.O.</option>
	  </select>
	  
	  <br><label for="editIsApproved"><b>Is Approved Status: </b></label>
      <br><select name="editIsApproved" id="editIsApproved" style="width:100px" required>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
	  </select>
	  
	  <br><label for="editIsEnabled"><b>Is Enabled Status: </b></label>
      <br><select name="editIsEnabled" id="editIsEnabled" style="width:100px" required>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
	  </select>
	  
	  <input type="hidden" name="merchId" id="merchId"/>
      <input type="hidden" name="dateCreated" id="dateC"/>
      <button type="submit" onclick="setValues()">Update Merch</button>
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

<div class="navbar">
  <a href="${pageContext.request.contextPath}/home">Home</a>
  <a href="${pageContext.request.contextPath}/org">Organizations</a>
  <a href="${pageContext.request.contextPath}/members">Members</a>
  <a href="${pageContext.request.contextPath}/events">Events</a>
  <a href="${pageContext.request.contextPath}/participants">Participants</a>
  <a href="${pageContext.request.contextPath}/announcements">Announcements</a>
  <a href="${pageContext.request.contextPath}/merch" class="active">Merch</a>
  <a href="#" class="right" onclick="document.getElementById('id02').style.display='block'">Logout</a>
  <a href="#" class="right" onclick="document.getElementById('id03').style.display='block'">Account Settings</a>
</div>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.organissembly.dao.AnnouncementDao,com.organissembly.bean.*,java.util.*"%>
<%
List<Merch> list = new ArrayList<Merch>();
list = (List<Merch>) session.getAttribute("list");
%>

<div style="width:flex;padding: 0px">
<div style="width:flex;border:1;padding:10px;">
<c:forEach items="${list}" var="u">
	<div style="width:20%;min-width:300px;align-items:right;background:black;border-top-left-radius:50px;border-top-right-radius: 50px">
		<button class="normalbtn" onclick="document.getElementById('editIsApproved').value='${u.getMerchIsApproved()}';
											document.getElementById('editIsEnabled').value='${u.getMerchIsEnabled()}';
											document.getElementById('merchId').value='${u.getMerchId()}';
											document.getElementById('editPostedBy').value='${u.getMerchPostedById()}';
											document.getElementById('editPrice').value='${u.getMerchPrice()}';
											document.getElementById('editTitle').value='${u.getMerchName()}';
											document.getElementById('editBody').value='${u.getMerchDescription()}';
											document.getElementById('outputEdit').src='data:image/jpg;base64,${u.getBase64Image()}';
											document.getElementById('id06').style.display='block'" style="border-top-left-radius:50px;border-top-right-radius: 50px">Edit Merch</button>
	</div>
	<div class="centeredDiv" style="background:black;border:2px;border-color:white;border-bottom-left-radius:50px;border-bottom-right-radius: 50px;border-top-right-radius: 50px">
		<div style="width:flex;align-items:center"><h2 style="color:white;align-self:center;">${u.getMerchName()}</h2></div>
		<div style="width:flex;">
			<div class="centeredDiv" style="background:#FED250;border-top-left-radius:50px;border-top-right-radius:50px;">
  				<h2 style="color:black">${u.getMerchDescription()}</h2>
			</div>
			
			<div class="centeredDiv" style="background:#FEC825">
				<div class="imgcontainer">
					<img src="data:image/jpg;base64,${u.getBase64Image()}" class="leftImage" alt="Merch Image coming soon" width="280px" height="280px">
      			</div>
			</div>
			
			<div class="centeredDiv" style="background:#FEC825">
  				<h2 style="color:black">Approved Status: ${u.getMerchIsApproved()}</h2>
			</div>

			<div class="centeredDiv" style="background:#F3B701;border-bottom-left-radius:50px;border-bottom-right-radius:50px;">
		  		<h2 style="color:black">Enabled Status: ${u.getMerchIsEnabled()}</h2>
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

function setValues() {
	alert("Action has been processed");
	document.getElementById('dateC').value= Date();
	document.getElementById('dateU').value= Date();
}
</script>

</body>
</html>
