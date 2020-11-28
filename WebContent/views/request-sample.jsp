<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Sample</title>
  <link rel="stylesheet" href="../css/addblood-info.css" /> 
</head>
 <%
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("hid")==null)
    {
    	response.sendRedirect("/bloodBank/views/receiver-login.jsp");
    }
   
   %>
<body id="body">
   
   <div style="margin-left: 90%; margin-right: 20%;padding-top: 20px;font-size :large ;">
     <a href="${pageContext.request.contextPath}/LogoutController">Logout</a>
   </div>
   <div id="main-container">
    <div id="main-header">
     <h1>Request Sample</h1>
    </div >
    <div id="main-body">
      <form action="${pageContext.request.contextPath}/ReceiverController?action=request-sample&user=receiver" method="post">
        <span class="form-label">Enter User ID</span> <br>
        <input type="number" name="uid" value=<% out.println(request.getParameter("uid")); %> placeholder="User ID" required class="form-content" /> <br><br>
        <span class="form-label">Enter Hospital ID</span> <br>
        <input type="number" name="hid" value=<% out.println(request.getParameter("hid")); %> placeholder="Hospital ID" required class="form-content" /> <br><br>
        <span class="form-label">Enter Blood Group</span>
        <input type="text" name="bloodgroup"  placeholder="Enter Blood Group" required class="form-content" /> <br><br>
        <input type="Submit" value="Request Sample" class="formbtn" />
   </form>
    </div>
   </div>
   
</body>
</html>