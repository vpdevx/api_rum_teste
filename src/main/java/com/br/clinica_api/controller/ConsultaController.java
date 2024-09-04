package com.br.clinica_api.controller;

import com.br.clinica_api.model.Consulta;
import com.br.clinica_api.service.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/consulta")
@AllArgsConstructor  
@CrossOrigin(origins = "*")
public class ConsultaController {

    private ConsultaService consultaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Consulta> consultas = consultaService.getAll();

        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consulta> add(Consulta consulta){
        Consulta novaConsulta = consultaService.save(consulta);
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Consulta> update(Consulta consulta){
        Consulta consultaAtualizada = consultaService.update(consulta);
        return new ResponseEntity<>(consultaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        consultaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable("id") Long id){
        Consulta consulta = consultaService.getById(id);

        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

}
