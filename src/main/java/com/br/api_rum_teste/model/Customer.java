package com.br.api_rum_teste.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity @NoArgsConstructor
@Getter @Setter @ToString @Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;

}
