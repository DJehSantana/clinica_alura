package com.br.alura.clinica.controller;

import com.br.alura.clinica.entity.Usuario;
import com.br.alura.clinica.record.DadosAutenticacao;
import com.br.alura.clinica.service.TokenService;

@RestController
@RequestMapping("/login")
public class AuntenticacaoController {

    @Autowired
    private AthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
