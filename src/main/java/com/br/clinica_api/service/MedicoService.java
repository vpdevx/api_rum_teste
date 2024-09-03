package com.br.clinica_api.service;

import com.br.clinica_api.model.Medico;
import com.br.clinica_api.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class MedicoService {
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico update(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico getById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com ID: " + id));
    }

    public List<Medico> getAll(){
        List<Medico> medicos = medicoRepository.findAll();
        return medicos;
    }
}
