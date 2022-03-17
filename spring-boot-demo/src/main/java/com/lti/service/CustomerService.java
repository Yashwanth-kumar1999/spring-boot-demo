package com.lti.service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.CustomerDao;
import com.lti.dto.Login;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;

@Component("customerService")
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public int register(Customer customer) {
		if(customerDao.isCustomerPresent(customer.getEmail())) {
			throw  new CustomerServiceException("customer already registered");
		}
		else {
		Customer updatedCustomer=(Customer) customerDao.save(customer);
		return updatedCustomer.getId();
		}
	}
	@Transactional
	public Customer login(Login login) {
		try {
			int id=customerDao.isValidUserV2(login.getEmail(),login.getPassword());
			Customer customer = customerDao.fetchById(Customer.class,id);
			return customer;
		}
		catch(NoResultException e) {
			throw new CustomerServiceException("invalid Email/Password");
		}
	
		
	}
	
}