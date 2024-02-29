<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Display</title>
</head>
<body>
    <h2>Data from Database:</h2>
    <ul>
        <% 
            @SuppressWarnings("unchecked")
            List<String> dataList = (List<String>) request.getAttribute("dataList");
            if (dataList != null) {
                for (String data : dataList) { 
        %>
            <li><%= data %></li>
        <% 
                }
            }
        %>
    </ul>
</body>
</html>
