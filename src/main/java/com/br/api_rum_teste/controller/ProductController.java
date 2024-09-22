package com.br.api_rum_teste.controller;

import com.br.api_rum_teste.model.Product;
import com.br.api_rum_teste.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Product> products = productService.getAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        Product product = productService.getById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        Product novoProduct = productService.save(product);
        return new ResponseEntity<>(novoProduct, HttpStatus.CREATED);
    }


    @PutMapping("/edit")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product productUpdated = productService.update(product);
        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
