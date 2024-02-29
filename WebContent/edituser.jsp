<%@page import="registration.DAO.UserDAO"%>  
<jsp:useBean id="u" class="registration.model.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=UserDAO.update(u);  
response.sendRedirect("user-form.jsp");  
%>  