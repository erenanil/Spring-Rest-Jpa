package com.anileren.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anileren.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
