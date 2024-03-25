package com.caps.rentcarapi.service;

import ch.qos.logback.core.model.Model;
import com.caps.rentcarapi.dto.CustomerDTO;
import com.caps.rentcarapi.entities.Customer;
import com.caps.rentcarapi.exceptions.ResourceNotFoundException;
import com.caps.rentcarapi.mapper.ModelMapperConfig;
import com.caps.rentcarapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional
    public List<CustomerDTO> findAll() {
        return ModelMapperConfig.parseListObject(repository.findAll(), CustomerDTO.class);
    }

    @Transactional
    public CustomerDTO findById(Long id) {
       var customer = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
       return ModelMapperConfig.parseObject(customer, CustomerDTO.class);
    }

    @Transactional
    public CustomerDTO create(CustomerDTO customer) {
      var entity =  ModelMapperConfig.parseObject(customer, Customer.class);
      return ModelMapperConfig.parseObject(repository.save(entity), CustomerDTO.class);
    }

    @Transactional
    public CustomerDTO update(CustomerDTO customerDTO) {
       var customer = repository.findById(customerDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
       customer.setId(customerDTO.getId());
       customer.setName(customerDTO.getName());
       customer.setCpf(customerDTO.getCpf());
       customer.setEmail(customerDTO.getEmail());
       customer.setPhone(customerDTO.getPhone());

       return ModelMapperConfig.parseObject(customer, CustomerDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        var customer = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this id"));
        repository.delete(customer);
    }

}
