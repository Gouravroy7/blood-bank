<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receiver Login</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body id="content">
  <div id="main-heading">
   <h1>Receiver Login</h1>
  </div>
  <div id="main-form">
   <%
  String status = request.getParameter("status");
  if(status!=null){
  if(status.equals("false"))
	  out.print("Invalid Login Credentials");
  }
  
  %>
   <form action="${pageContext.request.contextPath}/LoginController?action=receiver-login" method="post">
    <input type="number" name="rid" placeholder="Enter ID" class="form-content" required /><br><br>
    <input type="password" name="rpassword" placeholder="Enter Password"  class="form-content" required /><br><br>
    <p>
     <input type="Submit" value="LOGIN" class="formbtn" >
    </p>
  </form>
   <p>New User ? <a href="receiver-registration.jsp" class="form-content"  >Register Here</a></p>
  </div>
</body>
</html>