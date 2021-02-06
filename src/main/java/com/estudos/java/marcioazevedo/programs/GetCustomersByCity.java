package com.estudos.java.marcioazevedo.programs;

import java.io.IOException;
import java.util.List;

import com.estudos.java.marcioazevedo.dao.CustomerDao;
import com.estudos.java.marcioazevedo.dao.DaoFactory;
import com.estudos.java.marcioazevedo.entity.Customer;

public class GetCustomersByCity {

	public static void test(String[] args) throws IOException {
		CustomerDao dao = DaoFactory.getCustomerDao();
		
		String city = "Mysore";
		List<Customer> list = dao.getCustomersByCity(city);
		
		System.out.println("There are " + list.size() + " customers from " + city);
		for(Customer c: list) {
			System.out.println(c);
		}
	}

}
