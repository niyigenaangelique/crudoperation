<%@page import="registration.DAO.UserDAO"%>  
<jsp:useBean id="u" class="registration.model.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDAO.delete(u);  
response.sendRedirect("user-list.jsp");  
%>  