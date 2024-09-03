package com.br.clinica_api.service;

import com.br.clinica_api.model.Consulta;
import com.br.clinica_api.repository.ConsultaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class ConsultaService {
    private ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta update(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta getById(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com ID: " + id));
    }

    public List<Consulta> getByPacienteId(Long id){
        return consultaRepository.findByPacienteId(id)
                .orElseThrow(() -> new EntityNotFoundException("O paciente não possui consultas"));
    }

    public List<Consulta> getByMedicoId(Long id){
        return consultaRepository.findByMedicoId(id)
                .orElseThrow(() -> new EntityNotFoundException("O médico não é responsável por nenhuma consulta"));
    }

    public List<Consulta> getAll(){
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas;
    }

}
