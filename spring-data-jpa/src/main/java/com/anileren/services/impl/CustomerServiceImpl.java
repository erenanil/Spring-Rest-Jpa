package com.anileren.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anileren.dto.DtoAdress;
import com.anileren.dto.DtoCustomer;
import com.anileren.entities.Adress;
import com.anileren.entities.Customer;
import com.anileren.repositories.CustomerRepository;
import com.anileren.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer getCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAdress dtoAdress = new DtoAdress();

        Optional<Customer> optional = customerRepository.findById(id);
        
        if(optional.isEmpty()){
            return null;
        }

        Customer customer = optional.get();
        Adress adress = optional.get().getAdress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(adress, dtoAdress);

        dtoCustomer.setAdress(dtoAdress);
        
        return dtoCustomer;
    }

    

}
