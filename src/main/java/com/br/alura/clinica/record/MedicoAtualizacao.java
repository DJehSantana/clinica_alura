package com.br.alura.clinica.record;

import jakarta.validation.constraints.NotNull;

public record MedicoAtualizacao(
        @NotNull
        Long id,
        String nome,
        Endereco dadosEndereco) {

}
