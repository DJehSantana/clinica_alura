package com.br.alura.clinica.record;

import com.br.alura.clinica.entity.Endereco;
import com.br.alura.clinica.entity.Medico;
import com.br.alura.clinica.enums.Especialidade;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
