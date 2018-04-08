package com.engine.customerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engine.customerapi.model.Customer;
import com.engine.customerapi.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// FindAll
	public List<Customer> getAll() {

		return customerRepository.findAll();

	}

	// Find One
	public Customer getById(int id) {

		return customerRepository.findOne(id);
	}

	// Create
	public Customer create(Customer customer) {

		return customerRepository.save(customer);
	}

	// Update
	public Customer update(int id, Customer customer) throws Exception {

		Customer customerdb = this.getById(id);

		if (customerdb == null) {

			throw new Exception("You Did a terrible Mistake" + id + "does not exist");

		}

		return customerRepository.save(customerdb);
	}

	// Delete
	public void delete(int id) throws Exception {

		Customer customerDelete = this.getById(id);

		if (customerDelete == null) {

			throw new Exception("You Did a terrible Mistake" + id + "does not exist");

		}

		customerRepository.delete(id);

	}

}
