package com.br.clinica_api.repository;

import com.br.clinica_api.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExameRepository extends JpaRepository<Exame, Long> {

    Optional<Exame> findById(Long id);
    Optional<List<Exame>> findByPacienteId(Long pacienteId);

    Optional<List<Exame>> findByMedicoId(Long medicoId);
}
