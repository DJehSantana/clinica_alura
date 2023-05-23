package com.br.alura.clinica.controller;

import com.br.alura.clinica.entity.Medico;
import com.br.alura.clinica.record.MedicoCadastro;
import com.br.alura.clinica.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public MedicoCadastro cadastrar(@RequestBody @Valid MedicoCadastro medico) {
        medicoRepository.save(new Medico(medico));
        return medico;
    }
}
