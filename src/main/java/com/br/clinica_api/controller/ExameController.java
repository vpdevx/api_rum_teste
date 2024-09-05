package com.br.clinica_api.controller;

import com.br.clinica_api.model.Exame;
import com.br.clinica_api.service.ExameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/exame")
@AllArgsConstructor @CrossOrigin(origins = "https://clinica-frontend.k8s.lab4ever.xyz")
public class ExameController {
    private ExameService exameService;

    /*
        Adiciona um novo exame
     */
    @PostMapping("/add")
    public ResponseEntity<Exame> add(Exame exame){
        Exame novoExame = exameService.save(exame);
        return new ResponseEntity<>(novoExame, HttpStatus.CREATED);
    }

    /*
        Atualiza um exame
     */
    @PutMapping("/edit")
    public ResponseEntity<Exame> update(Exame exame){
        Exame exameAtualizado = exameService.update(exame);
        return new ResponseEntity<>(exameAtualizado, HttpStatus.OK);
    }
    /*
        Deleta um exame pelo id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        exameService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
        Retorna um exame pelo id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Exame> getById(@PathVariable("id") Long id){
        Exame exame = exameService.getById(id);

        return new ResponseEntity<>(exame, HttpStatus.OK);
    }

    /*
     Retorna todos os exames cadastrados
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Exame> exames = exameService.getAll();

        return new ResponseEntity<>(exames, HttpStatus.OK);
    }



}
