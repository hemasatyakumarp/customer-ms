package com.hackerrank.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.customer.service.CustomerServiceImpl;
import com.hackerrank.customer.model.*;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = service.getAllCustomers();
		return new ResponseEntity(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		Customer c = service.getCustomerById(id);
		if (c == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(c, HttpStatus.OK);

	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		return new ResponseEntity(service.createCustomer(customer), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,@RequestBody Customer customer) {

		Customer c = service.updateCustomer(customerId, customer);
		if (c == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(c, HttpStatus.OK);

	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		Boolean b = service.deleteCustomerById(id);
		if (b) {
			return new ResponseEntity("Customer Deleted", HttpStatus.OK);
		}

		return new ResponseEntity("Customer Not Found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllCustomer() {
		service.deleteAllCustomers();
		return new ResponseEntity("Customers Deleted", HttpStatus.OK);
	}

}
