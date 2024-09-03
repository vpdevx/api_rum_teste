package com.br.clinica_api.service;

import com.br.clinica_api.model.Paciente;
import com.br.clinica_api.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service @AllArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> getAll(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }

    public Paciente getById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com ID: " + id));
    }

}
