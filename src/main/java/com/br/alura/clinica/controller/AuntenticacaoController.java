package com.br.alura.clinica.controller;

import com.br.alura.clinica.record.DadosAutenticacao;

@RestController
@RequestMapping("/login")
public class AuntenticacaoController {

    @Autowired
    private AthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();

    }
}
