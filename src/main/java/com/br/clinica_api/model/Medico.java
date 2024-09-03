package com.br.clinica_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity @NoArgsConstructor
@Getter @Setter @ToString @Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String telefone;
    private String email;

    @Column(nullable = false)
    private String crm;

    private String especialidade;

    @Column(nullable = false)
    private Date data_cadastro;

}
