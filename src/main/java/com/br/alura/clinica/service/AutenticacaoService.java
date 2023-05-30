package com.br.alura.clinica.service;

import com.br.alura.clinica.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDatails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
