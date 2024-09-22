package com.br.api_rum_teste.controller;

import com.br.api_rum_teste.model.Customer;
import com.br.api_rum_teste.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    /*
    Retorna todos os customers cadastrados
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Customer> customers = customerService.getAll();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    /*
    Retorna um customer pelo id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Long id){
        Customer customer = customerService.getById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*
    Adiciona um novo customer
     */
    @PostMapping("/add")
    public ResponseEntity<Customer> add(@RequestBody Customer customer){
        Customer novoCustomer = customerService.save(customer);
        return new ResponseEntity<>(novoCustomer, HttpStatus.CREATED);
    }

    /*
    Atualiza um customer
     */
    @PutMapping("/edit")
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        Customer customerAtualizado = customerService.update(customer);
        return new ResponseEntity<>(customerAtualizado, HttpStatus.OK);
    }

    /*
    Deleta um customer pelo id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
