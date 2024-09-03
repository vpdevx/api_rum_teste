package com.br.clinica_api.service;

import com.br.clinica_api.model.Exame;
import com.br.clinica_api.repository.ExameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class ExameService {

    private ExameRepository exameRepository;

    public Exame save(Exame exame) {
        return exameRepository.save(exame);
    }

    public Exame update(Exame exame) {
        return exameRepository.save(exame);
    }

    public void delete(Long id) {
        exameRepository.deleteById(id);
    }

    public Exame getById(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exame não encontrado com ID: " + id));
    }

    public List<Exame> getByPacienteId(Long id){
        return exameRepository.findByPacienteId(id)
                .orElseThrow(() -> new EntityNotFoundException("O paciente não possui exames"));
    }

    public List<Exame> getByMedicoId(Long id){
        return exameRepository.findByMedicoId(id)
                .orElseThrow(() -> new EntityNotFoundException("O médico não é responsável por nenhum exames"));
    }
    public List<Exame> getAll(){
        List<Exame> exames = exameRepository.findAll();
        return exames;
    }

}
