package com.codebind.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codebind.dao.ServiceImplement;
import com.codebind.dto.Contacts;


@WebServlet("/AddContractController")
public class AddContractController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Contacts contact = new Contacts();
		
		contact.setC_name(request.getParameter("name"));
		contact.setC_mobile(Integer.parseInt(request.getParameter("mobile")));
		contact.setC_email(request.getParameter("email"));
		
		ServiceImplement obj_ServiceImplement = new ServiceImplement();
		obj_ServiceImplement.contact_insert(contact);
		
		response.sendRedirect("seeList.jsp");
	}

}
