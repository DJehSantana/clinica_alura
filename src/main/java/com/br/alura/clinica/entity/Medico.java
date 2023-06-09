package com.br.alura.clinica.entity;

import com.br.alura.clinica.enums.Especialidade;
import com.br.alura.clinica.record.MedicoAtualizacao;
import com.br.alura.clinica.record.MedicoCadastro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(MedicoCadastro dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarCadastro(MedicoAtualizacao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if(dados.dadosEndereco() != null) {
            this.endereco.atualizarEndereco(dados.dadosEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
