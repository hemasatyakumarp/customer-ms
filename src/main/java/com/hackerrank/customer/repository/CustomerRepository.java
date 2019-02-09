package com.hackerrank.customer.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.customer.model.Customer;


@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    Long deleteById(Long id);
}
