package com.tablero.kanban.usuarios.repository;

import org.springframework.data.repository.CrudRepository;

import com.tablero.kanban.usuarios.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
