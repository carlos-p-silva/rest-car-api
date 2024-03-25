package com.caps.rentcarapi.repository;

import com.caps.rentcarapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
