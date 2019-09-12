package com.codebind.service;

import java.util.List;

import com.codebind.dto.Contacts;
import com.codebind.dto.Employee;

public interface ContactsService {
	
	public List<Contacts> contact_list();
	
	public void contact_insert(Contacts contact);
	
	public Contacts contact_find(int id);
	
	public void contact_update(Contacts contact);
	
	public void contact_delete(int id);
	
	public List<Employee> if_program(String department);
	
	public List<Employee> employee_list();

}
