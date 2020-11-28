<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Requests</title>
 <link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
</head>
<body>
<%
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("hid")==null)
    {
    	response.sendRedirect("/bloodBank/views/hospital-login.jsp");
    }
   
   %>
 <h1 style="text-align: center;margin-top: 16px;margin-bottom: 25px;">View Requests</h1>
  <div class="float-right" style="margin-top: -60px;margin-right: 180px;font-size: 18px;text-decoration: underline;">
      <a href="${pageContext.request.contextPath}/LogoutController">Logout</a>
   </div>
   <table style="text-align:center" border="1"  class="table table-striped table-bordered" id="datatable">
      <thead>
        <tr class="thead-dark">
        <th>Receiver ID</th>
        <th>Receiver Name</th>
        <th>Blood Group</th>
        
      </tr>
      </thead>
      
      <tbody>
        <c:forEach items="${list}" var="receiver">  
         <tr>
           <td>${receiver.rid}</td>
           <td>${receiver.rname}</td>
           <td>${receiver.bloodgroup}</td>
         </tr>
       </c:forEach>
      </tbody>
   </table>
   
   <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
   
   <script>
    $(document).ready(function() {
    	$("#datatable").DataTable();
    });
   </script>
</body>
</html>