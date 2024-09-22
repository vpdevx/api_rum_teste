package com.br.api_rum_teste.service;

import com.br.api_rum_teste.model.Customer;
import com.br.api_rum_teste.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("customer não encontrado com ID: " + id));
    }

}
