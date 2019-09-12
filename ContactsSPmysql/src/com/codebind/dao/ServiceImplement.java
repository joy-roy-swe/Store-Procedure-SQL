package com.codebind.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codebind.dto.Contacts;
import com.codebind.dto.Employee;
import com.codebind.jdbc.DBconnection;
import com.codebind.service.ContactsService;

public class ServiceImplement implements ContactsService{
	
	private static final String Section_SearchSection_Textfield = null;
	private DBconnection db;

	public ServiceImplement() {
		this.db = new DBconnection();
	}

	@Override
	public List<Contacts> contact_list() {
		System.out.println("In contact_list...");
		List<Contacts> lists = null;
		String sql = "{CALL SP_LIST}";
		System.out.println("query loaded...");
		try {
			Connection con = db.get_connection();
			System.out.println("In try catch...");
			if(con!=null) {
				System.out.println("connected...");
				CallableStatement cs = con.prepareCall(sql);
				
				ResultSet rs = cs.executeQuery();
				lists = new ArrayList<Contacts>();
				while(rs.next()) {
					Contacts contact = new Contacts();
					contact.setC_id(rs.getInt(1));
					contact.setC_name(rs.getString(2));
					contact.setC_mobile(rs.getInt(3));
					contact.setC_email(rs.getString(4));
					lists.add(contact);
				}
				cs.close();
			}
			System.out.println("not connected...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}

	@Override
	public void contact_insert(Contacts contact) {
		String sql = "{CALL SP_INSERT(?,?,?)}";
		
		try {
			Connection con = db.get_connection();
			if(con!=null) {
				CallableStatement cs = con.prepareCall(sql);
				
				cs.setString(1, contact.getC_name());
				cs.setInt(2, contact.getC_mobile());
				cs.setString(3, contact.getC_email());
				
				int exec = cs.executeUpdate();
				
				if(exec == 0) {
					throw new SQLException();
				}
				cs.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Contacts contact_find(int id) {
		
		Contacts  contact = null;
		String sql = "{CALL SP_SPECIFIC(?)}";
		
		try {
			Connection con = db.get_connection();
			
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				contact = new Contacts();
				
				contact.setC_id(rs.getInt(1));
				contact.setC_name(rs.getString(2));
				contact.setC_mobile(rs.getInt(3));
				contact.setC_email(rs.getString(4));
			}
			cs.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contact;
	}

	@Override
	public void contact_update(Contacts contact) {
		
		String sql = "{CALL SP_UPDATE(?,?,?,?)}";
		
		try {
			Connection con = db.get_connection();
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setString(1, contact.getC_name());
			cs.setInt(2, contact.getC_mobile());
			cs.setString(3, contact.getC_email());
			cs.setInt(4, contact.getC_id());
			
			int exec = cs.executeUpdate();
			
			if(exec == 0) {
				throw new SQLException();
			}
			cs.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contact_delete(int id) {
		
		String sql = "{CALL SP_DELETE(?)}";
		
		try {
			Connection con = db.get_connection();
			if(con!=null) {
				CallableStatement cs = con.prepareCall(sql);
				
				cs.setInt(1, id);
				int exec = cs.executeUpdate();
				
				if(exec == 0) {
					throw new SQLException();
				}
				cs.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> if_program(String department) {
				
		List<Employee> list = null;
		String sql = "{CALL SP_IF(?)}";
		try {
			Connection con = db.get_second_connection();
			
			if(con!=null) {
				System.out.println("connecct second database");
				CallableStatement cs = con.prepareCall(sql);
				
				cs.setString(1, department);
				int exec = cs.executeUpdate();
				
				if(exec == 0) {
					throw new SQLException();
				}
				cs.close();
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Employee> employee_list() {
			
		List<Employee> list = null;
		String sql = "{CALL SP_getEmployee()}";
		try {
			Connection con = db.get_second_connection();
			if(con!=null) {
				CallableStatement cs = con.prepareCall(sql);
				ResultSet rs = cs.executeQuery();
				list = new ArrayList<Employee>();
				while(rs.next()) {
					Employee obj_employee = new Employee();
					
					obj_employee.setE_id(rs.getInt(1));
					obj_employee.setE_name(rs.getString(2));
					obj_employee.setE_salary(rs.getInt(3));
					obj_employee.setDepartment(rs.getString(4));
					list.add(obj_employee);
					
				}
				cs.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	

}
