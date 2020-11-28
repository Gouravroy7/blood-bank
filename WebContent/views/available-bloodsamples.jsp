<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Samples</title>
 <link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>

 <%
 String user = request.getParameter("user");
 String status = request.getParameter("status");
  String link = "";
  if(user==null)
  {
	  link="views/receiver-login.jsp?";
  }
  else if(user.equals("receiver"))
  {
	  int uid = Integer.parseInt(request.getParameter("uid"));
	  link="views/request-sample.jsp?uid="+uid+"&";
  }
  else if(user.equals("hospital"))
  {
	  link="#";
	  %>
	  <style>
	    .req-link{
	     cursor: not-allowed;
         opacity: 0.5;
         text-decoration:none;
	    }
	  </style>
<% 
  }
  
 %>
 </head>
<body>
   <h1 style="text-align: center;margin-top: 16px;margin-bottom: 25px;">Available Samples</h1>
   <div class="float-right" style="margin-top: -60px;margin-right: 150px;font-size: 18px;text-decoration: underline;">
      <a href="../bloodBank/index.jsp">Home</a>
    </div>
   <div class="container">
    <div class="float-left" style="color: blue; font-size: 20px;font-weight: bolder;">
      <%
       if(status!=null){
    	   if(user.equals("receiver") && status.equals("requested"))
    		   out.println("Sample Request Sent");
       }
       
      %>
      <br>
    </div>
    
     <table style="text-align:center" border="1"  class="table table-striped table-bordered" id="datatable">
      <thead>
        <tr class="thead-dark">
        <th>Hospital ID</th>
        <th>Hospital Name</th>
        <th>Available Samples</th>
        <th>Actions</th> 
      </tr>
      </thead>
      
      <tbody>
        <c:forEach items="${list}" var="hospital">  
         <tr>
           <td>${hospital.id}</td>
           <td>${hospital.name}</td>
           <td>${hospital.bloodgroups}</td>
           <td>
               <a href="<% out.println(link); %>hid=${hospital.id}" class="req-link">Request Sample</a>  
           </td>
         </tr>
       </c:forEach>
      </tbody>
   </table>
   </div>
   <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
   
   <script>
    $(document).ready(function() {
    	$("#datatable").DataTable();
    });
   </script>
</body>
</html>