package com.ijv.internjava.controller;


import com.ijv.internjava.model.dto.CustomerDto;
import com.ijv.internjava.service.CustomerService;
import com.ijv.internjava.service.impl.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    /*Get all*/
    @GetMapping
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    /*Get customer detail*/
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> detail(@PathVariable(name = "id") Long id) {
        CustomerDto customerDtoResponse = customerService.detail(id);
        return ResponseEntity.ok().body(customerDtoResponse);
    }

    /*Add customer*/
    @PostMapping("/add")
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.add(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    /*Update customer*/
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable("id") long customerId, @RequestBody CustomerDto customerDto) {
        customerDto.setId(customerId);
        CustomerDto updatedCustomer = customerService.update(customerId,customerDto);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    /*Delete customer*/
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") long customerId) {
        customerService.delete(customerId);
    }
}
