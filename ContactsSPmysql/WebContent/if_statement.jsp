<%@page import="java.util.Iterator"%>
<%@page import="com.codebind.dto.Employee"%>
<%@page import="java.util.List"%>
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
	ServiceImplement obj_ServiceImplement = new ServiceImplement();
	List<Employee> obj_list = obj_ServiceImplement.employee_list();
	Iterator<Employee> obj_it_list = obj_list.iterator();
	

%>
<table border="1">

<% 	
	while(obj_it_list.hasNext()){
		Employee obj_Employee = new Employee();
		obj_Employee = obj_it_list.next();

%>
<tr>
	<td><%=obj_Employee.getE_id() %></td>
	<td><%=obj_Employee.getE_name() %></td>
	<td><%=obj_Employee.getE_salary() %></td>
	<td><%=obj_Employee.getDepartment() %></td>
	
</tr>
<% } %>


</body>
</html>