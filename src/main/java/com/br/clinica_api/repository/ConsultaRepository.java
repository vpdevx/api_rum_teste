package com.br.clinica_api.repository;

import com.br.clinica_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    Optional<List<Consulta>> findByPacienteId(Long pacienteId);
    Optional<Consulta> findById(Long id);

    Optional<List<Consulta>> findByMedicoId(Long medicoId);
}
