package com.br.clinica_api.controller;

import com.br.clinica_api.model.Consulta;
import com.br.clinica_api.model.Exame;
import com.br.clinica_api.model.Paciente;
import com.br.clinica_api.service.ConsultaService;
import com.br.clinica_api.service.ExameService;
import com.br.clinica_api.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/paciente")
@AllArgsConstructor @CrossOrigin(origins = "https://clinica-frontend.k8s.lab4ever.xyz")
public class PacienteController {
    private PacienteService pacienteService;
    private ConsultaService consultaService;
    private ExameService exameService;
    /*
    Retorna todos os pacientes cadastrados
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Paciente> pacientes = pacienteService.getAll();

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    /*
    Retorna um paciente pelo id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") Long id){
        Paciente paciente = pacienteService.getById(id);

        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    /*
    Adiciona um novo paciente
     */
    @PostMapping("/add")
    public ResponseEntity<Paciente> add(@RequestBody Paciente paciente){
        Paciente novoPaciente = pacienteService.save(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    /*
    Atualiza um paciente
     */
    @PutMapping("/edit")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente){
        Paciente pacienteAtualizado = pacienteService.update(paciente);
        return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
    }

    /*
    Deleta um paciente pelo id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        pacienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    Retorna todas as consultas de um paciente
     */
    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<Consulta>> getConsultas(@PathVariable("id") Long id){
        List<Consulta> consultas = consultaService.getByPacienteId(id);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    /*
    Retorna todos os exames de um paciente
     */
    @GetMapping("/{id}/exames")
    public ResponseEntity<List<Exame>> getExames(@PathVariable("id") Long id){
        List<Exame> exames = exameService.getByPacienteId(id);
        return new ResponseEntity<>(exames, HttpStatus.OK);
    }

}
