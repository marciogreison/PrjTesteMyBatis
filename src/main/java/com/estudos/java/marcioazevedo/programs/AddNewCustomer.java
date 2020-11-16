package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class AddNewCustomer {

	public static void main(String[] args) throws IOException {
		CustomerDao dao = DaoFactory.getCustomerDao();
		
		Customer c1 = new Customer();
		c1.setName("teste");
		c1.setCity("lavras");
		c1.setEmail("teste@dsffdsfdsf");
		c1.setPhone("6546465456564564");
		
		dao.addCustomer(c1);
	}
}
