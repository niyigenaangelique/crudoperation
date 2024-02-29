<%@page import="registration.DAO.UserDAO"%>  
<jsp:useBean id="u" class="registration.model.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=UserDAO.save(u);  
if(i>0){  
response.sendRedirect("userdetail.jsp");  
}else{  
response.sendRedirect("error.jsp");  
}  
%>  