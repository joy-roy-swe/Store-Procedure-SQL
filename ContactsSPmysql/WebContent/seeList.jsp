<%@page import="com.codebind.dto.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.codebind.dto.Contacts"%>
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

<form action="AddContractController" method="post">

	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		
		<tr>
			<td>Mobile:</td>
			<td><input type="text" name="mobile"></td>
		</tr>
		
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Add Contact"></td>
		</tr>
	</table>

</form>


<hr>

All contacts:
<br>

<%
	ServiceImplement obj_ServiceImplement = new ServiceImplement();
	List<Contacts> list = obj_ServiceImplement.contact_list();
	
	Iterator<Contacts> it_list = list.iterator();
%>
<table border="1">
<% 	
	while(it_list.hasNext()){
		Contacts obj_contacts = new Contacts();
		obj_contacts = it_list.next();

%>

<tr>
	<td><%=obj_contacts.getC_id() %></td>
	<td><%=obj_contacts.getC_name() %></td>
	<td><%=obj_contacts.getC_mobile() %></td>
	<td><%=obj_contacts.getC_email() %></td>
	
	<td>
		<a href="deleter.jsp?id=<%=obj_contacts.getC_id()%>"> Delete</a>
	</td>
	
</tr>
<% } %>
	


</table>	

<hr>

If statement:

<form action="if_statement.jsp">
	<tr>
		<td>Department name:</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td><input type="submit" value="See">
	</tr>

</form>
<hr>

<%
	
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