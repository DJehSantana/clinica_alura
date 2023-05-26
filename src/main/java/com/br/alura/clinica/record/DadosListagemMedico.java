package com.br.alura.clinica.record;

import com.br.alura.clinica.entity.Medico;
import com.br.alura.clinica.enums.Especialidade;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
