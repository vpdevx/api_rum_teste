package com.br.clinica_api.controller;

import com.br.clinica_api.model.Exame;
import com.br.clinica_api.model.Medico;
import com.br.clinica_api.service.ConsultaService;
import com.br.clinica_api.service.ExameService;
import com.br.clinica_api.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/medico")
@AllArgsConstructor
public class MedicoController {

    private MedicoService medicoService;
    private ExameService exameService;
    private ConsultaService consultaService;

    /*
    Retorna todos os medicos cadastrados
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Medico> medicos = medicoService.getAll();

        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    /*
    Adiciona um novo medico
     */
    @PostMapping("/add")
    public ResponseEntity<Medico> add(Medico medico){
        Medico novoMedico = medicoService.save(medico);
        return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
    }

    /*
    Atualiza um medico
     */
    @PutMapping("/edit")
    public ResponseEntity<Medico> update(@RequestBody Medico medico){
        Medico medicoAtualizado = medicoService.update(medico);
        return new ResponseEntity<>(medicoAtualizado, HttpStatus.OK);
    }

    /*
    Deleta um medico pelo id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        medicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    Retorna um medico pelo id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable("id") Long id){
        Medico medico = medicoService.getById(id);

        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @GetMapping("/{id}/exames")
    public ResponseEntity<List<Exame>> getExames(@PathVariable("id") Long id){
        List<Exame> exames = exameService.getByMedicoId(id);
        return new ResponseEntity<>(exames, HttpStatus.OK);
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<?> getConsultas(@PathVariable("id") Long id){
        List<?> consultas = consultaService.getByMedicoId(id);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

}
