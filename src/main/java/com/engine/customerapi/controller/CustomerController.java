package com.engine.customerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engine.customerapi.model.Customer;
import com.engine.customerapi.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/hello")
	public String sayHello() {
		
		return "Hi this is my customer class";
	}
	
	//Get All Customers
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		
		return customerService.getAll();
		
		
	}
		
	//Get One Customer
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable int id){
		
		return customerService.getById(id);
	}
	
	
	//Post Customer
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer){
		
		return customerService.create(customer);
	}
	
	
	//Update customer
	@PutMapping("/customers/{id}")
	public Customer update(@PathVariable int id,@RequestBody Customer customer) throws Exception {
		
		return customerService.update(id, customer);
	}
	
	
	//Delete
	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable int id) throws Exception {
		
		customerService.delete(id);
		
	}
}
