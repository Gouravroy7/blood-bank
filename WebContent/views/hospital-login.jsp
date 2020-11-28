<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Login</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body id="content">

  <div id="main-heading">
    <h1>HOSPITAL LOGIN</h1>
  </div>
  
  <div id="main-form">
   <%
  String status = request.getParameter("status");
  if(status!=null){
  if(status.equals("false"))
	  out.print("Invalid Login Credentials");
  }
  
  %>
   <form action="${pageContext.request.contextPath}/LoginController?action=hospital-login" method="post">
   
    <input type="number" name="hid" placeholder="Enter ID" class="form-content" required /><br><br>
    <input type="password" name="hpassword" placeholder="Enter Password"  class="form-content" required /><br><br>
    <p>
     <input type="Submit" value="LOGIN" class="formbtn" />
    </p>
    <p>New User ?<a href="hospital-registration.jsp" class="form-content"  />Register Here</a></p>
  </form>
  </div>
   
</body>
</html>