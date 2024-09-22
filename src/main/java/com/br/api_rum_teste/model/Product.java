package com.br.api_rum_teste.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @NoArgsConstructor
@Getter @Setter @ToString @Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Integer quantity;

}
