package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class RetrieveCustomerById {

	public static void test(String[] args) throws IOException {

		CustomerDao dao = DaoFactory.getCustomerDao();
		
		int id = 22;
		Customer c1 = dao.getCustomerById(id);
		if(c1==null) {
			System.out.println("No customer data for id: " + id);
		}
		else {
			System.out.println(c1);
		}
	}

}
