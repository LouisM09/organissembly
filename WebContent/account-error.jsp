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

<div class="header">
  <h1>Organissembly</h1>
  <p>An <b>student hub</b> for the growling tigers.</p>
  <a href="http://localhost:8080/organissembly/">
  <img src="Logo_of_the_UST_Growling_Tigers.svg" alt="Avatar" class="avatar">
  </a>
  <div style="position:absolute;bottom:0;right:0;" align="right">
    <%
    out.println("<b>"+"Failed to update!!"+"</b>");
    %>
  </div>
</div>

<div class="navbar">
  <a href="#" class="active">Home</a>
  <a href="#">Organizations</a>
  <a href="#" class="right" onclick="document.getElementById('id02').style.display='block'">Logout</a>
  <a href="#" class="right" onclick="document.getElementById('id01').style.display='block'">Login</a>
</div>

<div class="row">
  <div class="main">
    <h2>ONLINE CLASSES</h2>
    <h5>Classes resume in the form of web meetings and seminars, Oct. 10, 2020</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>learning continues...</p>
    <p>Most schools and universities have opted to continue learning in the form of Online Classes..</p>
    <br>
    <h2>GCQ CONTINUES FOR METRO MANILA</h2>
    <h5>Trends are not looking good, Oct. 09, 2020</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>COVID Pandemic still rages on...</p>
    <p>Despite the measures taken by the Government and the people, Metro Manila is still under GCQ..</p>
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
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    } else if (event.target == modal2) {
    	modal2.style.display = "none";
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
</script>

</body>
</html>
