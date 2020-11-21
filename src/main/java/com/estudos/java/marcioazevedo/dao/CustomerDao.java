package com.estudos.java.marcioazevedo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.estudos.java.marcioazevedo.entity.Customer;

public interface CustomerDao {

	// CRUD OPERATIONS
	
	@Insert("insert into customers (name, city, email, phone) values (#{name}, #{city}, #{email}, #{phone})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addCustomer(Customer customer);
	
	@Select("select * from customers where id=#{id}")
	public Customer getCustomerById(Integer id);
	
	@Update("update customers set name=#{name}, city=#{city}, email=#{email}, phone=#{phone} where id=#{id}")
	public void updateCustomer(Customer customer);
	
	@Delete("delete from customers where id=#{id}")
	public void deleteCustomer(Integer id);
	
	// QUERIES
	
	@Select("select * from customers")
	public List<Customer> getAllCustomers();
	
	@Select("select * from customers where city=#{city}")
	public List<Customer> getCustomersByCity(String city);
}
