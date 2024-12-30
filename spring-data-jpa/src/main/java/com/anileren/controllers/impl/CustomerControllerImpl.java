package com.anileren.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anileren.controllers.ICustomerController;
import com.anileren.dto.DtoCustomer;
import com.anileren.dto.DtoCustomerIU;
import com.anileren.services.ICustomerService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{
    
    @Autowired
    private ICustomerService customerService;

    @Override
    @GetMapping(path = "/list/{id}")
    public DtoCustomer getCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/list")
    public List<DtoCustomer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/create")
    public DtoCustomer createCustomer(@RequestBody DtoCustomerIU customerIU) {
        return customerService.createCustomer(customerIU);
    }

    @PutMapping("/update/{id}")
    public DtoCustomer updateCustomer(@PathVariable Long id, @RequestBody DtoCustomerIU customerIU) {
        return customerService.updateCustomer(id, customerIU);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
    



    

