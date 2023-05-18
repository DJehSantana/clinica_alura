package com.br.alura.clinica.record;

import com.br.alura.clinica.enums.Especialidade;

public record MedicoCadastro(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

}
