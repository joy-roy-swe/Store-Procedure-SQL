package com.codebind.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codebind.dao.ServiceImplement;


@WebServlet("/IfStatement")
public class IfStatement extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input_value = request.getParameter("name");
		ServiceImplement obj_ServiceImplement = new ServiceImplement();
		obj_ServiceImplement.if_program(input_value);
		
		
		response.sendRedirect("seeList.jsp");
	}

}
