<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="registration.DAO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>User successfully registered!</h1>
 <a href="user-list.jsp">View users</a>
 
 <h2>Add Users</h2>
 <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="passowrd" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="email" name="email" /></td>
    </tr>
    <tr>
     <td>Sex</td>
     <td><input type="radio" name="sex" value="male"/>Male   
     <input type="radio" name="sex" value="female"/>Female </td>
    </tr>
    <tr>
     <td>Country</td>
     <td><input type="text" name="country" /></td>
    </tr>
   
   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>
