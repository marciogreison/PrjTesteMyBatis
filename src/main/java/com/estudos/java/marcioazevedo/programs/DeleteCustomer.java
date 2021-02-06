package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class DeleteCustomer {

	public static void test(String[] args) throws IOException {
		CustomerDao dao = DaoFactory.getCustomerDao();
		
		int id = 12;
		
		Customer c1 = dao.getCustomerById(id);
		
		if(c1==null) {
			System.out.println("No data found for id " + id);
		}
		else {
			dao.deleteCustomer(id);
			System.out.println("Customer with id "+id+" is deleted.");
		}
		
	}
}
