package com.br.alura.clinica.controller;

import com.br.alura.clinica.record.DadosDetalhamentoMedico;
import com.br.alura.clinica.record.DadosListagemMedico;
import com.br.alura.clinica.record.MedicoAtualizacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.br.alura.clinica.entity.Medico;
import com.br.alura.clinica.record.MedicoCadastro;
import com.br.alura.clinica.repository.MedicoRepository;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoCadastro dadosMedico, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dadosMedico);
        medicoRepository.save(medico);

        //Endereço da api
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        //O Spring cria o cabeçalho Location automaticamente baseado nessa uri
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    //Pelo @PageableDefault define atributos default da paginação, como
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //.map() -> está chamando o construtor do record DadosListagemMedico
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid MedicoAtualizacao dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarCadastro(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
       var medico = medicoRepository.getReferenceById(id);
       if (medico != null) {
           medico.excluir();
       }
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
