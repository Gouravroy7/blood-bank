<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<link href="../css/registration.css" rel="stylesheet">
</head>
<body id="body">
  <div id="main-container">
   <div id="main-header">
    <h1>HOSPITAL REGISTRATION</h1>
   </div>
   <div id="main-body">
    <form action="${pageContext.request.contextPath}/RegistrationController?action=hospital-registration" method="post">
     <input type="number" name="hid" placeholder="Enter ID" class="form-content" required /><br><br>
     <input type="text" name="hname" placeholder="Enter Name" class="form-content" required /><br><br>
     <input type="text" name="hlocation" placeholder="Enter Location" class="form-content" required /><br><br>
     <input type="password" name="hpassword" placeholder="Enter Password" class="form-content" required /><br><br>
     <input type="Submit" value="REGISTER" class="formbtn" />
  </form>
   </div>
  </div>
</body>
</html>