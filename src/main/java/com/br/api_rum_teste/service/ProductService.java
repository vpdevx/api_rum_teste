package com.br.api_rum_teste.service;

import com.br.api_rum_teste.model.Product;
import com.br.api_rum_teste.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAll(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product not found ID: " + id));
    }
}
