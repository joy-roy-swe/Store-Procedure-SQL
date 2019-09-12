<%@page import="com.codebind.dao.ServiceImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	ServiceImplement obj_ServiceImplement = new ServiceImplement();
	obj_ServiceImplement.contact_delete(id);
%>
<script type="text/javascript">
	window.location.href="http://localhost:8080/ContactsSPmysql/seeList.jsp"

</script>
</body>
</html>