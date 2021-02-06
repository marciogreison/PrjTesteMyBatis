package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class UpdateCustomerData {

	public static void test(String[] args) throws IOException {

		CustomerDao dao = DaoFactory.getCustomerDao();
		
		int id = 3;
		Customer c1 = dao.getCustomerById(id);
		if(c1==null) {
			System.out.println("No customer data for id: " + id);
		}
		else {
			System.out.println("Before updating...: " + c1);
			c1.setCity("Dallas");
			c1.setPhone("5552341122");
			dao.updateCustomer(c1);
			
			c1 = dao.getCustomerById(id);
			System.out.println("After updating...: " + c1);
			
		}
	}

}
