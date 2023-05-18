package com.br.alura.clinica.repository;

import com.br.alura.clinica.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
