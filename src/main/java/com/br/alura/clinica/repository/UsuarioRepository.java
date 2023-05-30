package com.br.alura.clinica.repository;

import com.br.alura.clinica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDatails findByLogin(String login);
}
