package com.br.alura.clinica.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Endereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String numero,
        String complemento) {

}
