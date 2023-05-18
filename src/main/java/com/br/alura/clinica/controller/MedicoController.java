package com.br.alura.clinica.controller;

import com.br.alura.clinica.record.MedicoCadastro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @PostMapping
    public MedicoCadastro cadastrar(@RequestBody MedicoCadastro medico) {
        return medico;
    }
}
