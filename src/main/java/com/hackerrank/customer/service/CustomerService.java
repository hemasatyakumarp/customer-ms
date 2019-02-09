package com.hackerrank.customer.service;

import com.hackerrank.customer.model.Customer;
import java.util.List;

public interface CustomerService {
    void deleteAllCustomers();
    Boolean deleteCustomerById(Long id);
    Customer createCustomer(Customer model);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
	Customer updateCustomer(Long customerId,Customer customer);
}
