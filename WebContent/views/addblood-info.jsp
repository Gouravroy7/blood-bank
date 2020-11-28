<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Blood Info</title>
<link href="../css/addblood-info.css" rel="stylesheet" />
</head>
<body id="body">
   <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    if(session.getAttribute("hid")==null)
    {
    	response.sendRedirect("/bloodBank/views/hospital-login.jsp");
    }
   
   %>
    <%
    int id = Integer.parseInt(request.getParameter("id"));
    String sample = request.getParameter("sample");
    
       %>
   <div id="navbar">
     <span ><a class="navlink" href="${pageContext.request.contextPath}/HospitalController?action=available-blood-samples&user=hospital">Available Blood Samples</a></span>
     <span ><a class="navlink" href="${pageContext.request.contextPath}/HospitalController?action=view-requests&user=hospital&hid=<% out.println(id);%>">View Requests</a></span>
     <span ><a class="navlink" href="${pageContext.request.contextPath}/LogoutController">Logout</a></span>
   </div>
   <div style="color: blue;font-size: large ;font-weight: bold;margin-top: 10px;padding-top: 20px;margin-left: 150px;">
    <%
     if(sample!=null)
     {
    	 if(sample.equals("added"))
    	 {
    		 out.print("Samples Added Successfully");
    	 }
     }
    %>
   
   </div>
   <div id="main-container">
     <div id="main-header">
       <h1>Add Blood INFO</h1>
       
     </div>
     <div id="main-body">
       
       <form action="${pageContext.request.contextPath}/HospitalController?action=addblood&user=hospital" method="post">
         <input type="number" name="hid" value="<% out.print(id); %>" placeholder="Enter ID" class="form-content" /> <br>
         <input type="text" name="bloodgroups" placeholder="Enter Blood Groups With Space" required class="form-content" /> <br>
         <input type="Submit" value="Add Samples" class="formbtn" />
       </form>
     </div>
   </div>
</body>
</html>