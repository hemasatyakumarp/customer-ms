package com.hackerrank.customer.repository;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hackerrank.customer.model.Customer;


@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    void deleteById(Long id);
    Optional<Customer> findById(Long id);
}
