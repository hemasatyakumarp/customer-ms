package com.hackerrank.customer.service;

import com.hackerrank.customer.exception.NoSuchResourceFoundException;
import com.hackerrank.customer.model.Customer;
import com.hackerrank.customer.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
    public CustomerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    public Boolean deleteCustomerById(Long id) {
    	 Boolean b = customerRepository.existsById(id);

         if (!b) {
             return false;
         } else {         
        customerRepository.deleteById(id);
        return true;
         }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getId())){
            return null;
        }

        customerRepository.save(customer);
        return customerRepository.findById(customer.getId()).get();
    }
    
    @Override
    public Customer updateCustomer(Long customerId,Customer customer) {
        
        Customer tempCustomer = customerRepository.findById(customer.getId()).get();

        if (tempCustomer == null) {
            return null;
        }
       
        customerRepository.save(customer);
        return customerRepository.findById(customerId).get();
        
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).get();

        if (customer == null) {
            throw new NoSuchResourceFoundException("No Customer with given id found.");
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
