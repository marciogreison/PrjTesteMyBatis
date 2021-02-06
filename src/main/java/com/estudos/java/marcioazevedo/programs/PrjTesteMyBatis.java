package com.estudos.java.marcioazevedo.programs;
import java.io.IOException;

public class PrjTesteMyBatis {

	public static void main(String[] args) throws IOException, InterruptedException {
		while(true) {
			try {
				AddNewCustomer.test(args);
				Thread.sleep(1000l);
				DeleteCustomer.test(args);
				Thread.sleep(1000l);
				GetAllCustomers.test(args);
				Thread.sleep(1000l);
				RetrieveCustomerById.test(args);
				Thread.sleep(1000l);
				GetCustomersByCity.test(args);
				Thread.sleep(1000l);
				UpdateCustomerData.test(args);
				Thread.sleep(1000l);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
