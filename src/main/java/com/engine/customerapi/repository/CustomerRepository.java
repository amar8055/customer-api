package com.engine.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engine.customerapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
