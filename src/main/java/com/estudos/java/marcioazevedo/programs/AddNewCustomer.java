package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class AddNewCustomer {

	public static void test(String[] args) throws IOException {
		CustomerDao dao = DaoFactory.getCustomerDao();
		
		Customer c1 = new Customer();
		c1.setName("Marcio");
		c1.setCity("Azevedo");
		c1.setEmail("marcioazevedo@example.com");
		c1.setPhone("3423423423423");
		
		dao.addCustomer(c1);
		
		System.out.println(c1);
	}

}
