package com.br.clinica_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity @NoArgsConstructor
@Getter @Setter @ToString @Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private Date data_nascimento;

    @Column(nullable = false)
    private Date data_cadastro;

}
